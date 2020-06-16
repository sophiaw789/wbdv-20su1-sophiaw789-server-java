package com.example.assign5.services;

import com.example.assign5.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();
    {}

    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> result = new ArrayList<Widget>();

        for (Widget w : widgets) {
            if (w.getTopicId().equals(tid)) {
                result.add(w);
            }
        }

        return result;
    }

    public Widget findWidgetById(Integer wid) {
        for (Widget w : widgets) {
            if (w.getId().equals(wid)) {
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
        for (Widget w : widgets) {
            if (!w.getId().equals(wid)) {
                result.add(w);
            }
        }
        this.widgets = result;
        return result;
    }

    /*
     * public Widget createStandAloneWidget(Widget newWidget) {
     * newWidget.setId(widgets.size() * 20); this.widgets.add(newWidget); return
     * newWidget; }
     */
    public Widget createWidget(Widget newWidget) {
        newWidget.setId(widgets.size() * 20 + 21);
        this.widgets.add(newWidget);
        return newWidget;
    }

    public Widget updateWidget(Integer widgetId, Widget updatedWidget) {
        for (int i = 0; i < widgets.size(); i++) {
            if (widgets.get(i).getId().equals(widgetId)) {
                updatedWidget.setId(widgetId);
                widgets.set(i, updatedWidget);
                return updatedWidget;
            }
        }
        return null;
    }
}