package com.jnshu.crq.daoFactory;

import com.jnshu.crq.dao.StudentDao;
import com.jnshu.crq.daoImpl.StudentDaoImpl;

public class DaoFactory {
    public static StudentDao getStudentDao(){
        return new StudentDaoImpl();
    }
}
