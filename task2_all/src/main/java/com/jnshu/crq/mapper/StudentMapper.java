package com.jnshu.crq.mapper;

import com.jnshu.crq.pojo.Student;

import java.util.List;

public interface StudentMapper {
    void insertStudent(Student student);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    Student getStudentById(int id);

    List<Student> getStudents();
}
