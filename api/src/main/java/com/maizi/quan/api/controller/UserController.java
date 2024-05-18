package com.maizi.quan.api.controller;

import com.maizi.quan.api.model.vo.BaseVo;
import com.maizi.quan.api.model.vo.UserLoginVo;
import com.maizi.quan.api.model.vo.VoBuilder;
import com.maizi.quan.api.model.webrequest.UserLoginRequest;
import com.maizi.quan.api.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author create by fanwenhao
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/api/user/login")
    public BaseVo login(@RequestBody UserLoginRequest request) {
        UserLoginVo loginVo = userService.login(request);
        return VoBuilder.toSuccess(loginVo);
    }

    @PostMapping("/api/user/logout")
    public BaseVo logout() {
        userService.logout();
        return VoBuilder.toSuccess();
    }
}
