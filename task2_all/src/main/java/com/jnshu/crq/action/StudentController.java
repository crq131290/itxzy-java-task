package com.jnshu.crq.action;

import com.jnshu.crq.page.Page;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

//@RestController
@Controller
@RequestMapping(value = "/task")
public class StudentController {

    private Logger logger = LogManager.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @Autowired
    private MessageSource messageSource;
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

    @PostMapping(value = "/student")
    public ModelAndView insertStudent(@NotNull @RequestParam String name, @RequestParam String qq, @RequestParam String skill) {
        System.out.println(name);
        logger.info("name:"+name);
        logger.info("qq:"+qq);
        logger.info("skill:"+skill);
//        @RequestParam 注解只能使用keyvalue的形式吗
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name);
        Student student = new Student();
        student.setSkill(skill);
        student.setName(name);
        student.setQq(qq);
        System.out.println(student);
        int id = studentService.insertStudent(student);
        modelAndView.addObject("studentId", id);
        modelAndView.setViewName("studentInfo");
        return modelAndView;
    }

    @DeleteMapping(value = "/student/{id}")
    public ModelAndView deleteStudentById(@PathVariable(value = "id") int id) {
        logger.info("id:"+id);
        ModelAndView modelAndView = new ModelAndView();
        Boolean status = studentService.deleteStudentById(id);
        modelAndView.addObject("status", status);
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

    /*
    * @Validated Student student, BindingResult bindingResult
    * @Validated 表明Student是需要被校验的
    * BindingResult 这是用于存储校验结果的，而且必须相邻
    *
    *
     * */
    @PutMapping(value = "/student/{id}")
    public ModelAndView updateStudent(@RequestBody @Validated Student student, BindingResult bindingResult, @PathVariable int id) {
        logger.info("id:"+id);
        student.setId(id);
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                logger.error(fieldError.getDefaultMessage()+"asdasd");
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        Boolean status = studentService.updateStudent(student);
        modelAndView.addObject("status", status);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @GetMapping(value = "/student/{id}")
    public ModelAndView getStudentById(@PathVariable int id) {
        logger.info("id:"+id);
        System.out.println("============");
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentById(id);
        System.out.println(student);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("studentEdit");
        return modelAndView;
    }

    @GetMapping(value = "/student/list/{start}/{pageSize}")
    public ModelAndView getStudents(@PathVariable int start, @PathVariable int pageSize) {
        logger.info("start:"+start+";"+"pageSize:"+pageSize);
        Page page = new Page();
        page.setCurrentPage(start);
        page.setTotalRecords(studentService.getStudents().size());
        page.setPageSize(pageSize);
        System.out.println("==========");
        ModelAndView modelAndView = new ModelAndView();
        List<Student> list = studentService.getStudentsByPage((start - 1) * page.getPageSize(), pageSize);
        Object parmas[] = {};
        String statusCH = messageSource.getMessage("success",parmas,Locale.CHINA);//不指定local则使用系统local
        String statusEN = messageSource.getMessage("success",parmas,Locale.US);
        modelAndView.addObject("statusCH",statusCH);
        modelAndView.addObject("statusEN",statusEN);
        modelAndView.addObject("studentList", list);
        modelAndView.addObject("page", page);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }
}
