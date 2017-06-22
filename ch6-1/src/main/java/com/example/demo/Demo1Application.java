package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication	
/**
 *[1]@SpringBootApplication：组合注解 
 *    Demo1Application:入口类
 *[2]自动扫描入口同级包、及其下级包里的Bean。 JPA项目还可以扫描@Entity
 *[3]关闭特定的自动配置：加入exclude参数 
 * 						@SpringBootApplicationexclude=({DataSourceAutoConfiguration.class})
 */
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@RequestMapping("/")
	String index(){
		return "hello world 11";
	}
}
