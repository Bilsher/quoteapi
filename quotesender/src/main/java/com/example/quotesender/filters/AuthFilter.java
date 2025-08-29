package com.example.quotesender.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {

    private final List<String> skippedUrls = List.of("/api/v1/quotes/registration","/api/v1/quotes/login");
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");

        if (isAuthenticated == null) {
            isAuthenticated = false;
        }

        if (skippedUrls.contains(httpRequest.getRequestURL().toString().substring(21)) && !isAuthenticated) {
            chain.doFilter(request, response);
        } else if (skippedUrls.contains(httpRequest.getRequestURL().toString().substring(21)) && isAuthenticated) {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.getWriter().println("You already authorized---");
        } else {

            if (!isAuthenticated) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.getWriter().println("You not auhtorized-----");
            }

            if (isAuthenticated) {
                chain.doFilter(request, response);
            }
        }

    }
}
