package com.maizi.quan.manager.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "product", autoResultMap = true)
@Builder
public class Product extends BaseDomain {

    @TableField("price")
    private String price;
    @TableField("description")
    private String describe;
    @TableField(value = "image", typeHandler = JacksonTypeHandler.class)
    private Image image;
    @TableField(value = "images", typeHandler = JacksonTypeHandler.class)
    private List<Image> images;

}
