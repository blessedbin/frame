package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.modal.OauthClientDetails;
import com.blessedbin.frame.ucenter.service.OauthClientDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 21:54
 * @tool intellij idea
 */
@RestController
@RequestMapping("${frame.base-path.ucenter}/sys/oauth_details")
@Log4j2
public class OauthClientDetailsController {

    @Autowired
    private OauthClientDetailsService oauthClientDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/datatable.json")
    @FrameApi
    public SimpleResponse<Pagination<OauthClientDetails>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                                @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                                @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Pagination<OauthClientDetails> dataTable = oauthClientDetailsService.getDataTable(pageNum, pageSize);
        return SimpleResponse.ok(dataTable);
    }


    @PostMapping
    @FrameApi
    public SimpleResponse add(@RequestBody @Validated OauthClientDetails details){
        oauthClientDetailsService.insert(details);
        return SimpleResponse.created();
    }

    @GetMapping("/{id}")
    public SimpleResponse<OauthClientDetails> get(@PathVariable("id") String id){
        OauthClientDetails details = oauthClientDetailsService.selectByPk(id);
        return SimpleResponse.ok(details);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable("id") String id) {
        int i = oauthClientDetailsService.deleteByPk(id);
        return SimpleResponse.deleted();
    }

    @PutMapping
    public SimpleResponse edit(@RequestBody @Validated OauthClientDetails details){
        oauthClientDetailsService.updateByPkSelective(details);
        return SimpleResponse.accepted();
    }
}
