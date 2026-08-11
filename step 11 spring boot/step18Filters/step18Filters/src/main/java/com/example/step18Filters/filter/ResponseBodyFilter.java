package com.example.step18Filters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper wrappedRes =
                new ContentCachingResponseWrapper(res);

        filterChain.doFilter(servletRequest, wrappedRes);

        byte[] original = wrappedRes.getContentAsByteArray();

        String originalBody = new String(original);

        String modilfiedBody =
                """
                    {
                     "originalResponse" : %s,
                     "appName": "Student"
                    }    
                        """.formatted(originalBody);

        wrappedRes.resetBuffer();

        wrappedRes.getWriter().write(modilfiedBody);

        wrappedRes.copyBodyToResponse();

    }
}
