package com.jnshu.crq.mapper;

import com.jnshu.crq.pojo.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    void insertStudent(Student student);

    void deleteStudentById(int id);

    void updateStudent(Student student);

//    @Select({"select * from student","where id = #{id}"})
    Student getStudentById(int id);
}
