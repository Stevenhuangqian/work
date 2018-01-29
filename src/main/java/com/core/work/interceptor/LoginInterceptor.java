package com.core.work.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.core.work.annotation.login.LoginRequired;

/**
 * 登录验证拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            LoginRequired loginRequired = findAnnotation((HandlerMethod) handler, LoginRequired.class);
            //没有声明需要权限,或者声明不验证权限
            if(loginRequired==null){
                return true;
            }else{
                String token=request.getHeader("token");
                if(StringUtils.isEmpty(token)){
                    token=request.getParameter("token");
                }
                //TODO 在这里实现自己的权限验证逻辑
                if(!StringUtils.isEmpty(token)){//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                    return true;
                }else{//如果验证失败

                    //response.getWriter().write("您还未登录");
                    return false;
                }       
            }
        }else{
            return true;
        }
    }

    /**
     * 登录注解拦截器
     * @param handler
     * @param annotationType
     * @param <T>
     * @return
     */
    private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) return annotation;
        return handler.getMethodAnnotation(annotationType);
    }
}
