package org.hzz.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/30
 */
@Slf4j
@Component
@Order(1)
public class LogginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        // logginFilter created
        log.info(filterConfig.getFilterName() + " created");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UUID uuid = UUID.randomUUID();
        long start = System.currentTimeMillis();
        request.setAttribute("request-id",uuid);
        log.info("{} - remote host {}",uuid,request.getRemoteHost());
        filterChain.doFilter(request,servletResponse);
        log.info("{} - response in {}ms",uuid,System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {
        log.info("logginFilter destroy");
    }
}
