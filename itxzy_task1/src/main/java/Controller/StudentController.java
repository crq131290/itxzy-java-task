package Controller;

import Service.ServiceStudent;
import mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import pojo.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {//controller执行service中的方法去调用sql语句
    @Autowired
    private ServiceStudent serviceStudent;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = (StudentController) context.getBean("studentController");
        Student student = new Student();
        student.setName("李栓但");
        student.setAge("15");
        student.setQq("123456");

        List<Student> list = new ArrayList<Student>();

        for (int i = 0;i<10;i++){
            list.add(student);
        }
        Logger logger = LogManager.getLogger("StudentController");
        logger.info("debug");
//        System.out.println(studentController.serviceStudent.get(1));
//        System.out.println(studentController.serviceStudent.add(student));
//        System.out.println(studentController.serviceStudent.delete(1));
//        System.out.println(studentController.serviceStudent.update(student));
//        System.out.println(studentController.serviceStudent.list());
//        studentController.serviceStudent.insertList(list);
    }
}
