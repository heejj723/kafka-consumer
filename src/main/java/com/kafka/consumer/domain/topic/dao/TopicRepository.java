package com.kafka.consumer.domain.topic.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepository {

  private final Map<String, String> topics = new HashMap<>();


  public ArrayList<String> findAllTopic() {
    return new ArrayList<String>(topics.values());
  }

}
