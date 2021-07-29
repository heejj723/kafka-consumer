package com.kafka.consumer.global.config;

import com.kafka.consumer.domain.message.dto.Message;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaTopicListenerService {

  private final SimpMessagingTemplate template;
  private String message = "";


  @KafkaListener(topics = "samsung", groupId = "group-id-heej")
  public void listenSamsung(String message) throws IOException {
    // TODO: MessageBroker (/pub/samsung) 로 삼성 토픽 보내기
    Message messageObject = Message.builder().topic("samsung").text(message).build();
    template.convertAndSend("/pub/samsung", messageObject);
  }

  private void setMessage(String newMessage) {
    this.message = newMessage;
  }

  public String getMessage() {
    return this.message;
  }



}
