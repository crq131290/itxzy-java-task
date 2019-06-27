package mapper;

import pojo.Student;

import java.util.List;

public interface StudentMapper {
    Student getStudentById(int id)throws Exception;

    void insertStudent(Student student)throws Exception;

    void updateStudent(Student student)throws Exception;

    void deleteStudentById(int id)throws Exception;

    List<Student> getStudentByAge(int age)throws Exception;
}
