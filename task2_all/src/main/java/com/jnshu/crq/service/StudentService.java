package com.jnshu.crq.service;

import com.jnshu.crq.pojo.Student;

import java.util.List;

public interface StudentService {
    int insertStudent(Student student);

    Boolean deleteStudentById(int id);

    Boolean updateStudent(Student student);

    Student getStudentById(int id);

    List<Student> getStudents();

    List<Student> getStudentsByPage(int start,int pageSize);
}
