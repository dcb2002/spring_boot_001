package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
	@Action(name="��־��¼����")
    public void add(){
		System.out.println("DemoAnnotationService---add() ");
	} 
   
}
