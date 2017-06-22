package com.wisely.ch7_6;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker		//【1】开启基于代理的消息。
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS(); 	//【2】注册STOMP节点，指定SockJS协议，映射URL。
        registry.addEndpoint("/endpointChat").withSockJS();		//【2.1】注册一个聊天的：endpoint	
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue","/topic"); //【3】广播主题代理：topic
        																		//【3.1】点对点代理：queue
    }

}
