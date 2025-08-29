//package com.example.quotesender.filters;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//public class ForbiddenFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        HttpSession session = httpRequest.getSession();
//
//        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");
//        if (isAuthenticated == null) {
//            isAuthenticated=false;
//        }
//        if(isAuthenticated) {
//            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            httpResponse.getWriter().println("You already authorized");
//        }
//
//        if(!isAuthenticated) {
//            chain.doFilter(request, response);
//        }
//
//
//
//
//
//    }
//}
