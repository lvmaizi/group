package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.maizi.group.domain.entity.BaseDomain;
import com.maizi.group.domain.value.Image;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "friend_group", autoResultMap = true)
public class Group extends BaseDomain {

    /**
     * 圈子名称
     */
    @TableField("name")
    private String name;
    /**
     * 圈子签名
     */
    @TableField("signature")
    private String signature;
    /**
     * 圈子头像
     */
    @TableField(value = "avatar", typeHandler = JacksonTypeHandler.class)
    private Image avatar;

    /**
     * 贴子列表
     */
    @TableField(exist = false)
    private List<Posts> postsList;

}
