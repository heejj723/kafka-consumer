package com.kafka.consumer.global.config;

import com.kafka.consumer.domain.topic.dto.MessageTemplate;
import com.kafka.consumer.domain.topic.dto.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageBroker {

  @MessageMapping("/all") // /pub/all 에 매핑
  @SendTo("/topic/")  // subscribe url :
  public String broadcasting(String message) throws Exception {
    System.out.println("message:" + message);
    return message;
  }

  // 메시지 유형에 따라 Mapping 추가
  @MessageMapping("/samsung") // /pub/samsung
  @SendTo("/topic/samsung") // /sub/topic/samsung 을 구독하고 있는 클라이언트에게 메시지를 보낸다.
  public MessageTemplate sendSamsung(MessageTemplate messageTemplate) throws Exception {

    log.info("MessageBroker: topic: {}, text: {}", messageTemplate.getTopic().getTopicName(), messageTemplate.getText());

    return messageTemplate;
  }

  @MessageMapping("/apple") // /pub/apple
  @SendTo("/topic/apple") // /sub/topic/apple
  public String sendApple(String message) throws Exception {
    System.out.println("apple message: " + message);
    return message;
  }

}
