package com.aop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aop.service.AopService;

@Controller
@RequestMapping("aop")
public class AopController {
	
	@Resource
	private AopService aopService;
	
	@RequestMapping("init")
	public String init(){
		/*
		 * http://localhost:8081/jms_v2/aop/init
		 */
		System.out.println("AopController, init");
		aopService.aopTest("arg1-val", 2);
		return "websocket/init";
	}

}
