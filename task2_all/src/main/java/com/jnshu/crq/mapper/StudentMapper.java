package com.jnshu.crq.mapper;

import com.jnshu.crq.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    void insertStudent(Student student);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    Student getStudentById(int id);

    List<Student> getStudents();

    List<Student> getStudentsByPage(@Param("start")int start,@Param("pageSize")int pageSize);
}
