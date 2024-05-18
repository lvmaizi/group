package com.maizi.group.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maizi.group.domain.Redis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author create by fanwenhao
 */

@Mapper
public interface RedisMapper extends BaseMapper<Redis> {

    @Insert("insert into redis (`id`,`uuid`,`key_type`,`key_0`,`value_0`,`duration`,`create_time`,`update_time`)"
            + " value (#{id},#{uuid},#{keyType},#{key0},#{value0},#{duration},#{createTime},#{updateTime})"
            + " on duplicate key update "
            + " value_0=values(value_0),"
            + " duration=values(duration),"
            + " create_time=values(create_time),"
            + " update_time=values(update_time),"
            + " deleted=values(deleted)"
    )
    void insertOnUpdate(Redis redis);

}
