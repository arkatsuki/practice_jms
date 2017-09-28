package com.aop.service;

import org.springframework.stereotype.Component;

@Component
public class AopService {
	
	public String aopTest(String arg0, int arg2){
		System.out.println("aopTest");
		return "res";
	}

}
