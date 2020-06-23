package com.example.assign5.services;

import com.example.assign5.models.Topic;
import com.example.assign5.models.Widget;
import com.example.assign5.repositories.TopicRepository;
import com.example.assign5.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    TopicRepository repository;
    @Autowired
    WidgetRepository widgetRepository;
    @Autowired
    WidgetService service;

    public Topic createTopic(String lid, Topic topic) {
        topic.setLessonId(lid);
        return repository.save(topic);
    }

    public int deleteTopic(int tid) {
        List<Widget> widgets = widgetRepository.findWidgetsForTopic(tid);
        for (Widget w : widgets) {
            service.deleteWidget(w.getId());
        }
        try {
            repository.deleteById(tid);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public int updateTopic(int tid, Topic updateTopic) {
        Topic topic = repository.findTopicById(tid);
        topic.set(updateTopic);
        try {
            repository.save(topic);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public List<Topic> findAllTopics() {
        return repository.findAllTopics();
        //return (List<Topic>)repository.findAll();
    }

    public Topic findTopicById(Integer tid) {
        return repository.findTopicById(tid);
//        Optional<Topic> optional = repository.findById(tid);
//        if(optional.isPresent()) {
//            return optional.get();
//        }
//        return null;
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        return repository.findTopicsForLesson(lessonId);
    }
}
