package com.blessedbin.frame.ucenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.ui.TreeNode;
import com.blessedbin.frame.common.validate.PostMethodValidationGroup;
import com.blessedbin.frame.ucenter.entity.SysDepartment;
import com.blessedbin.frame.ucenter.service.ISysDepartmentService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by xubin on 2018/7/9.
 * 部门管理
 * @author 37075
 * @date 2018/7/9
 * @time 17:04
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/department")
@Api(description = "部门管理")
@Log4j2
public class DepartmentController {

    @Autowired
    private ISysDepartmentService departmentService;

    @RequestMapping("/tree.json")
    public SimpleResponse<List<TreeNode>> treeTables(){
        return SimpleResponse.ok(departmentService.getDepartmentTree());
    }


    /**
     * @param department
     * @return
     */
    @PostMapping
    public SimpleResponse add(@RequestBody @Validated(PostMethodValidationGroup.class) SysDepartment department) {
        log.debug("request department param:{}",department);

        if(department.getPid() == null || department.getPid() == -1){
            LambdaQueryWrapper<SysDepartment> wrapper = new LambdaQueryWrapper<>();
            wrapper.isNull(SysDepartment::getPid);
            if(departmentService.exists(wrapper)){
                throw new ParamCheckRuntimeException("同级下名称重复");
            }
            department.setPid(null);
        } else {
            LambdaQueryWrapper<SysDepartment> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(SysDepartment::getName,department.getName()).eq(SysDepartment::getPid,department.getPid());
            if(departmentService.exists(wrapper)){
                throw new ParamCheckRuntimeException("同级下名称重复");
            }
        }

        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());

        departmentService.save(department);

        return SimpleResponse.created("创建成功",department);
    }

}
