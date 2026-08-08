package com.example.step18Filters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//  @Component
@Order(2)
public class Logging implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        Long startTime = System.currentTimeMillis();

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uui = UUID.randomUUID().toString();

        //doing here because of down stream service . response will be already commited
        // we can not add it after it comes back from dispacher servlet because
        // it become read only

        res.setHeader("X-Request-ID", uui);

        // request log
        System.out.println("Incoming request: " + req.getMethod()
                          + " " + req.getRequestURI());

        try{
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            Long duration = System.currentTimeMillis() - startTime;

            // response log
            System.out.println("respone: " + res.getStatus());
            System.out.println("duration " + duration);
        }

    }
}
