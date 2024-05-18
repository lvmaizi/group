package com.maizi.quan.api.model.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseVo<T> {

    private BaseVo() {
    }

    /**
     * 请求状态
     */
    public String status;
    /**
     * 响应代码
     */
    public String exceptionCode;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    public T data;

}