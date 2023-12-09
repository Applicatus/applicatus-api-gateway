package com.example.apigateway.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterConfiguration  {

//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//
//
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest request = (HttpServletRequest) req;
//
//        // Allow credentials
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//        // Allow specific origins or all origins
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//
//        // Allow specific headers or all headers
//        response.setHeader("Access-Control-Allow-Headers",
//                "Origin, X-Requested-With, Content-Type, Accept, Authorization, remember-me");
//
//        // Allow specific methods or all methods
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//
//        // Set the maximum age for the CORS results cache
//        response.setHeader("Access-Control-Max-Age", "3600");
//
//        // Handle the actual request
//        chain.doFilter(req, res);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
}
