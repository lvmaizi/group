package com.maizi.quan.api.service;

import com.maizi.quan.api.model.dto.LoginUser;
import com.maizi.quan.api.model.vo.UserLoginVo;
import com.maizi.quan.api.model.webrequest.UserLoginRequest;

public interface UserService {

    UserLoginVo login(UserLoginRequest request);

    void logout();
}
