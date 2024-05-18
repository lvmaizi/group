package com.maizi.quan.api.service.impl;

import com.maizi.quan.api.model.dto.LoginUser;
import com.maizi.quan.api.model.vo.UserLoginVo;
import com.maizi.quan.api.model.webrequest.UserLoginRequest;
import com.maizi.quan.api.service.UserService;
import com.maizi.quan.api.utilss.JwtUtils;
import com.maizi.quan.common.exception.ClientException;
import com.maizi.quan.manager.RedisRepository;
import com.maizi.quan.manager.constants.RedisKeyType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author create by fanwenhao
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisRepository redisRepository;

    @Override
    public UserLoginVo login(UserLoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authentication)) {
            throw new ClientException("shibai");
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String jwtToken = JwtUtils.userId(loginUser.getId());

        redisRepository.set(RedisKeyType.USER_ID, loginUser.getId(), loginUser);
        return new UserLoginVo(jwtToken);
    }

    @Override
    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        redisRepository.delete(RedisKeyType.USER_ID, loginUser.getId());
        return;
    }

}
