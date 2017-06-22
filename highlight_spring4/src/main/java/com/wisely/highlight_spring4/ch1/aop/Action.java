package com.wisely.highlight_spring4.ch1.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * 编译期间进行织入(weaving)，
 * 编译后(post-compile)或是运行时(run-time)
 * 
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
