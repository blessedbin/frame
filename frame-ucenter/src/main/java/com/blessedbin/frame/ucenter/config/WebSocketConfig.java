package com.blessedbin.frame.ucenter.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * Created by xubin on 2018/7/12.
 *
 * @author 37075
 * @date 2018/7/12
 * @time 11:55
 * @tool intellij idea
 */

@Configuration
@EnableWebSocketMessageBroker
@Log4j2
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息
        registry.enableSimpleBroker("/topic","/user");
        // 指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
        registry.setApplicationDestinationPrefixes("/app");
        //推送用户前缀
        registry.setUserDestinationPrefix("/user");

    }

    /**
     * * 复写了 registerStompEndpoints() 方法：添加一个服务端点，来接收客户端的连接。将 "/endpointChat" 路径注册为 STOMP 端点。
     * 	 * 这个路径与发送和接收消息的目的路径有所不同， 这是一个端点，客户端在订阅或发布消息到目的地址前，要连接该端点，
     * 	 * 即用户发送请求 ：url="/127.0.0.1:8080/endpointChat" 与 STOMP server 进行连接，之后再转发到订阅url；
     * 	 *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //添加一个/endpointChat端点，客户端就可以通过这个端点来进行连接；withSockJS作用是添加SockJS支持
        registry.addEndpoint("/endpoint").setAllowedOrigins("http://localhost:9528")
                .withSockJS();
    }


    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.setSendTimeLimit(2 * 1000)
                .setSendBufferSizeLimit(20 * 1024 * 1024)
                .setMessageSizeLimit(20 * 1024 * 1024);
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(11920);
        container.setMaxBinaryMessageBufferSize(11920);
        return container;
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            /**
             * Invoked before the Message is actually sent to the channel.
             * This allows for modification of the Message if necessary.
             * If this method returns {@code null} then the actual
             * send invocation will not occur.
             *
             * @param message
             * @param channel
             */
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
//                    Authentication user = ... ; // access authentication header(s)
//                    accessor.setUser(user);
                }
                // log.debug(message);
                return message;
            }
        });
    }
}
