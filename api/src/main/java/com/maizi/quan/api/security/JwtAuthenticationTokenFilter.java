package com.maizi.quan.api.security;

import com.maizi.quan.api.exception.AuthException;
import com.maizi.quan.api.model.dto.LoginUser;
import com.maizi.quan.api.utilss.JwtUtils;
import com.maizi.quan.common.utils.JsonUtils;
import com.maizi.quan.manager.RedisRepository;
import com.maizi.quan.manager.constants.RedisKeyType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author create by fanwenhao
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisRepository redisRepository;

    @Qualifier("handlerExceptionResolver")
    @Autowired
    private HandlerExceptionResolver resolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String userId = JwtUtils.getUserId(token);
        LoginUser loginUser = getSession(userId);
        if (Objects.isNull(loginUser)) {
            resolver.resolveException(request, response, null, new AuthException("您还未登录"));
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }

    private LoginUser getSession(String userId) {
        String string = redisRepository.get(RedisKeyType.USER_ID, userId);
        if (StringUtils.isBlank(string)) {
            return null;
        }
        return JsonUtils.toObject(string, LoginUser.class);
    }
}
