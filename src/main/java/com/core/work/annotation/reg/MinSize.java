package com.core.work.annotation.reg;

import java.lang.annotation.*;

/**
 * Created by qianhuang on 2018/2/2.
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinSize {
    public int min() default 0;

    public String message() default "长度太短";
}
