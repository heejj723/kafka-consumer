package com.kafka.consumer.domain.topic.dto;

import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageTemplate {

  private Topic topic;
  private String text;

  @Builder.Default
  private ZonedDateTime createdTime = ZonedDateTime.now();



}
