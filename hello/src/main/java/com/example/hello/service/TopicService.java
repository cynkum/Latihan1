package com.example.hello.service;

import com.example.hello.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("react", "React JS", "React JS Description"),
            new Topic("kafka", "Kafka Message", "Kafka Message Description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }
//find element by ID (path variable)
    public Topic getTopic(String id){
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }
//find element by ID juga tp buat query param
    public Topic getById(String id){
        return topics.stream().filter(topic -> topic.getId().equals(id)).findAny().orElse(null);
    }
}
