package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.maizi.group.domain.entity.BaseDomain;
import lombok.Data;

/**
 * @Author create by fanwenhao
 */
@Data
@TableName("redis")
public class Redis extends BaseDomain {

    @TableField("key_type")
    private String keyType;
    @TableField("key_0")
    private String key0;
    @TableField("value_0")
    private String value0;
    @TableField("duration")
    private Long duration;
}
