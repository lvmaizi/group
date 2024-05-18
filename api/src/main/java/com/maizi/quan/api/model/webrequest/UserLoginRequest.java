package com.maizi.quan.api.model.webrequest;

import lombok.Data;

/**
 * @Author create by fanwenhao
 */
@Data
public class UserLoginRequest {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
