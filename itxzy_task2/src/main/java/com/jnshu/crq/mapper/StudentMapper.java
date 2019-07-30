package com.jnshu.crq.mapper;

import com.jnshu.crq.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
//    dao层接口，实现类由mapper.xml配置动态生成
    Student getStudentById(int id) throws Exception;

    void insertStudent(Student student) throws Exception;

    void updateStudent(Student student) throws Exception;

    void deleteStudentById(int id) throws Exception;

    List<Student> getStudentsByAge(int age) throws Exception;

    List<Student> getStudentsNames() throws Exception;

    List<Student> getStudentsByPage(@Param("start")int start, @Param("pageSize")int pageSize) throws Exception;
}
