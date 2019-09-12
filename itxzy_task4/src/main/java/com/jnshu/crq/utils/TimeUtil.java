package com.jnshu.crq.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title : dateTag实现类
 * @description : TODO
 * @author : crq131290
 * @date : 2019/09/12
 * BodyTagSupport 和TagSupport都可以实现自定义标签
 * 二者区别主要是标签处理类是否需要与标签体交互，如果不需要交互的就用TagSupport，否则就用BodyTagSupport。
 * 详情:https://blog.csdn.net/zljjava/article/details/17420809
 * */
public class TimeUtil extends TagSupport {
    private Long value;

    @Override
    public int doStartTag() throws JspException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(value==null){
            Date date = new Date();
            String dateStr = simpleDateFormat.format(date);
            try {
                pageContext.getOut().write(dateStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Date date = new Date(value);
            String dateStr = simpleDateFormat.format(date);
            try {
                pageContext.getOut().write(dateStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doStartTag();
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
