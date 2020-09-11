package com.example.hello.controller;

import com.example.hello.model.Topic;
import com.example.hello.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

//dapetin isi Topic
    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
//dapetin isi topik dari id path variable yg dipilih
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
//dapetin isi topik dari query param
    @GetMapping("/topics/")
    @ResponseBody
    public Topic getById(@RequestParam String id){
        return topicService.getById(id);
    }
//ngambil nilai dari masukan di postman
    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

}
