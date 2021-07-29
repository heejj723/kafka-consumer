package com.kafka.consumer.domain.topic.api;

import com.kafka.consumer.domain.topic.dao.TopicRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

  private final TopicRepository topicRepository;

  @GetMapping("/topics")
  @ResponseBody
  public ArrayList<String> topics() {
    return topicRepository.findAllTopic();
  }



}
