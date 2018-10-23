package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.data.service.BaseService;
import com.blessedbin.frame.common.ui.TreeNode;
import com.blessedbin.frame.ucenter.entity.SysDepartment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
public interface ISysDepartmentService extends IService<SysDepartment>, BaseService<SysDepartment> {

    List<TreeNode> getDepartmentTree();
}
