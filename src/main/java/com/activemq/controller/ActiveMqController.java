package com.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.Result;

@Controller
@RequestMapping("activemq")
public class ActiveMqController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping("init")
	public String init(){
		return "activemq/init";
	}
	
	@RequestMapping("sendToBroker")
	@ResponseBody
	public Result sendToBroker(String destination, String message){
		
		/*
		 * http://localhost:8081/practice_jms/activemq/sendToTopic
		 */
		
		message = message==null?"":message;
		
		Result rs = new Result();
		
		jmsTemplate.convertAndSend(destination, message);
		System.out.println("sendToBroker send:" + message);
		
		rs.setSuccess(true);
		rs.setMessage("sendToBroker end, message:" + message);
		
		return rs;
		
	}
	
}
