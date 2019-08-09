package com.crq.jdbc;

/**
 * @Title:UserDaoFactory
 * @ProjectName user_Jdbc
 * @Description:Todo
 * @author crq
 * @date  2019/3/25
 *
 * */
/*
* 工厂模式
* 一个共产可以产生很多产品，实际当中使用产品时通过这个工厂来返回，
*
* 优点：
* 当实现类UserDaoImpl被更改时，只需要更改对应的getUserDao方法即可，
* 如果在业务逻辑层使用UserDao dao = new UserDaoImpl();来调用时，一旦更改UserDaoImpl实现类
* 将会在在所有使用UserDaoImpl的地方进行更改，有100就改100个，这样不利于程序维护
* 而通过工厂模式，则只需更改getUserDao方法即可，大大减少程序维护困难
* */

public class DaoFactory {
    /**
     * 获取任务管理Dao
     * @return Dao
     */
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
