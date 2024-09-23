package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author create by fanwenhao
 */
@Data
@TableName(value = "login_user", autoResultMap = true)
public class Login extends BaseDomain {

    @TableField("user_name")
    private String userName;

    @TableField(value = "password", select = false)
    private String password;

    @TableField("token")
    private String token;

}
