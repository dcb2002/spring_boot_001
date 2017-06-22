package com.wisely.ch7_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch74Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch74Application.class, args);
    }
    
    
/**
 * 
 *  自定义 Web容器 通用 配置
 *  
 *   如果采用 内部类 ：一定要为 static
 *   
 */
    
//    @Component
//    public static class CustomServletContainer implements EmbeddedServletContainerCustomizer{
//
//		@Override
//		public void customize(ConfigurableEmbeddedServletContainer container) {
//			container.setPort(8888);//1
//			container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//			container.setSessionTimeout(10,TimeUnit.MINUTES);
//		}
//    	
//    }
    
    
/**
 * 
 *  自定义 Web容器 特定 配置（只针对 Tomcat设置）。
 *     
 */
    
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//    factory.setPort(8888);
//    factory.setSessionTimeout(10, TimeUnit.MINUTES);
//    factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//    return factory;
//    }
    


/**
 * 
 *  对内嵌Tomcat设置 http 转向 https。
 *     
 */

//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//      TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//          @Override
//          protected void postProcessContext(Context context) {
//            SecurityConstraint securityConstraint = new SecurityConstraint();
//            securityConstraint.setUserConstraint("CONFIDENTIAL");
//            SecurityCollection collection = new SecurityCollection();
//            collection.addPattern("/*");
//            securityConstraint.addCollection(collection);
//            context.addConstraint(securityConstraint);
//          }
//        };
//      
//      tomcat.addAdditionalTomcatConnectors(httpConnector());
//      return tomcat;
//    }
//    @Bean
//    public Connector httpConnector() {
//      Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//      connector.setScheme("http");
//      connector.setPort(8080);
//      connector.setSecure(false);
//      connector.setRedirectPort(8443);
//      return connector;
//    }
}
