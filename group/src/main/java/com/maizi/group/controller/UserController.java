package com.maizi.group.controller;

import com.maizi.group.domain.entity.Login;
import com.maizi.group.domain.entity.User;
import com.maizi.group.model.api.vo.VO;
import com.maizi.group.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public VO<User> login(@RequestBody Login request) {
       return VO.success(userService.login(request));
    }

    @PostMapping("/api/user/checkLogin")
    public VO<Boolean> checkLogin(@RequestHeader("token") String token) {
        return VO.success(userService.checkLogin(token));
    }
}
