package com.blessedbin.frame.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blessedbin.frame.common.data.service.BaseService;
import com.blessedbin.frame.common.ui.TreeNode;
import com.blessedbin.frame.ucenter.entity.SysDepartment;
import com.blessedbin.frame.ucenter.mapper.SysDepartmentMapper;
import com.blessedbin.frame.ucenter.service.ISysDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements ISysDepartmentService {

    @Override
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


    /**
     * 根据pid查找部门，pid为null时返回顶层节点
     * @param pid
     * @return
     */
    public List<SysDepartment> getAllByPid(Integer pid){

        LambdaQueryWrapper<SysDepartment> wrapper = new LambdaQueryWrapper<>();

        if(pid == null){
            wrapper.isNull(SysDepartment::getPid);
        } else {
            wrapper.eq(SysDepartment::getPid,pid);
        }

        return list(wrapper);
    }

    @Override
    public boolean existsById(Serializable id) {
        LambdaQueryWrapper<SysDepartment> wrapper = new LambdaQueryWrapper();
        wrapper.eq(SysDepartment::getId,id);
        return exists(wrapper);
    }

    @Override
    public boolean exists(Wrapper<SysDepartment> wrapper) {
        return count(wrapper) > 0;
    }
}
