package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.StudentMapper;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int insertStudent(Student student) {
        studentMapper.insertStudent(student);
        return student.getId();
    }

    @Override
    public Boolean deleteStudentById(int id) {
        studentMapper.deleteStudentById(id);
        return true;
    }

    @Override
    public Boolean updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = studentMapper.getStudentById(id);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> list = studentMapper.getStudents();
        return list;
    }
}
