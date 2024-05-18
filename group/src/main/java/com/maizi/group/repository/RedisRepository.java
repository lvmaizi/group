package com.maizi.group.repository;


import com.maizi.group.constants.RedisKeyType;

/**
 * @Author create by fanwenhao
 */
public interface RedisRepository {

    String get(RedisKeyType keyType, String key);

    void set(RedisKeyType keyType, String key, Object value);

    void set(RedisKeyType keyType, String key, Object value, long expireTime);

    void delete(RedisKeyType keyType, String key);
}
