package com.maizi.group.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maizi.group.domain.entity.BaseDomain;
import com.maizi.group.utils.IdGenerator;
import com.maizi.group.utils.Timestamps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author create by fanwenhao
 */
@Component
public class RepositoryWrapper<T extends BaseDomain, R extends BaseMapper>  {

    protected boolean isInsert(T baseDomain) {
        if (Objects.isNull(baseDomain)) {
            return false;
        }
        return StringUtils.isBlank(baseDomain.getUuid());
    }

    public void save(R mapper, T domain) {
        if (Objects.isNull(domain)) {
            return;
        }
        if (this.isInsert(domain)) {
            this.insert(mapper, domain);
        } else {
            this.update(mapper, domain);
        }
    }

    public void insert(R mapper, T domain) {
        if (Objects.isNull(domain)) {
            return;
        }
        domain.setUuid(IdGenerator.uuid());
        domain.setCreateTime(Timestamps.now());
        domain.setUpdateTime(Timestamps.now());
        domain.setDeleted(false);
        mapper.insert(domain);
    }

    public void update(R mapper, T domain) {
        if (Objects.isNull(domain)) {
            return;
        }
        domain.setUpdateTime(Timestamps.now());
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("uuid", domain.getUuid());
        mapper.update(domain, updateWrapper);
    }

    public T get(R mapper, String uuid) {
        if (StringUtils.isBlank(uuid)) {
            return null;
        }
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        queryWrapper.eq("uuid", uuid)
                .eq("deleted", false);
        return (T) mapper.selectOne(queryWrapper);
    }
}
