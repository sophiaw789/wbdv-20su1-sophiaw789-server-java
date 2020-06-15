package com.example.assign5.services;

import com.example.assign5.models.Widget;
import com.example.assign5.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {
    @Autowired
    WidgetRepository repository;

    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget(123, "Widget 1", "HEADING", 0, "Hello", 
                    "#", 3, 730, 100, "/styles", 
                    "background-color", "New Heading"));
        widgets.add(new Widget(234, "Widget 2", "PARAGRAPH", 1, "My Thesis",
                    "#", 1, 730, 100, "/styles",
                    "color", "New Paragraph"));
        widgets.add(new Widget(345, "Widget 3", "YOUTUBE", 2, "Video",
                    "#", 0, 730, 100, "/styles",
                    "color", "New Video"));
        widgets.add(new Widget(432, "Widget 4", "IMAGE", 3, "Photo",
                    "#", 0, 730, 100, "/styles",
                    "color", "New Image"));
    }
    public List<Widget> findWidgetsForTopic(String tid) {
        return (List<Widget>)repository.findAll();
//        List<Widget> result = new ArrayList<Widget>();
//
//        for (Widget w: widgets) {
//            if(w.getTopicId().equals(tid)) {
//                result.add(w);
//            }
//        }
//
//        return result;
    }
    public Widget findWidgetById(Integer wid) {
        for (Widget w: widgets) {
            if(w.getId().equals(wid)) {
                return w;
            }
        }
        return null;
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public List<Widget> deleteWidget(Integer wid) {
        List<Widget> result = new ArrayList<Widget>();
        for (Widget w: widgets) {
            if(!w.getId().equals(wid)) {
                result.add(w);
            }
        }
        this.widgets = result;
        return result;
    }

    public Widget createStandAloneWidget(Widget newWidget) {
        newWidget.setId(widgets.size() * 20);
        this.widgets.add(newWidget);
        return newWidget;
    }

    public Widget createWidget(String tid, Widget newWidget) {
        newWidget.setId(widgets.size() * 20);
        this.widgets.add(newWidget);
        return newWidget;
    }

    public Widget updateWidget(Integer widgetId, Widget updatedWidget) {
        for(int i=0; i<widgets.size(); i++) {
            if(widgets.get(i).getId().equals(widgetId)) {
                updatedWidget.setId(widgetId);
                widgets.set(i, updatedWidget);
                return updatedWidget;
            }
        }
        return null;
    }
}