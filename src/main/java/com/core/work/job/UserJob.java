package com.core.work.job;

import org.springframework.stereotype.Component;

/**
 * Created by qianhuang on 2018/2/2.
 */

@Component
public class UserJob extends  BaseJob{

    public void userUpdate(){
        System.out.println("定时任务启动。。。。。");
    }

    public void userUpdate2(){
        System.out.println("定时任务");
    }

}
