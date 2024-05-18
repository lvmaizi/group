package com.maizi.quan.api.model.vo;

import lombok.Data;

@Data
public class StreamParam extends BaseParam {
    private long startId;
    private int size;
}
