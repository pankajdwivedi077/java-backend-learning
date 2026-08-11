package com.example.step18Filters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

@Component
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");

//         ServletInputStream body = req.getInputStream();

                  BufferedReader reader = req.getReader();

                  StringBuilder body = new StringBuilder();
                  String line = reader.readLine();
                  while(line != null){
                      body.append(line);
                      line = reader.readLine();
                  }
        System.out.println(body);
    }
}
