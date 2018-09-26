package com.blessedbin.frame.auth.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xubin on 2018/7/29.
 *
 * @author 37075
 * @date 2018/7/29
 * @time 7:57
 * @tool intellij idea
 */
@RestController
@RequestMapping("/authentication")
@Log4j2
public class AuthenticationController {

    @Resource(name="tokenStore")
    private TokenStore tokenStore;

    @Resource(name="tokenServices")
    ConsumerTokenServices tokenServices;

    /**
     * For admin purposes, let’s also set up a way to view the currently valid tokens.
     *
     * We’ll access the TokenStore in a controller, and retrieve the currently stored tokens for a specified client id:
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/tokens")
    @ResponseBody
    public List<String> getTokens() {
        List<String> tokenValues = new ArrayList<String>();
        Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("sampleClientId");
        if (tokens!=null){
            for (OAuth2AccessToken token:tokens){
                tokenValues.add(token.getValue());
            }
        }
        return tokenValues;
    }


    /**
     * In order to invalidate a token, we’ll make use of the revokeToken()
     * API from the ConsumerTokenServices interface:
     * @param tokenId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/tokens/revoke/{tokenId:.*}")
    @ResponseBody
    public String revokeToken(@PathVariable String tokenId) {
        tokenServices.revokeToken(tokenId);
        return tokenId;
    }

    @GetMapping("/user_info")
    @ResponseBody
    public Principal me(Principal principal){
        return principal;
    }

}
