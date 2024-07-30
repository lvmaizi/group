package com.maizi.group.service.impl;

import com.maizi.group.domain.entity.User;
import com.maizi.group.repository.UserRepository;
import com.maizi.group.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author create by fanwenhao
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(String uuid) {
        return userRepository.get(uuid);
    }
}
