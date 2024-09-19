package com.maizi.group.service;

import com.maizi.group.domain.entity.Login;
import com.maizi.group.domain.entity.User;

public interface UserService {

    void create(User user);

    User get(String uuid);

    Login login(Login login);

    boolean checkLogin(String token);
}
