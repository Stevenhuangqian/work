package com.core.work.context;


/**
 * Created by qianhuang on 2018/1/29.
 */
public class ContextProvider {

    private final static ThreadLocal<RequestContext> contextContainer = new ThreadLocal<RequestContext>();



    public static ThreadLocal<RequestContext> getContextContainer() {
        return contextContainer;
    }

    public static void setContextContainer(ThreadLocal<RequestContext> contextContainer) {
        contextContainer = contextContainer;
    }

    public static RequestContext getContext(){
        return contextContainer.get();
    }

}
