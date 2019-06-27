package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Student;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/default")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public ModelAndView handleRequest() {
        System.out.println("=======================================");
        ModelAndView modelAndView = new ModelAndView();
        // 放入转发参数
//        Student student =  studentService.getStudentById(2);
//        System.out.println(student);
//        modelAndView.addObject("student",student);
        System.out.println("李二蛋你好");
        modelAndView.addObject("student","李二蛋你好");
//        // 放入jsp路径
        modelAndView.setViewName("index");

        return modelAndView;
    }
//    @RequestMapping(value = "/student/list",method = RequestMethod.GET)
//    public ModelAndView studentList(){
//        System.out.println("list---");
//        ModelAndView  modelAndView = new ModelAndView();
////        List<Student> list = studentService.getStudentByAge(11);
//        List<Student> list = new ArrayList<>();
//        Student student =  studentService.getStudentById(2);
//        for(int x=0;x<10;x++){
//            list.add(student);
//        }
//        modelAndView.addObject("list",list);
//        modelAndView.setViewName("studentList");
//        return modelAndView;
//    }


}
