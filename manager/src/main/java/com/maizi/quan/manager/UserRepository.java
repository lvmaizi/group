package com.maizi.quan.manager;


import com.maizi.quan.manager.domain.User;

public interface UserRepository {

    void save(User user);

    User get(String uuid);

    User getByUsername(String username);

}
