package com.example.assign5.models;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@IdClass(ReviewId.class)
public class Review {
    @Id
    private long userId;
    @Id
    private Integer section_id;
    private String title;
    private String review;
    private Integer stars;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "user", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "section", referencedColumnName = "ID")
    private Section section;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Integer getSectionId() {
        return section_id;
    }

    public void setSectionId(Integer section_id) {
        this.section_id = section_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}