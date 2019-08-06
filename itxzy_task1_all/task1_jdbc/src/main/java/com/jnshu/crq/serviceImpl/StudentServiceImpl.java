package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.dao.StudentDao;
import com.jnshu.crq.daoFactory.DaoFactory;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private  static  StudentDao studentDao;
    static {
        studentDao = DaoFactory.getStudentDao();
    }

    @Override
    public int insertStudent(Student student) {
        studentDao.insertStudent(student);
        return student.getId();
    }

    @Override
    public Boolean deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
        return true;
    }

    @Override
    public Boolean updateStudent(Student student) {
        studentDao.updateStudent(student);
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentDao.getStudentById(id);
        return student;
    }
}
