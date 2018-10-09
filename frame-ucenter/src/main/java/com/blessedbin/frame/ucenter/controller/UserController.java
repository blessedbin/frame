package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.contant.SecurityConstants;
import com.blessedbin.frame.common.entity.FrameUser;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.entity.dto.MenuTreeDto;
import com.blessedbin.frame.ucenter.modal.SysUser;
import com.blessedbin.frame.ucenter.service.MenuService;
import com.blessedbin.frame.ucenter.service.UserManageService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Created by xubin on 2018/7/10.
 * 用户个人设置
 * @author 37075
 * @date 2018/7/10
 * @time 15:54
 * @tool intellij idea
 */
@RestController
@Log4j2
@RequestMapping("/user")
@Api(description = "用户操作")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;


    @GetMapping("/me")
    public SimpleResponse me(@RequestHeader(SecurityConstants.UUID_HEADER) String uuid){
        SysUser user = userManageService.selectByPk(uuid);
        user.setPassword(null);
        return SimpleResponse.ok(user);
    }

    /**
     * 获取头像
     */
    @GetMapping("/avatar.jpg")
    @ApiOperation(value = "获取用户头像")
    @ApiResponses({
            @ApiResponse(code = 200,message = "返回用户头像")
    })
    @FrameApi
    public void getAvatar(HttpServletResponse response, @RequestHeader(SecurityConstants.UUID_HEADER) String uuid) throws IOException {
        File file = ResourceUtils.getFile("classpath:image/default_avatar.jpg");
        BufferedImage read = ImageIO.read(file);
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("image/jpg");
        ImageIO.write(read,"jpg", outputStream);
        outputStream.close();
    }

    @Data
    @ToString
    public static class ChangePasswordParam{
        @NotBlank(message = "密码不能为空")
        private String pass;

        @NotBlank
        private String checkPass;

        @NotBlank
        private String oldPass;
    }

    /**
     * 修改密码
     * @param param
     * @return
     */
    @ApiOperation(value = "修改自己的密码")
    @PostMapping("/change_password")
    @FrameApi
    public SimpleResponse changePassword(@RequestBody ChangePasswordParam param,@RequestHeader(SecurityConstants.UUID_HEADER) String uuid){
        log.debug("request change password param:{}",param);
        SysUser user = userManageService.selectByPk(uuid);
        if(!passwordEncoder.matches(param.getOldPass(),user.getPassword())){
            throw new ParamCheckRuntimeException("密码错误，请重试");
        }
        if(!param.getPass().equals(param.getCheckPass())){
            throw new ParamCheckRuntimeException();
        }

        SysUser sysUser = new SysUser();
        sysUser.setUuid(user.getUuid());
        sysUser.setPassword(passwordEncoder.encode(param.getPass()));
        userManageService.updateByPkSelective(sysUser);


        return SimpleResponse.accepted("修改成功");
    }


    /**
     * @return
     */
    @GetMapping("/menus")
    @ResponseBody
    public SimpleResponse menus(@RequestHeader(SecurityConstants.UUID_HEADER) String uuid) {
        List<MenuTreeDto> menus = menuService.getUserMenu(uuid);
        return SimpleResponse.ok(menus);
    }

    @PostMapping("/avatar.do")
    @ApiOperation("设置头像")
    public SimpleResponse setAvatar(MultipartFile img, @RequestHeader(SecurityConstants.UUID_HEADER) String uuid) throws IOException {
        log.debug("file name:{},size:{},name:{}",img.getOriginalFilename(),img.getSize(),img.getName());
        SysUser user = userManageService.selectByPk(uuid);
        if(user == null) {
            throw new ParamCheckRuntimeException();
        }

        StorePath image = fastFileStorageClient.uploadImageAndCrtThumbImage(img.getInputStream(), img.getSize(), "PNG", null);
        user.setAvatar(image.getFullPath());
        userManageService.updateByPkSelective(user);

        return SimpleResponse.accepted();
    }

}
