package com.core.work.utils;

import com.core.work.exception.BaseCustomException;

/**
 *
 * 针对参数字段注解进行校验，包括所有从父类继承过来的字段
 * Created by qianhuang on 2018/1/30.
 */
public class EntityValidator {

    /**
     * 传入待校验实体实例
     *  读取实体的字段校验注解@RegCondition
     *  通过正则匹配
     * @param o
     * @param  needLoop  是否需要遍历所有父类属性
     * @return
     */
    public static boolean validate(Object o ,boolean needLoop){


        return true;
    }
}
