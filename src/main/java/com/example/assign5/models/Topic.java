package com.example.assign5.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String lessonId; // stores the _id of the lesson instance in generic server

    @OneToMany(mappedBy = "topic")
    private List<Widget> widgets;

    public void set(Topic topic) {
        this.id = topic.id;
        this.title = topic.title;
        this.description = topic.description;
        this.lessonId = topic.lessonId;
        this.widgets = topic.widgets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }
}
