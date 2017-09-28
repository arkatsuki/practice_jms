package com.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketStompService {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public void sendMsg(String url,String msg){
		simpMessagingTemplate.convertAndSend(url, msg);
	}
	
}
