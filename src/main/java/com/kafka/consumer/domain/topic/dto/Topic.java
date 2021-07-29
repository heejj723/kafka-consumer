package com.kafka.consumer.domain.topic.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Topic {

  @Builder.Default
  private String topicId = UUID.randomUUID().toString();
  private String topicName;
}
