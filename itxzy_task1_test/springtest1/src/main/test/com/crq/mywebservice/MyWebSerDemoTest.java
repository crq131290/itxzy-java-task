package com.crq.mywebservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class MyWebSerDemoTest {
    public String HelloWord(String name) {
        return "Hello: " + name;
    }

    /**
     * 添加exclude=true后，HelloWord2()方法不会被发布
     *
     * @param name
     * @return
     */
    @WebMethod(exclude = true)
    public String HelloWord2(String name) {
        return "Hello: " + name;
    }

    public static void main(String[] args) {
/**
 *参数1：服务的发布地址
 *参数2：服务的实现者
 */
        Endpoint.publish("http://localhost:8080/h", new MyWebSerDemoTest());

    }
}
