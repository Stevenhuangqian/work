package com.core.work.interceptor;

import com.core.work.context.ContextProvider;
import com.core.work.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 *
 */
public class ContextConvertInterceptor extends HandlerInterceptorAdapter {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //TODO 所有请求头、业务通用的参数全部可以封装在这里
        try{
            System.out.println(123);
            /**
             *  架构约定必须有参数。在这里进行封装
             *  如果需要针对这部分参数进行校验，可以通过一个EntityValidator进行校验
             */
            RequestContext rc = new RequestContext();
            rc.setLang(request.getHeader("lang"));
            rc.setRegion(request.getHeader("region"));
            rc.setRequestId(request.getHeader("requestId"));
            rc.setRequestTimesstamp(request.getHeader("requestTimestamp"));
            rc.setSessionToken(request.getHeader("sessionToken"));
            rc.setSource(request.getHeader("source"));
            rc.setTimeZone(request.getHeader("timeZone"));
            rc.setUserid(request.getHeader("userid"));
            rc.setIp(ipProcessor(request));
            //TODO 所有自定义的data全部存放在这里，建议不要直接把值保存在这里，不利于后续的开发及维护
            //可以系统把一个模块的参数封装起来，然后保存在这里
            //例如：datas.set("userEntity",new User());
            Map<String,Object> datas = new HashMap<String,Object> ();
            rc.setDatas(datas);
            ContextProvider.getContextContainer().set(rc);
//            rc.getDatas(request.getHeader("lang"))
        }catch (Exception e){

            return false;
        }


        return true;

    }

    /**
     * 专门处理经过反向代理的IP获取
     * @return
     */
    private String ipProcessor(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        return ip.indexOf(",") > -1 ? ip.substring(0, ip.indexOf(",")) : ip;

    }


}
