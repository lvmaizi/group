package com.maizi.quan.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.maizi.quan.manager.BaseRepository;
import com.maizi.quan.manager.UserRepository;
import com.maizi.quan.manager.domain.User;
import com.maizi.quan.manager.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserRepositoryImpl extends BaseRepository implements UserRepository {

    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        super.save(userMapper, user);
    }

    @Override
    public User get(String uuid) {
        return super.get(userMapper, uuid);
    }

    @Override
    public User getByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        return userMapper.selectOne(queryWrapper);
    }
}
