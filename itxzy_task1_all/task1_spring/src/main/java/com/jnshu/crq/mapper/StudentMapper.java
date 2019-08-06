package com.jnshu.crq.mapper;

import com.jnshu.crq.pojo.Student;
import org.apache.ibatis.annotations.*;

public interface StudentMapper {
//    @Insert({"insert into student (name,qq,skill)","values(#{name,#{qq},#{skill})"})
//    @SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id",resultType=Integer.class,before=false)
    void insertStudent(Student student) throws Exception;

//    @Delete({"delete from student","where id = #{id}"})
    void deleteStudentById(int id) throws Exception;

//    @Update({"update student set name = #{name},qq = #{qq},skill = #{skill}"," where id = #{id}"})
    void updateStudent(Student student) throws Exception;

//    @Select({"select * from student","where id = #{id}"})
    Student getStudentById(int id) throws Exception;

//    @Select({"select * from student","where id = #{id} and name = #{name}"})
    Student getStudentByIdName(@Param("id") int id,@Param("name") String name) throws Exception;
}
