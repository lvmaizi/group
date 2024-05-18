package com.maizi.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.maizi.group.domain.entity.BaseDomain;
import lombok.Data;

/**
 * @Author create by fanwenhao
 */
@TableName("file")
@Data
public class File extends BaseDomain {
    /**
     * 文件名称
     */
    @TableField("name")
    private String name;
    /**
     * 业务类型
     */
    @TableField("biz_type")
    private String bizType;
    /**
     * 文件类型
     */
    @TableField("type")
    private String type;
    /**
     * 二进制文件
     */
    @TableField("bytes")
    private byte[] bytes;
}
