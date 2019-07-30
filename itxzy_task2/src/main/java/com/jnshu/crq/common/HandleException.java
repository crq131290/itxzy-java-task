package com.jnshu.crq.common;

import com.jnshu.crq.common.ResponseBo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


//ControllerAdvice能将controller和ExceptionHandler进行分开处理
//@ResponseStatus(value= HttpStatus.BAD_GATEWAY,reason = "这是一个http状态测试")
@ControllerAdvice
public class HandleException {
    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "这是一个http状态测试")
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    @ResponseBody
    public ResponseBo handleHttp(Exception e) {
        System.out.println("=============qweqwe==========");
        ResponseBo responseBo = ResponseBo.error();
        responseBo.put("data", "错误信息");
        return responseBo;
    }

//    @ExceptionHandler(Exception.class)
////    @ResponseBody
//    public ResponseEntity<ResponseBo> handleHttp(Exception e) {
//        System.out.println("=============qweqwe==========");
//        ResponseBo responseBo = ResponseBo.error();
//        responseBo.put("data", "错误信息");
////        return responseBo;
////        System.out.println(HttpStatus);
//        return new ResponseEntity<ResponseBo>(responseBo, HttpStatus.BAD_GATEWAY);
//    }
}
