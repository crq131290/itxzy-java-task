import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
    private Logger logger = LogManager.getLogger(StudentServiceTest.class);

    @Autowired
    private StudentService studentService;

    @Before
    public void before(){
        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(start.format(new Date()));
        logger.info("start=======");
    }

    @After
    public void after(){
        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(end.format(new Date()));
        logger.info("stop=======");
    }

    @Test
    public void insertStudent(){
        Student student = new Student();
        student.setName("李栓但");
        student.setQq("333111");
        student.setSkill("web");
        int id = studentService.insertStudent(student);
        logger.info("李栓但"+id);
    }

    @Test
    public void deleteStudentById(){
        Boolean status =  studentService.deleteStudentById(2);
        logger.info(status);
    }

    @Test
    public void updateStudent(){
        Student student = new Student();
        student.setId(3);
        student.setName("赵科爽");
        student.setQq("666666");
        student.setSkill("PM");
        Boolean status = studentService.updateStudent(student);
        logger.info(status);
    }

    @Test
    public void getStudentById(){
        Student student = studentService.getStudentById(1);
        logger.info(student);
    }

    @Test
    public void getStudentByIdName(){
        Student student = studentService.getStudentByIdName(3,"赵科爽");
        logger.info(student);
    }



}
