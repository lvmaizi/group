package com.maizi.quan.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.maizi.quan.common.utils.JsonUtils;
import com.maizi.quan.common.utils.Timestamps;
import com.maizi.quan.manager.BaseRepository;
import com.maizi.quan.manager.RedisRepository;
import com.maizi.quan.manager.constants.RedisKeyType;
import com.maizi.quan.manager.domain.Redis;
import com.maizi.quan.manager.mapper.RedisMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author create by fanwenhao
 * 暂时使用数据库实现
 */
@Component
public class RedisRepositoryImpl extends BaseRepository implements RedisRepository {

    private static final long DEFAULT_DURATION = 24 * 3600 * 1000;

    @Resource
    private RedisMapper redisMapper;

    @Override
    public String get(RedisKeyType keyType, String key) {
        if (Objects.isNull(keyType)) {
            return null;
        }
        LambdaQueryWrapper<Redis> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Redis::getKeyType, keyType.name())
                .eq(Redis::getKey0, key)
                .eq(Redis::getDeleted, false)
        ;
        Redis redis = redisMapper.selectOne(queryWrapper);

        if (Objects.nonNull(redis) && !isExpire(redis)) {
            return redis.getValue0();
        }
        return null;
    }

    private boolean isExpire(Redis redis) {
        Timestamp createTime = redis.getCreateTime();
        Timestamp expireTime = Timestamps.plus(createTime, redis.getDuration());
        return expireTime.before(Timestamps.now());
    }

    @Override
    public void set(RedisKeyType keyType, String key, Object value) {
        set(keyType, key, value, DEFAULT_DURATION);
    }

    @Override
    public void set(RedisKeyType keyType, String key, Object value, long expireTime) {
        Redis redis = new Redis();
        redis.setKeyType(keyType.name());
        redis.setKey0(key);
        redis.setValue0(JsonUtils.toJson(value));
        redis.setDuration(expireTime);
        redis.setCreateTime(Timestamps.now());
        redis.setUpdateTime(Timestamps.now());
        redis.setDeleted(false);

        redisMapper.insertOnUpdate(redis);
    }

    @Override
    public void delete(RedisKeyType keyType, String key) {
        LambdaUpdateWrapper<Redis> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .set(Redis::getDeleted, true)
                .eq(Redis::getKeyType, keyType.name())
                .eq(Redis::getKey0, key)
        ;
        redisMapper.update(null, updateWrapper);
    }
}
