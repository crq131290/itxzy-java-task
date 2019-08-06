

import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import com.jnshu.crq.serviceImpl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class StudentServiceTest {
    private Logger logger = LogManager.getLogger(StudentServiceTest.class);

    @Test
    public void insertStudent(){
        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setQq("1231333");
        student.setName("王花花");
        student.setSkill("qa");
        int id = studentService.insertStudent(student);
        logger.info(id);
    }

    @Test
    public void deleteStudentById(){
        StudentService studentService = new StudentServiceImpl();
        Boolean status = studentService.deleteStudentById(10);
        logger.info(status);
    }

    @Test
    public void updateStudent(){
        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setId(1);
        student.setName("李刷单");
        student.setQq("546464");
        student.setSkill("javajva");
        Boolean status = studentService.updateStudent(student);
        logger.info(status);
    }

    @Test
    public void getStudentById(){
        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.getStudentById(3);
        logger.info(student);
    }
}
