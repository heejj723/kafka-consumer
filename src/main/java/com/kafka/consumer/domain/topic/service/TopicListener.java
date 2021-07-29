package com.kafka.consumer.domain.topic.service;

import com.kafka.consumer.domain.topic.dto.MessageTemplate;
import com.kafka.consumer.domain.topic.dto.Topic;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicListener {

  private final SimpMessagingTemplate template;

  @KafkaListener(topics = "samsung", groupId = "group-id-heej")
  public void listenSamsung(String message) throws IOException {
    // TODO: MessageBroker (/pub/samsung) 로 삼성 토픽 보내기
    MessageTemplate messageTemplate = MessageTemplate.builder()
      .text(message)
      .topic(Topic.builder().topicName("samsung").build())
      .build();

    log.info("KafkaListener(Samsung): {}, created at [{}]", message, messageTemplate.getCreatedTime());
    template.convertAndSend("/pub/samsung", messageTemplate);
  }

}
