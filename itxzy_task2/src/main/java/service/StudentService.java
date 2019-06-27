package service;

import org.springframework.stereotype.Service;
import pojo.Student;

import java.util.List;


public interface StudentService {
    Student getStudentById (int id);

    Student insertStudent (Student student);

    Student updateStudent (Student student);

    Boolean deleteStudentById (int id);

    List<Student> getStudentByAge(int age);
}
