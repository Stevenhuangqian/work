package com.core.work.annotation.reg;

import java.lang.annotation.*;

/**
 * Created by qianhuang on 2018/2/2.
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxSize {
    public int max() default 20;

    public String message() default "长度太长";
}