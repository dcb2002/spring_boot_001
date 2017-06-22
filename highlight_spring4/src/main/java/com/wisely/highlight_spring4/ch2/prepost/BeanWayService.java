package com.wisely.highlight_spring4.ch2.prepost;

public class BeanWayService {
	  public void init(){
	        System.out.println("@Bean-init-method");
	    }
	    public BeanWayService() {
	        super();
	        System.out.println("@Bean-¹¹Ôìº¯Êý");
	    }
	    public void destroy(){
	        System.out.println("@Bean-destory-method");
	    }
}
