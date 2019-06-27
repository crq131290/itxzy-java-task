package serviceImpl;

import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student getStudentById(int id) {
        Student student = null;
        try {
            student = studentMapper.getStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }

    @Override
    public Student insertStudent(Student student) {
        try {
            studentMapper.insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        try {
            studentMapper.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }

    @Override
    public Boolean deleteStudentById(int id) {
        try {
            studentMapper.deleteStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        List<Student> list = null;
        try {
            list = studentMapper.getStudentByAge(age);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return list;
    }
}
