package com.maizi.group.service.impl;

import com.maizi.group.domain.entity.Login;
import com.maizi.group.domain.entity.User;
import com.maizi.group.exception.ClientException;
import com.maizi.group.repository.LoginUserRepository;
import com.maizi.group.repository.UserRepository;
import com.maizi.group.service.UserService;
import com.maizi.group.utils.IdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author create by fanwenhao
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginUserRepository loginUserRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(String uuid) {
        return userRepository.get(uuid);
    }

    @Override
    public Login login(Login login) {
        Login loginTrue = loginUserRepository.getByLogin(login.getUserName(), login.getPassword());
        if (Objects.isNull(loginTrue)) {
            throw new ClientException("用户名密码错误");
        }
        loginTrue.setToken(IdGenerator.uuid());

        loginUserRepository.save(loginTrue);

        Login response = new Login();
        response.setToken(loginTrue.getToken());
        return response;
    }

    @Override
    public boolean checkLogin(String token) {
        if (StringUtils.isBlank(token)) {
            return false;
        }
        Login login = loginUserRepository.getByToken(token);
        return Objects.nonNull(login);
    }
}
