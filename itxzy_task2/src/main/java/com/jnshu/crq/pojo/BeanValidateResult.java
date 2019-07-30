package com.jnshu.crq.pojo;
/**
 * desc : 参数校验结果封装实体
 * create_user : cheng
 * create_date : 2019/1/23 14:45
 *
 */
public class BeanValidateResult {
    private String fieldName;

    private String message;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
