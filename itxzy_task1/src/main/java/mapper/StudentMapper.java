package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

import java.util.List;

public interface StudentMapper {//dao接口，对应的mapper.xml是实现类
    int add(Student student);

    void delete(int id) throws Exception;

    Student get(int id) throws Exception;

    void update(Student student) throws Exception;

    List<Student> list();

    void insertList(@Param("studentList")List<Student> list);
}
