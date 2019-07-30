package com.jnshu.crq.common;

import java.util.HashMap;

public class ResponseBo extends HashMap<String,Object> {
    private static final long versionUID = -8713837118340960775L;

    private static final Integer SUCCESS = 0;

    private static final Integer WARN = 1;

    private static final Integer FAIL = 500;

    public ResponseBo(){
        put("timetamp",System.currentTimeMillis());
        put("code",SUCCESS);
        put("message","操作成功");
    }

    public static ResponseBo error(Object msg){
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", FAIL);
        responseBo.put("message", msg);
        return responseBo;
    }

    public static ResponseBo warn(Object msg){
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code",WARN);
        responseBo.put("message",msg);
        return responseBo;
    }

    public static ResponseBo ok(Object msg){
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code",SUCCESS);
        responseBo.put("message",msg);
        return responseBo;
    }

    public static ResponseBo ok(){
        return new ResponseBo();
    }

    public static ResponseBo error(){
        return ResponseBo.error("");
    }

    @Override
    public Object put(String key, Object value) {
        super.put(key, value);
        return this;//把实例返回来
    }
}
