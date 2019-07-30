package com.jnshu.crq.utils;

import com.jnshu.crq.pojo.BeanValidateResult;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * desc : 实体校验工具类
 * create_user : cheng
 * create_date : 2019/1/23 13:54
 */
public class BeanValidateUtil {
    /**
     * 私有化构造方法
     */
    private BeanValidateUtil() {
    }

    /**
     * desc : 校验
     * create_user : cheng
     * create_date : 2019/1/23 13:56
     */
    public static <T> List<BeanValidateResult> validate(T bean) {
        // 校验null
        if (Objects.isNull(bean)) {
            return getNullValidateResultList();
        }

        // 获取验证器工厂
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // 获取验证器
        Validator validator = validatorFactory.getValidator();
        // 执行验证
        Set<ConstraintViolation<T>> validateSet = validator.validate(bean);
        return getValidateResultList(validateSet);
    }

    /**
     * desc : 获取校验实体list
     * create_user : cheng
     * create_date : 2019/1/23 14:12
     */
    private static <T> List<BeanValidateResult> getValidateResultList(Set<ConstraintViolation<T>> validateSet) {
        List<BeanValidateResult> validateResultList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(validateSet)) {
            validateResultList = validateSet.stream().map(BeanValidateUtil::convertToBeanValidateResult).collect(Collectors.toList());
        }
        return validateResultList;
    }

    /**
     * desc : 转换类型
     * create_user : cheng
     * create_date : 2019/1/23 14:48
     */
    private static <T> BeanValidateResult convertToBeanValidateResult(ConstraintViolation<T> validate) {
        BeanValidateResult validateResult = new BeanValidateResult();
        validateResult.setFieldName(validate.getPropertyPath().toString());
        validateResult.setMessage(validate.getMessage());
        return validateResult;
    }
    /**
     * desc : 获取bean为null时的校验结果
     * create_user : cheng
     * create_date : 2019/1/24 10:39
     */
    private static List<BeanValidateResult> getNullValidateResultList() {
        List<BeanValidateResult> validateResultList = new ArrayList<>();
        BeanValidateResult validateResult = new BeanValidateResult();
        validateResult.setFieldName("validateBean");
        validateResult.setMessage("bean is null");
        validateResultList.add(validateResult);
        return validateResultList;
    }
}
