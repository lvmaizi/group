package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.maizi.group.domain.value.Image;
import lombok.Data;

import java.util.List;

/**
 * @Author create by fanwenhao
 * 帖子
 */
@Data
@TableName(value = "posts", autoResultMap = true)
public class Posts extends BaseDomain {
    /**
     * group uuid
     */
    @TableField("group_uuid")
    private String groupUuid;
    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     *内容文本
     */
    @TableField("text")
    private String text;

    /**
     * 图片描述
     */
    @TableField(value = "image_list", typeHandler = JacksonTypeHandler.class)
    private List<Image> imageList;
}
