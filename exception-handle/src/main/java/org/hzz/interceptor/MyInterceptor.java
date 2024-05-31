package org.hzz.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/30
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求 {}",request.getRequestURI());
        if(shouldSkip(request.getRequestURI()))
            return true;
        return true;
    }


    public boolean shouldSkip(String path){
        String uris[] = {
                "/error",
                "/**/*.css"
        };

        for (String uri: uris) {
            if(antPathMatcher.match(uri,path)){
                return true;
            }
        }
        return false;
    }
}
