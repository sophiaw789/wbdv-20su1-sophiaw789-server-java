package com.example.assign5.models;

public class Widget {
    private Integer id;
    private String name;
    private String type;
    private String text;
    private Integer size;
    private String topicId;

    public Widget() {
    }

    public Widget(Integer id, String name, String type, 
                    String text, Integer size) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.text = text;
        this.size = size;
    }

    public Widget(Integer id, String name, String type, String topicId) {
        this.id = id;
        this.name = name;
        this.type = type;
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
}