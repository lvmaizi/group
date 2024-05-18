package com.maizi.quan.api.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author create by fanwenhao
 */
@Data
public class ProductCreateParam extends BaseParam {
    /**
     * 商品描述
     */
    private String describe;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 商品上传图片
     */
    private List<String> images;
    /**
     * 经度
     */
    private String latitude;
    /**
     * 维度
     */
    private String longitude;
}
