package com.maizi.group.service.impl;

import com.maizi.group.domain.entity.Login;
import com.maizi.group.domain.entity.User;
import com.maizi.group.exception.ClientException;
import com.maizi.group.repository.RedisRepository;
import com.maizi.group.repository.UserRepository;
import com.maizi.group.service.UserService;
import com.maizi.group.utils.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author create by fanwenhao
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisRepository redisRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(String uuid) {
        return userRepository.get(uuid);
    }

    @Override
    public User login(Login login) {
        log.warn("sssssssssss");
        User user = userRepository.getByLogin(login.getUserName(), login.getPassword());
        if (Objects.isNull(user)) {
            throw new ClientException("用户名密码错误");
        }

        String userName = login.getUserName();
        String token = userName + "|" + IdGenerator.uuid();
        redisRepository.set(null, userName, token, 30 * 60 * 1000);
        User response = new User();
        response.setToken(token);
        return response;
    }

    @Override
    public boolean checkLogin(String token) {
        if (StringUtils.isBlank(token)) {
            return false;
        }
        String userName = token.split("\\|")[0];
        String tokenA = redisRepository.get(null, userName);
        return Objects.nonNull(tokenA);
    }
}
