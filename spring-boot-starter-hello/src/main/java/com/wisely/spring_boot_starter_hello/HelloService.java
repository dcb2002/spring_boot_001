package com.wisely.spring_boot_starter_hello;

public class HelloService {
	private String msg;
	public String sayHello() {
		return "myHello:  "+msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
