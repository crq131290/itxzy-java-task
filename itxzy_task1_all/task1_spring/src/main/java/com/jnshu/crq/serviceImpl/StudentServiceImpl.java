package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.StudentMapper;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int insertStudent(Student student) {
        try {
            studentMapper.insertStudent(student);
            return student.getId();
        } catch (Exception e) {
            System.out.println("新增异常");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Boolean deleteStudentById(int id) {
        try {
            studentMapper.deleteStudentById(id);
            return true;
        } catch (Exception e) {
            System.out.println("删除异常");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean updateStudent(Student student) {
        try {
            studentMapper.updateStudent(student);
            return true;
        } catch (Exception e) {
            System.out.println("更新异常");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudentById(int id) {
        try {
            Student student = studentMapper.getStudentById(id);
            return student;
        } catch (Exception e) {
            System.out.println("查询异常");//数据库连接关闭后可以正常执行
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student getStudentByIdName(int id, String name) {
        try {
            Student student = studentMapper.getStudentByIdName(id,name);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
