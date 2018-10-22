package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.ui.CascaderNode;
import com.blessedbin.frame.common.ui.TreeNode;
import com.blessedbin.frame.common.validate.PostMethodValidationGroup;
import com.blessedbin.frame.ucenter.entity.SysDepartment;
import com.blessedbin.frame.ucenter.service.DepartmentService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private DepartmentService departmentService;

    @RequestMapping("/tree.json")
    public SimpleResponse<List<TreeNode>> treeTables(){
        return SimpleResponse.ok(departmentService.getDepartmentTree());
    }

    @GetMapping("/cascader.json")
    public SimpleResponse<List<CascaderNode>> cascaderList(@RequestParam Integer organizationId){
        List<CascaderNode> cascaders = departmentService.getCascaders(organizationId);
        return SimpleResponse.ok(cascaders);
    }

    /**
     * TODO 添加部门
     * @param department
     * @return
     */
    @PostMapping
    public SimpleResponse add(@RequestBody @Validated(PostMethodValidationGroup.class) SysDepartment department) {
        log.debug("request department param:{}",department);

       /* if(department.getPid() == null || department.getPid() == -1){
            SysDepartmentExample example = new SysDepartmentExample();
            example.createCriteria().andPidEqualTo(department.getPid()).andNameEqualTo(department.getName());
            if(departmentService.checkExistsByExample(example)){
                throw new ParamCheckRuntimeException("同级下名称重复");
            }
            department.setPid(null);
        } else {
            SysDepartmentExample example = new SysDepartmentExample();
            example.createCriteria().andNameEqualTo(department.getName()).andPidIsNull();
            if(departmentService.checkExistsByExample(example)){
                throw new ParamCheckRuntimeException("同级下名称重复");
            }
        }

        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());

        departmentService.save(department);*/

        return SimpleResponse.created("创建成功",department);
    }

}
