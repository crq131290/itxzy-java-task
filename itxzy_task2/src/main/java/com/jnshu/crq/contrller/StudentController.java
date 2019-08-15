package com.jnshu.crq.contrller;

import com.jnshu.crq.common.ResponseBo;
import com.jnshu.crq.common.Page;
import com.jnshu.crq.pojo.Student;
import com.jnshu.crq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

// @RequestParam
// 用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容。提交方式为get或post。
// （Http协议中，如果不指定Content-Type，则默认传递的参数就是application/x-www-form-urlencoded类型）
// @RequestBody
// 注解可以接收json格式的数据，并将其转换成对应的数据类型。
//@RestController = @Controller + @ResponseBody
//@ResponseBody将对象转成json字符串

@RestController
@RequestMapping(value = "/student")

public class StudentController {
    @Autowired
    private StudentService studentServiceImpl;
    @Autowired
    public MessageSource messageSource;
    @Autowired
    public Page p;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ModelAndView getStudentById(){
        System.out.println("================");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("student","test");
        modelAndView.setViewName("studentInfo");
        return modelAndView;
    }

//    @ResponseBody
    @PutMapping(value ="/update/{id}")
    public ResponseBo updateStudent(@RequestBody Student student,@PathVariable int id){
        System.out.println("================");
        student.setId(id);
        Student stu = studentServiceImpl.updateStudent(student);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",stu);
        return responseBo;
    }

//    @ResponseBody
    @DeleteMapping(value = "/delete/{id}")//{name:/正则等/}
    public ResponseBo deleteStudentById(@PathVariable int id){
        ResponseBo responseBo = new ResponseBo();
        int Id = studentServiceImpl.deleteStudentById(id);
        responseBo.put("data",Id);
        return responseBo;
    }


//    @ResponseBody
    @PostMapping(value = "/insert")
    public ResponseBo insertStudent(@RequestBody Student student){
        ResponseBo responseBo = new ResponseBo();
        Student student1 = studentServiceImpl.insertStudent(student);
        responseBo.put("data",student1);
        return responseBo;
    }


//    @ResponseBody
    @GetMapping(value = "/age/{age}")
    public ResponseBo getStudentByAge(@PathVariable int age){
        ResponseBo responseBo = new ResponseBo();
        List<Student> list =  studentServiceImpl.getStudentsByAge(age);
        responseBo.put("data",list);
        return  responseBo;
    }


    @GetMapping(value = "/errorTest")
    public ResponseBo errorTest() throws Exception{
//        throw new Exception("err测试");
        ResponseBo responseBo =  new ResponseBo();
//        getMessage(key,object,local)
        /**
         * 解析code对应的信息进行返回，如果对应的code不能被解析则返回默认信息defaultMessage。
         * @param 需要进行解析的code，对应资源文件中的一个属性名
         * @param 需要用来替换code对应的信息中包含参数的内容，如：{0},{1,date},{2,time} MessageFormat模式
         * @param defaultMessage 当对应code对应的信息不存在时需要返回的默认值
         * @param locale 对应的Locale
         * @return
         * */
        Object[] params = {"123", new GregorianCalendar().getTime()};
        String userName = messageSource.getMessage("userName", params,  Locale.CHINA);
        System.out.println("+++++++++++++++++++++");
        System.out.println(userName);
        responseBo.put("userName",userName);
        return responseBo;
    }

    @GetMapping(value="/page/{page}/{pageSize}")
//    @ResponseBody
    public ResponseBo getStudentsByPage(@PathVariable int page,@PathVariable int pageSize){
        ResponseBo responseBo = new ResponseBo();
        p.setTotalStudets(studentServiceImpl.getStudentsNames().size());
        p.setCurrentPage(page);
        List<Student> list = studentServiceImpl.getStudentsByPage((page - 1) * p.getPageSize(),pageSize);
        responseBo.put("data",list);
        return responseBo;
    }



}


/**
 * MessageFormat模式:
 * FormatElement:
 *          { ArgumentIndex }
 *          { ArgumentIndex , FormatType }注意是以逗号隔开
 *          { ArgumentIndex , FormatType , FormatStyle }注意是以逗号隔开
 *
 * FormatType:
 *          number
 *
 *          date
 *
 *          time
 *
 *          choice（需要使用ChoiceFormat）
 *
 * FormatStyle:
 *          short
 *          medium
 *          long
 *          full
 *          integer
 *          currency
 *          percent
 * SubformatPattern（子模式）
 *
 * 还以str为例，在这个字符串中：
 *
 * 1、{0}和{1,number,short}和{2,number,#.#};都属于FormatElement，0,1,2是ArgumentIndex。
 *
 * 2、{1,number,short}里面的number属于FormatType，short则属于FormatStyle。
 *
 * 3、{1,number,#.#}里面的#.#就属于子格式模式。
 *
 * 指定FormatType和FormatStyle是为了生成日期格式的值、不同精度的数字、百分比类型等等*/
