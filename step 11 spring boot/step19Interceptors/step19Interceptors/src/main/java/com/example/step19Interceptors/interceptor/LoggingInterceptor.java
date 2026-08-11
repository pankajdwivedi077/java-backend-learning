package com.example.step19Interceptors.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

//        HandlerMethod method = (HandlerMethod) handler;

          if(handler instanceof HandlerMethod method){
              String controllerName = method.getBeanType().getName();
              String methodName = method.getMethod().getName();

              System.out.println("prehandle called");
              System.out.println(controllerName + " Name");
              System.out.println(methodName + " Method");
          }

        System.out.println("Http method " + request.getMethod());
        System.out.println("uri " + request.getRequestURI());
        System.out.println("paramters " + request.getQueryString());
        System.out.println("ip " + request.getRemoteAddr());
        System.out.println("token " + request.getHeader("token"));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView){

        System.out.println("posthandle called");



    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex){

        System.out.println("aftercompletion called");

        System.out.println("status " + response.getStatus());

    }


}
