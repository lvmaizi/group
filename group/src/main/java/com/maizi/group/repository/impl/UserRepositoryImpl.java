package com.maizi.group.repository.impl;

import com.maizi.group.domain.entity.User;
import com.maizi.group.repository.UserRepository;
import com.maizi.group.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author create by fanwenhao
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private RepositoryWrapper<User, UserMapper> repositoryWrapper;
    @Autowired
    private UserMapper mapper;

    @Override
    public void save(User domain) {
        repositoryWrapper.save(mapper, domain);
    }

    @Override
    public void insert(User domain) {
        repositoryWrapper.insert(mapper, domain);
    }

    @Override
    public void update(User domain) {
        repositoryWrapper.update(mapper, domain);
    }

    @Override
    public User get(String uuid) {
        return repositoryWrapper.get(mapper, uuid);
    }
}
