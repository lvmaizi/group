package com.maizi.group.repository;

import com.maizi.group.domain.entity.Login;
import com.maizi.group.repository.mapper.LoginMapper;

/**
 * @Author create by fanwenhao
 */
public interface LoginUserRepository extends BaseRepository<Login, LoginMapper> {

    Login getByLogin(String userName, String password);

    Login getByToken(String token);

}
