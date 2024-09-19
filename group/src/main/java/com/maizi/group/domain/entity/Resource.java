package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.maizi.group.domain.value.Image;
import com.maizi.group.domain.value.Location;
import lombok.Data;

/**
 * @Author create by fanwenhao
 */
@Data
@TableName(value = "resource", autoResultMap = true)
public class Resource extends BaseDomain {

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
     * 图片
     */
    @TableField(value = "image", typeHandler = JacksonTypeHandler.class)
    private Image image;

    /**
     * 位置信息
     */
    @TableField(value = "location", typeHandler = JacksonTypeHandler.class)
    private Location location;
}
