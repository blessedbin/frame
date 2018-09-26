package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.modal.OauthClientDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 16:23
 * @tool intellij idea
 */
@Service
@Log4j2
public class OauthClientDetailsService extends AbstractMysqlCrudServiceImpl<OauthClientDetails,String> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public int insert(OauthClientDetails record) {
        // 做加密处理
        record.setClientSecret(passwordEncoder.encode(record.getClientSecret()));
        // 判断 additionalInformation 是否是标准的JSON串
        String information = record.getAdditionalInformation();
        if(StringUtils.isEmpty(information)){
            record.setAdditionalInformation(null);
        }else {
            try {
                objectMapper.readTree(information);
            } catch (IOException e) {
                log.debug("不是合法的JSON");
                throw new ParamCheckRuntimeException();
            }
        }

        return super.insert(record);
    }


    @Override
    public int updateByPkSelective(OauthClientDetails record) {

        return super.updateByPkSelective(record);
    }
}
