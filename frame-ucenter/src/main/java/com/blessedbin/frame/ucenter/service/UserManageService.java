package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.modal.SysUser;
import com.blessedbin.frame.ucenter.modal.SysUserExample;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 13:39
 * @tool intellij idea
 */
@Service
@Log4j2
public class UserManageService extends AbstractMysqlCrudServiceImpl<SysUser,String> {

    public boolean checkEmailExists(String email) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andEmailEqualTo(email);
        return checkExistsByExample(example);
    }

    public boolean checkUsernameExists(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        return checkExistsByExample(example);
    }

    public boolean checkPhoneExists(String phone) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andPhoneEqualTo(phone);
        return checkExistsByExample(example);
    }
}
