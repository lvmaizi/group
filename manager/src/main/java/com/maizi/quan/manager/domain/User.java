package com.maizi.quan.manager.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User extends BaseDomain {

    /**
     * 名称/昵称
     */
    @TableField("name")
    private String name;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * password
     */
    @TableField("password")
    private String password;
    /**
     * 头像
     */
    @TableField("profile_photo")
    private Image profilePhoto;

}
