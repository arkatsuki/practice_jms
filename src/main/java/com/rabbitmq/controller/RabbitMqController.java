/*package com.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.Result;

@Controller
@RequestMapping("rabbitmq")
public class RabbitMqController {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping("init")
	public String init(){
		return "rabbitmq/init";
	}
	
	@RequestMapping("sendToBroker")
	@ResponseBody
	public Result sendToBroker(String exchange, String routingKey, String message){
		
		
		 * http://localhost:8081/practice_jms/activemq/sendToTopic
		 
		
		message = message==null?"":message;
		
		Result rs = new Result();
		
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		System.out.println("sendToBroker send:" + message);
		
		rs.setSuccess(true);
		rs.setMessage("sendToBroker end, message:" + message);
		
		return rs;
		
	}

}
*/