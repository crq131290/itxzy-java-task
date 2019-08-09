package com.crq.jdbc;

import java.util.List;

/*
* 1.DAO :Data Access Object 数据访问对象
* 使用DAO设计模式，来封装数据库持久层的所有操作（CRUD），是低级的数据逻辑和高级的业务逻辑分离
* 达到解耦的目的
* 2 一个典型的DAO实现应有如下的组件
* 一个DAO接口
* 数据传输对象(有时称为值对象)
* 一个实现了DAO接口的具体类
* 一个DAO工厂类
*
* 3.样例
* UserDao 接口
* User 值对象（VO）
* UserDaoImpl（接口的具体实现类）
* UserFactory（工厂类，实例化用）
*
* */
public class DaoSign {
    public static void main(String[] args){
//        UserDao dao = new UserDaoImpl();
//        User u = new User();
        //u.setName("Dante");
        //u.setEmail("Dante@email");
        //dao.add(u);
        /*update
        u.setId(1);
        u.setName("Dante");
        u.setEmail("Dante@email");
        dao.update(u);
        */
        /*
            delete
            dao.delete(4);
        */
        /*
        getUserById
        User u2 = dao.getUserById(7);
        System.out.println(u2);
        */

        UserDao dao = DaoFactory.getUserDao();
//        UserDao dao = new UserDaoImpl();
        User u = new User();

        List<User> list = dao.query();
        System.out.println(list);
    }
}
