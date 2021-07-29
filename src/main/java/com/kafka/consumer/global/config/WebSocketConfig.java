package com.kafka.consumer.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  // WebSocket client 가 최초 웹소켓 핸드셰이크 커넥션을 생성할 경로이다.
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws")
      .setAllowedOrigins("*").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    // 클라이언트에서 메시지 보내줄 때 붙여줄 prefix 정의
    config.setApplicationDestinationPrefixes("/pub");
    // 이 경로로 SimpleBroker 를 등록한다.
    // 해당 경로를 Subscribe 하는 클라이언트들에게 메시지를 전달한다.
    config.enableSimpleBroker("/sub");
  }
}
