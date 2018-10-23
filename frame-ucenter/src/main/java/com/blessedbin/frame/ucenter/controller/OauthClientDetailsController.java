package com.blessedbin.frame.ucenter.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.ucenter.entity.OauthClientDetails;
import com.blessedbin.frame.ucenter.service.IOauthClientDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.blessedbin.frame.common.data.DataUtils.toPagination;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 21:54
 * @tool intellij idea
 */
@RestController
@RequestMapping("/sys/oauth_details")
@Log4j2
public class OauthClientDetailsController {


    @Autowired
    private IOauthClientDetailsService oauthClientDetailsService;

    /**
     * @param pageNum
     * @param pageSize
     * @param searchValue
     * @return
     */
    @GetMapping("/datatable.json")
        public SimpleResponse<Pagination<OauthClientDetails>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                                   @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Page<OauthClientDetails> page = new Page<>(pageNum,pageSize);
        IPage<OauthClientDetails> iPage = oauthClientDetailsService.page(page, null);
        return SimpleResponse.ok(toPagination(iPage));
    }


    @PostMapping
    public SimpleResponse add(@RequestBody @Validated OauthClientDetails details){
        oauthClientDetailsService.save(details);
        return SimpleResponse.created();
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public SimpleResponse<OauthClientDetails> get(@PathVariable("id") String id){
        OauthClientDetails details = oauthClientDetailsService.getById(id);
        return SimpleResponse.ok(details);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable("id") String id) {
        oauthClientDetailsService.removeById(id);
        return SimpleResponse.deleted();
    }

    @PutMapping
    public SimpleResponse edit(@RequestBody @Validated OauthClientDetails details){
        oauthClientDetailsService.updateById(details);
        return SimpleResponse.accepted();
    }
}
