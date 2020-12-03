package com.robots.bumblebee.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.Strings;
import com.robots.bumblebee.entity.db.User;
import com.robots.bumblebee.login.JWTService;
import com.robots.bumblebee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Value("${jwt.header}")
    private String header;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader(header);// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(SkipToken.class)) {
            SkipToken skipToken = method.getAnnotation(SkipToken.class);
            if (skipToken.required()) {
                return true;
            }
        }
        // 执行认证
        if (Strings.isNullOrEmpty(token)) {
            throw new RuntimeException("无token，请重新登录");
        }
        // 验证 token
        DecodedJWT decodedJWT;
        try {
            decodedJWT = jwtService.verifyToken(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        long userId = decodedJWT.getClaim("account").asLong();
        User user = userService.getUser(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        httpServletRequest.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}