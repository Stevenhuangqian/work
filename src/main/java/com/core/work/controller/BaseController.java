package com.core.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.core.work.exception.BaseCustomException;

public class BaseController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 统一的异常处理，spring提供3种形式： basecontroller的注解
	 * xml配置(可以使用默认的SimpleMappingExceptionResolver或自定义resolver继承HandlerExceptionResolver)
	 * 异常处理的思路: 所有业务异常应该统一继承baseCustomException 对于非业务异常，证明是非预估或未处理的运行异常，统一封装
	 * 这样设计有利于实现的时候分别处理已识别异常跟非预估异常 !!!注意子类尽量不要重写此方法，不然无法继承@ExceptionHandler注解
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	protected ModelAndView exp(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView("error/500");
		mv.addObject("ex", ex);
		if (ex instanceof BaseCustomException) {
			log.error("456");
		} else {
			log.error("123");
		}
		// ......
		// 异常处理

		return mv;
	}

}
