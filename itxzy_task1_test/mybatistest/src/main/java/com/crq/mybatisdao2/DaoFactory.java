package com.crq.mybatisdao2;

import org.apache.ibatis.session.SqlSession;
/**
 * @Title:UserDaoImpl
 * @ProjectName:mybatistest
 * @Descrption:Todo
 * @author crq
 * @date 2019/03/26 23:35
 * */
public class DaoFactory {
    public static UserMapper getUserMapper(SqlSession session){
        return session.getMapper(UserMapper.class);
    }
}
