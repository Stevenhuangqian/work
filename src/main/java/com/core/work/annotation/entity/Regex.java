package com.core.work.annotation.entity;


import com.core.work.constants.em.Exists;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 *
 *  字段校验的注解
 *
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Regex {

//    String[] conditionsArr() ;
    /**
     * 字段是否需要填写
     */
    Exists exists() default Exists.Skipped;

    /**
     * 字段最小长度
     * -1代表不限制
     * @return
     */
    int minlen() default 0;


    /**
     * 字段最大长度
     * -1代表不限制
     * @return
     */
    int maxlen() default 0;

    /**
     * 字段类型
     * @return
     */
    Class fieldType() ;

}











