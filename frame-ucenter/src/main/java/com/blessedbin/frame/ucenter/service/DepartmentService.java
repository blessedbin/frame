package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.common.ui.CascaderNode;
import com.blessedbin.frame.ucenter.entity.dto.DepartmentDto;
import com.blessedbin.frame.ucenter.modal.SysDepartment;
import com.blessedbin.frame.ucenter.modal.SysDepartmentExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 17:05
 * @tool intellij idea
 */
@Service
public class DepartmentService extends AbstractMysqlCrudServiceImpl<SysDepartment,Integer> {

    @Autowired
    private OrganizationService organizationService;

    public List<DepartmentDto> getDepartmentTree() {
        return buildDepartmentTree(null);
    }

    /**
     * 递归构建树
     * @param department
     * @return
     */
    private List<DepartmentDto> buildDepartmentTree(SysDepartment department){
        return getAllByPid(department == null ? null : department.getId())
                .stream().map(dt -> {
            DepartmentDto dto = new DepartmentDto();
            BeanUtils.copyProperties(dt,dto);

            // 查找并设置组织名称
            String organizationName = organizationService.selectNameByPk(dt.getOrganizationId());
            dto.setOrganizationName(organizationName);

            dto.setChildren(buildDepartmentTree(dt));
            return dto;
        }).collect(Collectors.toList());
    }

    public List<SysDepartment> getTopAll(){
        SysDepartmentExample example = new SysDepartmentExample();
        example.createCriteria().andPIdIsNull();
        example.setOrderByClause("sort ASC");

        return mapper.selectByExample(example);
    }

    public List<SysDepartment> getAllByPid(Integer pid){
        if(pid == null){
            return getTopAll();
        }

        SysDepartmentExample example = new SysDepartmentExample();
        example.createCriteria().andPIdEqualTo(pid);
        example.setOrderByClause("sort ASC");

        return mapper.selectByExample(example);
    }

    /**
     * 找到组织下的department列表
     * @param organizationId
     * @return
     */
    public List<CascaderNode> getCascaders(Integer organizationId) {
        List<CascaderNode> nodes = new ArrayList<>();
        List<CascaderNode> cascaderNodes = buildCascader(null,organizationId);
        if (cascaderNodes != null) {
            nodes.addAll(cascaderNodes);
        }
        return nodes;
    }

    private List<CascaderNode> buildCascader(Integer parentId,Integer organizationId) {
        return getAllByPid(parentId,organizationId).stream().map(department -> CascaderNode.builder()
                .value(String.valueOf(department.getId()))
                .label(department.getDepartmentName())
                .children(buildCascader(department.getId(),organizationId))
                .build())
                .collect(Collectors.toList());
    }

    public List<SysDepartment> getAllByPid(Integer parentId, Integer organizationId) {
        Assert.notNull(organizationId,"organization id is not null.");
        if(parentId == null){
            SysDepartmentExample example = new SysDepartmentExample();
            example.createCriteria().andPIdIsNull().andOrganizationIdEqualTo(organizationId);
            example.setOrderByClause("sort ASC");
            return mapper.selectByExample(example);
        }
        SysDepartmentExample example = new SysDepartmentExample();
        example.createCriteria().andPIdEqualTo(parentId).andOrganizationIdEqualTo(organizationId);
        example.setOrderByClause("sort ASC");
        return mapper.selectByExample(example);
    }
}
