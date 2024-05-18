package com.maizi.quan.api.exception;

import com.maizi.quan.api.model.vo.BaseVo;
import com.maizi.quan.api.model.vo.VoBuilder;
import com.maizi.quan.common.exception.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author create by fanwenhao
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public BaseVo handleAuthException(AuthException e) {
        log.warn("handleAuthException:", e);
        return VoBuilder.toFailed(e.getMessage(), ExceptionCodeEnum.A0001);
    }

    @ExceptionHandler(value = ClientException.class)
    @ResponseBody
    public BaseVo handleClientException(ClientException e) {
        return VoBuilder.toFailed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseVo handleException(Exception e) {
        log.error("handleException:", e);
        return VoBuilder.toFailed("系统升级，请稍后再试");
    }

}
