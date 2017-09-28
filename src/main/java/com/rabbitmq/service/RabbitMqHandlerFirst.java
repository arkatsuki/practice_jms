package com.rabbitmq.service;

public class RabbitMqHandlerFirst {
	
	public void firstQueueHandlerMethod(String strMsg) {
		
		System.out.println("******************firstHandlerMethod receive strMsg:"+strMsg==null?"null":strMsg);
	    
	  }

}
