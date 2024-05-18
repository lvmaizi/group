package com.maizi.group.model.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author create by fanwenhao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VO<T> {

    private T data;

    public static <R> VO<R> success(R data) {
        return new VO(data);
    }

}
