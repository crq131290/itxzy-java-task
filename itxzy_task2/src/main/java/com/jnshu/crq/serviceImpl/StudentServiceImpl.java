package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.StudentMapper;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@service注解
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(int id) {
        try {
            Student student = studentMapper.getStudentById(id);
            student.setId(id);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("没有对应id的学生");
        }
        return null;
    }

    @Override
    public Student insertStudent(Student student) {
        try {
            studentMapper.insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("没有对应id的学生");
        }
        return student;
    }

    @Override
    public int deleteStudentById(int id) {
        try {
            studentMapper.deleteStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Student> getStudentsByAge(int age) {
        try {
            List<Student> list= studentMapper.getStudentsByAge(age);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        try {
            studentMapper.updateStudent(student);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getStudentsNames() {
        try{
            List<Student> list = studentMapper.getStudentsNames();
            System.out.println(list);
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getStudentsByPage(int start, int pageSize) {
        try{
            System.out.println(start+"  "+pageSize);
            List<Student> list = studentMapper.getStudentsByPage(start,pageSize);
            System.out.println(list);
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
