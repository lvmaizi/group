package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.maizi.group.domain.value.Image;
import lombok.Data;

import java.util.List;

/**
 * @Author create by fanwenhao
 */
@TableName(value = "comments", autoResultMap = true)
@Data
public class Comments extends BaseDomain {

    @TableField("posts_uuid")
    private String postsUuid;
    /**
     * 首句评论id
     */
    @TableField("root_comments")
    private String rootComments;
    /**
     * 评论人
     */
    @TableField("user_id")
    private String userId;
    /**
     * 评论人
     */
    @TableField("user_name")
    private String userName;
    /**
     * 评论人
     */
    @TableField(value = "user_photo", typeHandler = JacksonTypeHandler.class)
    private Image userPhoto;
    /**
     * 评论类型
     */
    @TableField("content_type")
    private String contentType;
    /**
     * 评论文字
     */
    @TableField("text")
    private String text;
    /**
     * 评论图片
     */
    @TableField(value = "image", typeHandler = JacksonTypeHandler.class)
    private Image image;

    /**
     * 回复列表
     */
    @TableField(exist = false)
    private List<Comments> replyList;
}
