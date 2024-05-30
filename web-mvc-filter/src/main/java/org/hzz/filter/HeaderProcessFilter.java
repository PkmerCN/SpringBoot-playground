package org.hzz.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/30
 */
@Slf4j
public class HeaderProcessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info( "{} - header process" , request.getAttribute("request-id" ) );
        chain.doFilter(request, response);
    }
}
