package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.dao.DaoFactory;
import com.jnshu.crq.mapper.StudentMapper;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import com.jnshu.crq.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentServiceImpl implements StudentService {
    @Override
    public int insertStudent(Student student) {
        SqlSession session = DBUtil.open();
        StudentMapper studentMapper = DaoFactory.getStudentMapper(session);
        studentMapper.insertStudent(student);
        DBUtil.commit(session);
        DBUtil.close(session);
        return student.getId();
    }

    @Override
    public Boolean deleteStudentById(int id) {
        SqlSession session = DBUtil.open();
        StudentMapper studentMapper = DaoFactory.getStudentMapper(session);
        studentMapper.deleteStudentById(id);
        DBUtil.commit(session);
        DBUtil.close(session);
        return true;
    }

    @Override
    public Boolean updateStudent(Student student) {
        SqlSession session = DBUtil.open();
        StudentMapper studentMapper = DaoFactory.getStudentMapper(session);
        studentMapper.updateStudent(student);
        DBUtil.commit(session);
        DBUtil.close(session);
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        SqlSession session = DBUtil.open();
        StudentMapper studentMapper =  DaoFactory.getStudentMapper(session);
        Student student = studentMapper.getStudentById(id);
        DBUtil.commit(session);
        DBUtil.close(session);
        return student;
    }
}
