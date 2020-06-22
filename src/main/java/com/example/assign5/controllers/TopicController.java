package com.example.assign5.controllers;

import com.example.assign5.models.Topic;
import com.example.assign5.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    @Autowired
    TopicService service;

    @PostMapping("/api/lessons/{lessonId}/topics")
    public Topic createTopic(@PathVariable("lessonId") String lid, 
        @RequestBody Topic newTopic) {
        return service.createTopic(lid, newTopic);
    }

    @DeleteMapping("/api/topics/{tid}")
    public int deleteTopic(@PathVariable("tid") Integer tid) {
        return service.deleteTopic(tid);
    }

    @PutMapping("/api/topics/{tid}")
    public int updateTopic(@PathVariable("tid") Integer tid, @RequestBody Topic updateTopic) {
        return service.updateTopic(tid, updateTopic);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return service.findAllTopics();
    }

    @GetMapping("/api/topics/{topicId}")
    public Topic findTopicById(@PathVariable("topicId") Integer tid) {
        return service.findTopicById(tid);
    }

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(@PathVariable("lessonId") String lessonId) {
        return service.findTopicsForLesson(lessonId);
    }
}
