package com.core.work.context;


/**
 * Created by qianhuang on 2018/1/29.
 */
public class ContextProvider {

    private ThreadLocal<RequestContext> contextContainer = new ThreadLocal<RequestContext>();

    public ThreadLocal<RequestContext> getContextContainer() {
        return contextContainer;
    }

    public void setContextContainer(ThreadLocal<RequestContext> contextContainer) {
        this.contextContainer = contextContainer;
    }

    public RequestContext getContext(){
        return contextContainer.get();
    }

}
