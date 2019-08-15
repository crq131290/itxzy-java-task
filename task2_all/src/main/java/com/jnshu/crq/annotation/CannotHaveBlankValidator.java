package com.jnshu.crq.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Title:真正的校验类
 *
 * @Description:
 * 所有的验证者都需要实现ConstraintValidator接口，它的接口也很形象，包含一个初始化事件方法，和一个判断是否合法的方法。
 * 自定义注解可以用在METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER之上，ConstraintValidator的第二个泛型参数T，是需要被校验的类型。
 * */
public class CannotHaveBlankValidator implements ConstraintValidator<CannotHaveBlank, String> {

    @Override
    public void initialize(CannotHaveBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //null时不进行校验
        if(s!=null && s.contains(" ")){
            //获取默认提示信息
            String defaultConstraintMessageTemplate = constraintValidatorContext.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);

            //禁用默认提示信息
//            constraintValidatorContext.disableDefaultConstraintViolation();

            //设置提示语
//            constraintValidatorContext.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();

            return false;

        }

        return true;
    }
}
