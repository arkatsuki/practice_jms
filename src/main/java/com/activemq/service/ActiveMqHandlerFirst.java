package com.activemq.service;

public class ActiveMqHandlerFirst {
	
	public void firstQueueHandlerMethod(String strMsg) {
		
		System.out.println("******************firstHandlerMethod receive strMsg:"+strMsg==null?"null":strMsg);
	    
	  }
	
	public void firstTopicHandlerMethod(String strMsg) {
		
		System.out.println("******************firstTopicHandlerMethod receive strMsg:"+strMsg==null?"null":strMsg);
	    
	  }

}
