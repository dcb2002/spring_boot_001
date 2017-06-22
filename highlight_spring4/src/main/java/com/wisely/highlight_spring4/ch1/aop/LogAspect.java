package com.wisely.highlight_spring4.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect 				//1��������
@Component	 	//2����ΪBean
public class LogAspect {
	
	/**
	 * 
		�����е㣺@PointCut ����  ���ع���
		�е� ������@PointCut �������壬Ȼ��Ϊ�������� ���á�
		�����е㣺
		����ĳ��ע��ģ� @annotation
		����ĳ�������ģ�execution
	 * 
	 */
	@Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)") //3
	public void annotationPointCut(){};
	
	  @After("annotationPointCut()") //4
	    public void after(JoinPoint joinPoint) {
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        Action action = method.getAnnotation(Action.class); 
	        System.out.println("ע��ʽ����,����ִ�к����� " + action.name()); //5
	    }
	  
	   @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6
	    public void before(JoinPoint joinPoint){
	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	        Method method = signature.getMethod();
	        System.out.println("��������ʽ����,����ִ��ǰ����"+method.getName());

	    }
	   
	  
	
}
