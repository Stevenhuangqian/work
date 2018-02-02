package com.core.work.annotation.reg;

/**
 * Created by qianhuang on 2018/2/1.
 */
public @interface EmptyReg {

    public boolean isEmpty() default true;

    public String message() default "字段不能为空！";
}
