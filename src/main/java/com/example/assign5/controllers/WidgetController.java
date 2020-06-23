package com.example.assign5.controllers;

import com.example.assign5.models.Widget;
import com.example.assign5.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    /*
     * CRUD C - Create - done R - Read - done U - Update - done D - Delete - done
     */

    @Autowired
    WidgetService widgetService;

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") Integer widgetId, @RequestBody Widget updatedWidget) {
        return widgetService.updateWidget(widgetId, updatedWidget);
    }

    /*
     * @PostMapping("/api/widgets") public Widget
     * createStandAloneWidget(@RequestBody Widget newWidget) { return
     * widgetService.createStandAloneWidget(newWidget); }
     */
    @PostMapping("/api/topics/{tid}/widgets")
    public int createWidget(@PathVariable("tid") Integer topicId, 
    @RequestBody Widget newWidget) {
        return widgetService.createWidget(topicId, newWidget);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Integer wid) {
        return widgetService.findWidgetById(wid);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") Integer wid) {
        return widgetService.deleteWidget(wid);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") Integer tid) {
        return widgetService.findWidgetsForTopic(tid);
    }
}