package com.likzn.concurrency.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.likzn.concurrency.threadlocal.Threadlocal.THREAD_LOCAL;


/**
 * @auther: Li jx
 * @date: 2019/2/18 22:19
 * @description: 配置过滤器
 */

public class HttpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        THREAD_LOCAL.set(5L);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
