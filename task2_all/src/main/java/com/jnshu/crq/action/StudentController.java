package com.jnshu.crq.action;

import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
//    @RequestParam用来处理 Content-Type 为 application/x-www-form-urlencoded 编码的内容，Content-Type 默认为该属性。
    /*
    * 由于@RequestParam是用来处理 Content-Type 为 application/x-www-form-urlencoded 编码的内容的，所以在postman中，
    * 要选择body的类型为 x-www-form-urlencoded，这样在headers中就自动变为了 Content-Type : application/x-www-form-urlencoded 编码格式。如下图所示：
    * 但是这样不支持批量插入数据啊，如果改用 json 字符串来传值的话，类型设置为 application/json，点击发送的话，会报错，后台接收不到值，为 null。
    * */

    /*
    * 注解@RequestBody接收的参数是来自requestBody中，即请求体。一般用于处理非 Content-Type: application/x-www-form-urlencoded编码格式的数据，比如：application/json、application/xml等类型的数据。
    就application/json类型的数据而言，使用注解@RequestBody可以将body里面所有的json数据传到后端，后端再进行解析。


    注解@RequestParam接收的参数是来自requestHeader中，即请求头。通常用于GET请求，像POST、DELETE等其它类型的请求也可以使用。
    注解@RequestBody接收的参数是来自requestBody中，即请求体。一般用于处理非 Content-Type: application/x-www-form-urlencoded编码格式的数据，比如：application/json、application/xml等类型的数据。通常用于接收POST、DELETE等类型的请求数据，GET类型也可以适用。
    * */

    @PostMapping(value = "/add")
    public ModelAndView insertStudent(@RequestParam String name,@RequestParam String qq,@RequestParam String skill){
//        @RequestParam 注解只能使用keyvalue的形式吗
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name);
        Student student = new Student();
        student.setSkill(skill);
        student.setName(name);
        student.setQq(qq);
        System.out.println(student);
        int id = studentService.insertStudent(student);
        modelAndView.addObject("studentId",id);
        modelAndView.setViewName("studentInfo");
        return modelAndView;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ModelAndView deleteStudentById(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Boolean status = studentService.deleteStudentById(id);
        modelAndView.addObject("status",status);
        modelAndView.setViewName("success");
        return modelAndView;
    }
//    @DeleteMapping(value = "/delete/{id}")
//    public String deleteStudentById(@PathVariable(value = "id") int id){
//        Boolean status = studentService.deleteStudentById(id);
//        return "redirect:/student/success";
//    }
//
//    @RequestMapping(value = "/success")
//    public ModelAndView success(){
//        ModelAndView modelAndView = new ModelAndView();
//        System.out.println("success");
//        modelAndView.addObject("delStatus","success");
//        modelAndView.setViewName("studentInfo");
//        return modelAndView;
//    }

    @PutMapping(value = "/update/{id}")
    public ModelAndView updateStudent(@RequestBody Student student,@PathVariable int id){
        student.setId(id);
        ModelAndView modelAndView = new ModelAndView();
        Boolean status = studentService.updateStudent(student);
        modelAndView.addObject("status",status);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @GetMapping(value = "/info/{id}")
    public ModelAndView getStudentById(@PathVariable int id){
        System.out.println("============");
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentById(id);
        System.out.println(student);
        modelAndView.addObject("student",student);
        modelAndView.setViewName("studentEdit");
        return modelAndView;
    }

    @GetMapping(value = "/list")
    public ModelAndView getStudents(){
        System.out.println("==========");
        ModelAndView modelAndView = new ModelAndView();
        List<Student> list = studentService.getStudents();
        modelAndView.addObject("studentList",list);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }


}
