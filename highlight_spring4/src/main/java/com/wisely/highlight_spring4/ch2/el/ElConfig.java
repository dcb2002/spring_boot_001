package com.wisely.highlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch2.el")
@PropertySource("classpath:com/wisely/highlight_spring4/ch2/el/test.properties")//7
public class ElConfig {
	
	@Value("I Love You!") //1 注入常量
    private String normal;

	@Value("#{systemProperties['os.name']}") //2 注入操作系统属性
	private String osName;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }") //3 注入表达式运算结果。
    private double randomNumber;

	@Value("#{demoService.another}") //4 注入容器中某个Bean的属性。
	private String fromAnother;

	@Value("classpath:com/wisely/highlight_spring4/ch2/el/test.txt") //5注入文件内容
	private Resource testFile;

	@Value("http://www.baidu.com") //6 注入网址内容
	private Resource testUrl;

	@Value("${book.name}") 			//7 注入属性文件中设置值。 ${} 而不是#{} 
	private String bookName;

	@Autowired
	private Environment environment; //7
	
	/**
	 * 
	 * 用@PropertySource注解可获取 属性配置文件中的内容。
	 * 用@Value 注解可获取 属性配置文件中的内容，也可以。但是需要注入PropertySourcesPlaceholderConfigurer这个Bean
	 * 
	 */
	@Bean //7
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	


	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));	//通过enviroment获得*.perpoties文件中的设置。
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
