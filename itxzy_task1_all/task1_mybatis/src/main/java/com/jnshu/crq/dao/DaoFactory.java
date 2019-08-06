package com.jnshu.crq.dao;

import com.jnshu.crq.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

public class DaoFactory {
    public static StudentMapper getStudentMapper(SqlSession session){
        return session.getMapper(StudentMapper.class);
    }
}
