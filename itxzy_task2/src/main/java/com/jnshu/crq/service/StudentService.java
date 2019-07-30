package com.jnshu.crq.service;

import com.jnshu.crq.pojo.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(int id);

    Student insertStudent(Student student);

    int deleteStudentById(int id);

    List<Student> getStudentsByAge(int age);

    Student updateStudent(Student student);

    List<Student> getStudentsByPage(int start,int pageSize);

    List<Student> getStudentsNames();
}
