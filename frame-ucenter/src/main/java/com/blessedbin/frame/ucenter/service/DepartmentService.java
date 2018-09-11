package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.common.ui.CascaderNode;
import com.blessedbin.frame.common.ui.TreeNode;
import com.blessedbin.frame.ucenter.entity.dto.DepartmentDto;
import com.blessedbin.frame.ucenter.modal.SysDepartment;
import com.blessedbin.frame.ucenter.modal.SysDepartmentExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<TreeNode> getDepartmentTree() {
        return buildDepartmentTree(null);
    }

    /**
     * 递归构建树
     * @param pid
     * @return
     */
    private List<TreeNode> buildDepartmentTree(Integer pid){
        return getAllByPid(pid)
                .stream().map(dt -> TreeNode.builder()
                        .id(String.valueOf(dt.getId())).label(dt.getName())
                        .children(buildDepartmentTree(dt.getId())).build())
                .collect(Collectors.toList());
    }

    public List<SysDepartment> getTopAll(){
        SysDepartmentExample example = new SysDepartmentExample();
        example.createCriteria().andPidIsNull();
        example.setOrderByClause("sort ASC");

        return mapper.selectByExample(example);
    }

    public List<SysDepartment> getAllByPid(Integer pid){
        if(pid == null){
            return getTopAll();
        }

        SysDepartmentExample example = new SysDepartmentExample();
        example.createCriteria().andPidEqualTo(pid);
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
                .label(department.getName())
                .children(buildCascader(department.getId(),organizationId))
                .build())
                .collect(Collectors.toList());
    }

    public List<SysDepartment> getAllByPid(Integer parentId, Integer organizationId) {
        Assert.notNull(organizationId,"organization id is not null.");
        if(parentId == null){
            SysDepartmentExample example = new SysDepartmentExample();
            return mapper.selectByExample(example);
        }
        SysDepartmentExample example = new SysDepartmentExample();
        // example.createCriteria().andPIdEqualTo(parentId).andOrganizationIdEqualTo(organizationId);
        example.setOrderByClause("sort ASC");
        return mapper.selectByExample(example);
    }
}
