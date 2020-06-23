package com.example.assign5.services;

import com.example.assign5.models.Topic;
import com.example.assign5.models.Widget;
import com.example.assign5.repositories.TopicRepository;
import com.example.assign5.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;
    TopicRepository topicRepository;
    TopicService topicService;

    List<Widget> widgets = new ArrayList<Widget>();
    {
    }

    public List<Widget> findWidgetsForTopic(Integer tid) {
        return repository.findWidgetsForTopic(tid);
    }

    public Widget findWidgetById(Integer wid) {
        return repository.findWidgetById(wid);
    }

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }

    public int deleteWidget(Integer wid) {
        try {
            repository.deleteById(wid);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    /*
     * public Widget createStandAloneWidget(Widget newWidget) {
     * newWidget.setId(widgets.size() * 20); this.widgets.add(newWidget); return
     * newWidget; }
     */

    public Widget createWidget(Integer tid, Widget newWidget) {
        Topic topic = topicService.findTopicById(tid);
        newWidget.setTopic(topic);
        return repository.save(newWidget);
    }

    public int updateWidget(Integer widgetId, Widget updatedWidget) {
        Widget widget = repository.findWidgetById(widgetId);
        widget.set(updatedWidget);
        try {
            repository.save(widget);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}