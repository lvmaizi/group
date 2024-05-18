package com.maizi.quan.api.model.vo;

import com.maizi.quan.api.exception.ExceptionCodeEnum;

/**
 * @Author create by fanwenhao
 */
public class VoBuilder {

    // status : 只表示请求是否成功
    private final static String SUCCESS_STATUS = "200";
    private final static String FAILED_STATUS = "400";


    public static BaseVo toSuccess() {
        return new BaseVo<Object>(SUCCESS_STATUS, null, null, null);
    }

    public static BaseVo toSuccess(Object data) {
        return new BaseVo<Object>(SUCCESS_STATUS, null, null, data);
    }

    public static BaseVo toFailed(String message) {
        return new BaseVo(FAILED_STATUS, null, message, null);
    }

    public static BaseVo toFailed(String message, ExceptionCodeEnum codeEnum) {
        return new BaseVo(FAILED_STATUS, codeEnum.name(), message, null);
    }
}
