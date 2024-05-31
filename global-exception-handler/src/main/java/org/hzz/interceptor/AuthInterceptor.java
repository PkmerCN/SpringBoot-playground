package org.hzz.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.hzz.exception.AuthException;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 模拟登录异常
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/31
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求URI: {}",request.getRequestURI());
        String token = request.getHeader("Authorization");
        if(token == null){
            log.info("token为null");
            throw new AuthException("Token不能为null");
        }
        return true;
    }
}
