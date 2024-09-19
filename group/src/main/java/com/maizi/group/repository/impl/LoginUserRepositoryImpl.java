package com.maizi.group.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.maizi.group.domain.entity.Login;
import com.maizi.group.domain.entity.User;
import com.maizi.group.repository.LoginUserRepository;
import com.maizi.group.repository.mapper.LoginMapper;
import com.maizi.group.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author create by fanwenhao
 */
@Component
public class LoginUserRepositoryImpl implements LoginUserRepository {

    @Autowired
    private RepositoryWrapper<Login, LoginMapper> repositoryWrapper;

    @Autowired
    private LoginMapper mapper;

    @Override
    public void save(Login domain) {
        repositoryWrapper.save(mapper, domain);
    }

    @Override
    public void insert(Login domain) {
        repositoryWrapper.insert(mapper, domain);
    }

    @Override
    public void update(Login domain) {
        repositoryWrapper.update(mapper, domain);
    }

    @Override
    public Login get(String uuid) {
        return repositoryWrapper.get(mapper, uuid);
    }

    @Override
    public Login getByLogin(String userName, String password) {
        LambdaQueryWrapper<Login> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Login::getUserName, userName);
        queryWrapper.eq(Login::getPassword, password);
        queryWrapper.orderByDesc(Login::getCreateTime);
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public Login getByToken(String token) {
        LambdaQueryWrapper<Login> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Login::getToken, token);
        return mapper.selectOne(queryWrapper);
    }
}
