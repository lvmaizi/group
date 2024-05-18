package com.maizi.group.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseDomain {
    /**
     * 自增id
     */
    @TableId("id")
    private Long id;
    /**
     * uuid
     */
    @TableField("uuid")
    private String uuid;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Timestamp createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Timestamp updateTime;

    @TableField("deleted")
    private Boolean deleted;

}
