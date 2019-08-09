package com.crq.cfx.impl;

import javax.jws.WebService;

    @WebService
public interface HelloWebService {
//        接口中的成员变量只有一种类型，public static final ,所以可以直接省去修饰符。
        /**①首先接口是一种高度抽象的”模版”，,而接口中的属性也就是’模版’的成员，就应当是所有实现”模版”的实现类的共有特性，所以它是public static的 ,是所有实现类共有的 。

         ②反问1：假如可以是非static的话，因一个类可以继承多个接口，出现重名的变量，如何区分呢？

         ③反问2：接口中如果可能定义非final的变量的话，而方法又都是abstract的，这就自相矛盾了？

         ④反问3：有可变成员变量但对应的方法却无法操作这些变量，虽然可以直接修改这些静态成员变量的值，但所有实现类对应的值都被修改了，这跟抽象类有何区别呢？

         ④接口是一种更高层面的抽象，是一种规范、功能定义的声明，所有可变的东西都应该归属到实现类中，这样接口才能起到标准化、规范化的作用，所以接口中的属性必然是final的。
        */
    public String name = "webstatic";
    public String getWebName(String str);
}
