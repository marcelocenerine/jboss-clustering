package com.cenerino.exampleapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "JSessionIdLogger", urlPatterns = { "/*" })
public class JSessionIdLogger implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(JSessionIdLogger.class);

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        if (servletRequest.getCookies() != null) {
            for (Cookie cookie : servletRequest.getCookies()) {
                if (cookie.getName().equals("JSESSIONID")) {
                    logger.info("Intercepting request to the URL '{}' with JSESSIONID '{}'", servletRequest.getRequestURL(), cookie.getValue());
                }
            }
        }

        chain.doFilter(request, response);

        HttpServletResponse servletResponse = (HttpServletResponse) response;
        String header = servletResponse.getHeader("Set-Cookie");

        if (header != null && header.startsWith("JSESSIONID")) {
            logger.info("Creating new JSESSIONID cookie '{}'", header);
        }
    }
}
