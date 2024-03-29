package com.qp.wechat.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebFilter(urlPatterns = "/login/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age", "0");
        response.setHeader("Access-Control-Allow-Headers", "Origin,No-Cache,Host,X-Requested-With,If-Modified-Since,Pragma,Last-Modified,Cache-Control,Cookie,Expires,Content-Type,X-E4M-With,userId,token");
        response.setHeader("XDomainRequestAllowed", "1");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Connection", "keep-alive");
        if (request.getMethod().equals("OPTIONS")) {
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
