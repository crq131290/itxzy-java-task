package com.crq.cfx.impl;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        HelloWebService userService = (HelloWebService) context.getBean("hello");
        userService.getWebName("sadasd");
    }
}
