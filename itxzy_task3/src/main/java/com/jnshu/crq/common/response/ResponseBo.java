package com.jnshu.crq.common.response;

import java.util.HashMap;

/**
 * 返回结果集
 * */
public class ResponseBo extends HashMap<String,Object> {

//    成功
    private static final Integer SUCCESS = 0;

//    警告
    private static final Integer WARN = 1;

//    失败
    private static final Integer FAIL = 500;

    public ResponseBo(){
        put("code",SUCCESS);
        put("message","操作成功");
    }

    public static ResponseBo error(Object msg){
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code",FAIL);
        responseBo.put("msg",msg);
        return responseBo;
    }

    public static ResponseBo warn(Object msg){
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code",WARN);
        responseBo.put("msg",msg);
        return responseBo;
    }

    public static ResponseBo ok(Object msg){
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code",SUCCESS);
        responseBo.put("msg",msg);
        return responseBo;
    }

    public static ResponseBo ok(){return new ResponseBo();}

    public static ResponseBo error(){return ResponseBo.error("");}

    public static ResponseBo warn(){return ResponseBo.warn("");}

    @Override
    public ResponseBo put(String key, Object value) {
        super.put(key,value);
        return this;
    }
}
