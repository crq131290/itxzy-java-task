package com.jnshu.crq.service;

import com.jnshu.crq.pojo.Student;

public interface StudentService {
    int insertStudent(Student student);

    Boolean deleteStudentById(int id);

    Boolean updateStudent(Student student);

    Student getStudentById(int id);

    Student getStudentByIdName(int id,String name);
}
