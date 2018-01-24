package com.core.work.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheEvict {
	/**
	 * 支持一串key的清除
	 * 支持表达式#实现动态取值
	 * 例如'findById'+#id
	 * 会从方法的入参里面获取到参数名为id的参数的值，再去拼凑出key
	 * @return
	 */
	String[] key() ;
	
	/**
	 * 清除失败的策略，直接抛异常还是日志打印
	 * @return
	 */
	//TODO 邮件需要自己补充支持
	FailStrategy failStrategy() default FailStrategy.Ingore;
}

enum FailStrategy {  
    ThrowException,Ingore,Mail,Log
}  