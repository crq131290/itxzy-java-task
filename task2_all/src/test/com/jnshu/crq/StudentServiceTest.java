package com.jnshu.crq;

import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
    private Logger logger = LogManager.getLogger(StudentServiceTest.class);

    @Autowired
    private StudentService studentService;

    @Before
    public void before(){
        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("start:"+start.format(new Date()));
    }

    @After
    public void after(){
        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("end:"+end.format(new Date()));
    }

    @Test
    public void insertStudent(){
//        ApplicationContext ctx =  new FileSystemXmlApplicationContext("classpath:/applicationContext.xml");
//        StudentService studentService1 = (StudentService)ctx.getBean("studentss");
//        Student student = studentService1.getStudentById(26);
//        System.out.println(student);
        Student student = new Student();
        student.setQq("676767");
        student.setName("李栓但");
        student.setSkill("java");
        int id = studentService.insertStudent(student);
        logger.info(id);
    }

    @Test
    public void deleteStudentById(){
        Boolean status = studentService.deleteStudentById(13);
        logger.info(status);
    }

    @Test
    public void getStudentById(){
        Student student = studentService.getStudentById(1);
        System.out.println("+++++++++");
        logger.info(student);
    }

    @Test
    public void updateStudent(){
        Student student = new Student();
        student.setId(1);
        student.setQq("66666");
        student.setName("王花花的同学");
        student.setSkill("web");
        Boolean status = studentService.updateStudent(student);
        logger.info(status);
    }

    @Test
    public void getStudents(){
        try {
            List<Student> list = studentService.getStudents();
            logger.info(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
