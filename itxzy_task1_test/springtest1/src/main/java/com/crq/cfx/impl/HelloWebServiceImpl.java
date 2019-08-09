package com.crq.cfx.impl;

import org.springframework.stereotype.Component;

import javax.jws.WebService;
@Component("hello")
@WebService
public class HelloWebServiceImpl implements HelloWebService{
    @Override
    public String getWebName(String str) {
        System.out.println(name);
        System.out.println(str);
        return null;
    }
}
