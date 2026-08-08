package com.example.step18Filters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//  @Component
@Order(1)
public class Authentication implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");
        String apiKey = req.getHeader("X-API-KEY");

        if(token == null || !token.equals("123")) {
             res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             return;
        }
        if(apiKey == null || !apiKey.equals("secret")){
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.getWriter().write(
                    "{\n" +
                            "    \"message\": \"invalid apikey\"\n" +
                            "}"
            );
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
