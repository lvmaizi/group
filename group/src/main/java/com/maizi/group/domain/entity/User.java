package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.maizi.group.domain.value.Image;
import lombok.Data;

/**
 * @Author create by fanwenhao
 */
@Data
@TableName(value = "user", autoResultMap = true)
public class User extends BaseDomain {

    /**
     * 用户名
     */
    @TableField(value = "userName")
    private String userName;
    /**
     * 头像
     */
    @TableField(value = "avatar", typeHandler = JacksonTypeHandler.class)
    private Image avatar;
    /**
     * 签名
     */
    @TableField("signature")
    private String signature;

}
