package org.hzz.filter;

import org.hzz.interceptor.LogInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/30
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
                //.addPathPatterns("/*") 默认拦截全路径
    }

    /**
     * 拦截器的配置
     */
    @Bean
    public FilterRegistrationBean<HeaderProcessFilter> headProcessfilter(){
        FilterRegistrationBean<HeaderProcessFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new HeaderProcessFilter());
        // Suspicious URL pattern: [/header/**] in context [], see sections 12.1 and 12.2 of the Servlet specification
        registrationBean.setUrlPatterns(List.of("/header/*"));
        registrationBean.setOrder(3);
        return registrationBean;
    }
}
