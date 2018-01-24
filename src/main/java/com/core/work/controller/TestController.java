package com.core.work.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.work.exception.BaseCustomException;


@RestController
public class TestController {
		
	@RequestMapping("/test")
	 public void test(Integer id) throws Exception {  
       switch(id) {  
       case 1:  
           throw new BaseCustomException("1");  
       case 2:  
           throw new BaseCustomException("2");    
       case 3:  
           throw new BaseCustomException("3");   
       case 4:  
           throw new BaseCustomException("4");   
       case 5:  
           throw new BaseCustomException("5");    
       default:  
           throw new BaseCustomException("6");    
       }  
   }  
	
}


