package com.crq.mybatisdao1;

import com.crq.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Title:UserDaoImpl
 * @ProjectName:mybatistest
 * @Descrption:Todo
 * @author crq
 * @date 2019/03/26 22:26
 * */
public class UserDaoImpl implements UserDao{
    private SqlSessionFactory sessionFactory;

    public UserDaoImpl(SqlSessionFactory sessionFactory){//构造传入sessionFactory
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserById(int id) {
        SqlSession session = sessionFactory.openSession();
        String stmt = "com.crq.bean.userMapper" + ".selectUserById";
        User u = session.selectOne(stmt,id);
        return u;
    }
}
