package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.ui.SelectNode;
import com.blessedbin.frame.common.validate.PostMethodValidationGroup;
import com.blessedbin.frame.common.validate.PutMethodValidationGroup;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.modal.SysOrganization;
import com.blessedbin.frame.ucenter.modal.SysOrganizationExample;
import com.blessedbin.frame.ucenter.service.OrganizationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 11:02
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "${frame.base-path.ucenter}/organization")
@Api(description = "组织管理")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    /**
     * TODO 参数验证
     * @param organization
     */
    @PostMapping
    @FrameApi
    public SimpleResponse<SysOrganization> add(@RequestBody @Validated(PostMethodValidationGroup.class) SysOrganization organization){
        SysOrganizationExample example = new SysOrganizationExample();
        example.createCriteria().andNameEqualTo(organization.getName());
        if(organizationService.checkExistsByExample(example)){
            throw new ParamCheckRuntimeException("名称重复");
        }

        organizationService.insert(organization);
        SysOrganization select = organizationService.selectByPk(organization.getId());
        return SimpleResponse.created("创建成功",select);
    }


    @GetMapping
    @FrameApi
    public SimpleResponse<SysOrganization> getOne(@RequestParam Integer id){
        return SimpleResponse.ok(organizationService.selectByPk(id));
    }

    @DeleteMapping
    @FrameApi
    public SimpleResponse delete(@RequestParam Integer id){
        organizationService.deleteByPk(id);
        return SimpleResponse.deleted();
    }

    /**
     * 修改
     * @param organization
     * @return
     */
    @PutMapping
    @FrameApi
    public SimpleResponse update(@RequestBody @Validated(PutMethodValidationGroup.class) SysOrganization organization){
        SysOrganizationExample example  = new SysOrganizationExample();
        example.createCriteria().andNameEqualTo(organization.getName()).andIdNotEqualTo(organization.getId());
        if(organizationService.checkExistsByExample(example)){
            throw new ParamCheckRuntimeException("名称重复");
        }

        organizationService.updateByPkSelective(organization);
        return SimpleResponse.accepted();
    }

    @GetMapping("/datatable.json")
    @FrameApi
    public SimpleResponse<Pagination<SysOrganization>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                                @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                                @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Pagination<SysOrganization> dataTable = organizationService.getDataTable(pageNum, pageSize);
        return SimpleResponse.ok(dataTable);
    }

    @GetMapping("/select.json")
    @FrameApi
    public SimpleResponse<List<SelectNode>> selectList(){
        List<SysOrganization> units = organizationService.selectAll();
        List<SelectNode> selectNodes = units.stream().map(organization ->
                SelectNode.builder().label(organization.getName())
                .value(String.valueOf(organization.getId()))
                .build())
                .collect(Collectors.toList());
        return SimpleResponse.ok(selectNodes);
    }

}
