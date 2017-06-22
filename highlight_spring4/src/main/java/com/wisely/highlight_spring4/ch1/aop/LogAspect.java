package com.wisely.highlight_spring4.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect 				//1切面声明
@Component	 	//2声明为Bean
public class LogAspect {
	
	/**
	 * 
		定义切点：@PointCut 就是  拦截规则。
		切点 可以用@PointCut 单独定义，然后为其他建言 调用。
		两种切点：
		拦截某个注解的： @annotation
		拦截某个方法的：execution
	 * 
	 */
	@Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)") //3
	public void annotationPointCut(){};
	
	  @After("annotationPointCut()") //4
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class); 
	        System.out.println("注解式拦截,方法执行后拦截 " + action.name()); //5
	    }
	  
	   @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        System.out.println("方法规则式拦截,方法执行前拦截"+method.getName());

	    }
	   
	  
	
}
