package com.base.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext*.xml" ,"classpath:spring-mvc.xml"
})
public class Te {
    
	/**
	 * 如果像BaseTest那样继承AbstractTransactionalJUnit4SpringContextTests，就要配datasource
	 */
	
	
	public final int m1(){
		return 1;
	}
	
	public final int m1(int i){
		return 1;
	}
	
	public int m1(String s){
		return 1;
	}
	
	
	
}
