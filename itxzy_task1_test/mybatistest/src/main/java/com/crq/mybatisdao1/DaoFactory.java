package com.crq.mybatisdao1;

import org.apache.ibatis.session.SqlSessionFactory;
/**
 * @Title:UserDaoImpl
 * @ProjectName:mybatistest
 * @Descrption:Todo
 * @author crq
 * @date 2019/03/26 22:26
 * */

public class DaoFactory {
    /**
     * @param :SqlSessionFactory
     * @return :UserDao
     * */
    public static UserDao getUserDao(SqlSessionFactory sessionFactory){
        return new UserDaoImpl(sessionFactory);
    }
}
