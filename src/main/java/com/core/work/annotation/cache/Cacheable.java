package com.core.work.annotation.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注解类
 * 目前只针对service层来做，存储数据格式为json
 * 方法返回值若为null默认不存储，可以开启存储
 * @author 黄谦
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {
	
	/**
	 * key的名称
	 * 支持表达式#实现动态取值
	 * 例如'findById'+#id
	 * 会从方法的入参里面获取到参数名为id的参数的值，再去拼凑出key
	 * @return
	 */
	String key() default "";
	/**
	 * 过期时间
	 * @return
	 */
	int expiredTime() default 0;

	/**
	 *
	 * @return
	 */
	//TODO 预留一个条件参数，未实现
	String condition() default "" ;	

	boolean cachedNull() default false;
	
}
