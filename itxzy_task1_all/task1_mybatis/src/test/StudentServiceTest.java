import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import com.jnshu.crq.serviceImpl.StudentServiceImpl;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentServiceTest {
    private Logger logger = LogManager.getLogger(StudentServiceTest.class);
    @Test
    public void insertStudent(){
        Student student = new Student();
        student.setSkill("java");
        student.setName("赵科爽");
        student.setQq("654321");
        StudentService studentService = new StudentServiceImpl();
        int id = studentService.insertStudent(student);
        logger.info(id);
    }

    @Test
    public void deleteStudentById(){
        StudentService studentService = new StudentServiceImpl();
        Boolean status = studentService.deleteStudentById(4);
        logger.info(status);
    }

    @Test
    public void updateStudent(){
        Student student = new Student();
        student.setId(6);
        student.setSkill("web");
        student.setName("李栓但");
        student.setQq("987654");
        StudentService studentService = new StudentServiceImpl();
        Boolean status = studentService.updateStudent(student);
        logger.info(status);
    }

    @Test
    public void getStudentById(){
        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.getStudentById(1);
        logger.info(student);
    }
}
