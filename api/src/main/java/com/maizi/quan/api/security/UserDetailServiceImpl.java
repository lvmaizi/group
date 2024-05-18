package com.maizi.quan.api.security;

import com.maizi.quan.api.model.dto.LoginUser;
import com.maizi.quan.common.exception.ClientException;
import com.maizi.quan.manager.UserRepository;
import com.maizi.quan.manager.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author create 77iu/ 续集就
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        if (Objects.isNull(user)) {
            throw new ClientException("");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setId(user.getUuid());
        loginUser.setUsername(user.getUserName());
        loginUser.setPassword(user.getPassword());
        loginUser.setAccountNonExpired(true);
        loginUser.setAccountNonLocked(true);
        loginUser.setCredentialsNonExpired(true);
        loginUser.setEnabled(true);
        return loginUser;
    }
}
