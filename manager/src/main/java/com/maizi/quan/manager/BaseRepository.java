package com.maizi.quan.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maizi.quan.common.utils.IdGenerator;
import com.maizi.quan.common.utils.Timestamps;
import com.maizi.quan.manager.domain.BaseDomain;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @Author create by fanwenhao
 */
public class BaseRepository {

    protected boolean isInsert(BaseDomain baseDomain) {
        if (Objects.isNull(baseDomain)) {
            return false;
        }
        return StringUtils.isBlank(baseDomain.getUuid());
    }

    protected <T extends BaseDomain> void save(BaseMapper<T> mapper, T domain) {
        if (Objects.isNull(domain)) {
            return;
        }
        if (this.isInsert(domain)) {
            this.insert(mapper, domain);
        } else {
            this.update(mapper, domain);
        }
    }

    protected <T extends BaseDomain> void insert(BaseMapper<T> mapper, T domain) {
        if (Objects.isNull(domain)) {
            return;
        }
        domain.setUuid(IdGenerator.uuid());
        domain.setCreateTime(Timestamps.now());
        domain.setUpdateTime(Timestamps.now());
        domain.setDeleted(false);
        mapper.insert(domain);
    }

    protected <T extends BaseDomain> void update(BaseMapper<T> mapper, T domain) {
        if (Objects.isNull(domain)) {
            return;
        }
        domain.setUpdateTime(Timestamps.now());
        LambdaUpdateWrapper<T> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(T::getUuid, domain.getUuid());
        mapper.update(domain, updateWrapper);
    }

    protected <T extends BaseDomain> T get(BaseMapper<T> mapper, String uuid) {
        if (StringUtils.isBlank(uuid)) {
            return null;
        }
        QueryWrapper<T> queryWrapper = new QueryWrapper();
        queryWrapper.eq("uuid", uuid)
                .eq("deleted", false);
        return mapper.selectOne(queryWrapper);
    }
}
