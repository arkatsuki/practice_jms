package com.websocket.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.Result;
import com.websocket.service.WebsocketStompService;

@Controller
@RequestMapping("websocket")
public class WebsocketController {
	
	protected static final Logger log = LoggerFactory.getLogger(WebsocketController.class);
	
	@Autowired
	private WebsocketStompService WebsocketStompService;
	
	@RequestMapping("init")
	public String init(){
		/*
		 * http://localhost:8081/jms_v2/websocket/init
		 */
		System.out.println("WebsocketController, init");
		return "websocket/init";
	}
	
	/**
	 * 浏览器发送给服务器的数据。返回值不会给浏览器，如果配有@SendTo，返回值会给到对应的消息代理。
	 * @param message
	 * @return
	 */
	@MessageMapping("/receiveMsgFromBrowser")
	public Result receiveMsgFromBrowser(String message) {
		Result rs = new Result();
		message = message==null?"":message;
		System.out.println("receiveMsgFromBrowser, Receive message: " + message);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rs.setSuccess(true);
		rs.setMessage("message has bean received: " + message);
		return rs;
	}
	
	@MessageMapping("/receiveMsgFromBrowserReturn")
	@SendTo("/jms_v2/messageMappingRerurn")
	public Result receiveMsgFromBrowserReturn(String message) {
		Result rs = new Result();
		message = message==null?"":message;
		System.out.println("receiveMsgFromBrowser, Receive message: " + message);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rs.setSuccess(true);
		rs.setMessage("message has bean received: " + message);
		return rs;
	}
	
	@SubscribeMapping("/subscribeMappingUrl")
	public Result subscribeMappingUrl(String message){
		message = message==null?"":message;
		System.out.println("subscribeMappingUrl, Receive message:  " + message);
		Result rs = new Result();
		rs.setSuccess(true);
		rs.setMessage(message);
		return rs;
	}
	
	/**
	 * 生成一个随机字母，发送给浏览器
	 * @param addr
	 * @param message
	 * @return
	 */
	@RequestMapping("sendToBrowser")
	@ResponseBody
	public Result sendToBrowser(String addr, String message){
		/*
		 * http://localhost:8081/jms_v2/websocket/init
		 */
		System.out.println("WebsocketController, sendToBrowser");
		
		Result rs = new Result();
		
		String[] msgArr = {"a","b","c","d","e","f","g","h","i","j"};
		Random random = new Random();
		int i = random.nextInt(9);
		
		addr = addr==null?"":addr;
		String msg = "message from server: " + msgArr[i];
		WebsocketStompService.sendMsg(addr, msg);
		
		rs.setSuccess(true);
		rs.setMessage("sendToBrowser end");
		return rs;
	}
	
	
}
