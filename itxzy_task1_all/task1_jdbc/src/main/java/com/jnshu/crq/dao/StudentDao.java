package com.jnshu.crq.dao;

import com.jnshu.crq.pojo.Student;

public interface StudentDao {
    void insertStudent(Student student);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    Student getStudentById(int id);
}
