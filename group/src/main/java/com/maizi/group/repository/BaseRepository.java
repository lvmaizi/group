package com.maizi.group.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maizi.group.domain.entity.BaseDomain;

/**
 * @Author create by fanwenhao
 */
public interface BaseRepository<T extends BaseDomain, R extends BaseMapper> {

    void save(T domain);

    void insert(T domain);

    void update(T domain);

    T get(String uuid);
}
