package com.core.work.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * 这里针对@cacheable跟@cacheEvict注解处理 根据定义的key进行缓存插入或者删除，不做缓存的更新操作
 * 
 * @author 黄谦
 *
 */
@Aspect
@Component
public class CacheAspect {

	@Pointcut("@annotation(com.core.work.annotation.cache.Cacheable)")
	public void executeMethod() {
		throw new UnsupportedOperationException("不支持的方法");
	}

	/**
	 * 根据注解的key，存储返回结果，只要
	 * @param jp
	 * @throws Throwable
	 */
	 @AfterReturning("executeMethod()")
	public void methodAspect(JoinPoint jp) throws Throwable {
//		public void methodAspect(ProceedingJoinPoint jp) throws Throwable {

		String methodName = jp.getSignature().getName();
		String classType = jp.getTarget().getClass().getName();
		Class<?> clazz = Class.forName(classType);
		String clazzName = clazz.getName();
		String clazzSimpleName = clazz.getSimpleName();
		// jdk8才能获取到。兼容低版本JDK需要另外找方法
		MethodSignature ms = (MethodSignature) jp.getSignature();

		String[] paramNames = ms.getParameterNames();
		System.out.println(classType + clazzName + clazzSimpleName + methodName + Arrays.asList(paramNames).toString());


	}

	private boolean insertCache() {

		return false;
	}

	private boolean deleteCache() {
		return false;
	}

}
