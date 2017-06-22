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
	
	@Value("I Love You!") //1 ע�볣��
    private String normal;

	@Value("#{systemProperties['os.name']}") //2 ע�����ϵͳ����
	private String osName;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }") //3 ע�����ʽ��������
    private double randomNumber;

	@Value("#{demoService.another}") //4 ע��������ĳ��Bean�����ԡ�
	private String fromAnother;

	@Value("classpath:com/wisely/highlight_spring4/ch2/el/test.txt") //5ע���ļ�����
	private Resource testFile;

	@Value("http://www.baidu.com") //6 ע����ַ����
	private Resource testUrl;

	@Value("${book.name}") 			//7 ע�������ļ�������ֵ�� ${} ������#{} 
	private String bookName;

	@Autowired
	private Environment environment; //7
	
	/**
	 * 
	 * ��@PropertySourceע��ɻ�ȡ ���������ļ��е����ݡ�
	 * ��@Value ע��ɻ�ȡ ���������ļ��е����ݣ�Ҳ���ԡ�������Ҫע��PropertySourcesPlaceholderConfigurer���Bean
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
			System.out.println(environment.getProperty("book.author"));	//ͨ��enviroment���*.perpoties�ļ��е����á�
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}