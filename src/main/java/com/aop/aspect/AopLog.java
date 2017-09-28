package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.websocket.controller.WebsocketController;

@Aspect
@Component
public class AopLog {
	
	protected static final Logger log = LoggerFactory.getLogger(WebsocketController.class);
	
	@Pointcut("execution(** com.*.controller.*.*(..))")
	private void logPoint(){
		
	}
	
	@Before("logPoint()")
	public void logBefore(JoinPoint jp){
		Object[] args = jp.getArgs();
		System.out.println("logBefore, args:");
		for(Object arg:args){
			arg = arg!=null?arg:"";
			System.out.println("arg:"+arg);
		}
		log.info("target class:{}, target class name:{}, target getSignature name:{}",jp.getTarget().getClass(),jp.getTarget().getClass().getName(),jp.getSignature().getName());
		
	}
	
	@Before("execution(** com.*.service.*.*(..))")
	public void logServiceBefore(JoinPoint jp){
		Object[] args = jp.getArgs();
		System.out.println("logBefore, args:");
		for(Object arg:args){
			arg = arg!=null?arg:"";
			System.out.println(arg);
		}
		log.info("target class:{}, target class name:{}, target getSignature name:{}",jp.getTarget().getClass(),jp.getTarget().getClass().getName(),jp.getSignature().getName());
		
		
	}
	
	@After("execution(** com.*.controller.*.*(..))")
	public void logAfter(JoinPoint jp){
		System.out.println("logAfter");
	}
	
	@Before("execution(* com.*.controller..*(..))")
	public void logBefore1(){
		System.out.println("logBefore1");
	}
	
	@Before("execution(* com.*.controller.WebsocketController.*(..))")
	public void logBefore2(){
		System.out.println("logBefore2");
	}

}
