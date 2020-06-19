package com.example.assign5.models;

public class Widget {
    private Integer id;
    private String name;
    private String type;
    private String text;
    private Integer size;
    private Integer widgetOrder;
    private String topicId;

    public Widget() {
    }

    public Widget(Integer id, String name, String type, 
                    String text, Integer size, Integer widgetOrder) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.text = text;
        this.size = size;
        this.widgetOrder = widgetOrder;
    }

    public Widget(Integer id, String name, String type, 
                    String text, Integer size, Integer widgetOrder, String topicId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.text = text;
        this.size = size;
        this.widgetOrder = widgetOrder;
        this.topicId = topicId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }
}