package com.example.assign5.models;

import javax.persistence.*;

@Entity
@Table(name="reviews")
@IdClass(ReviewId.class)
public class Review {
    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    private long userId;
    @Id
    @Column(name = "section_id",insertable = false, updatable = false)
    private long sectionId;
    private String title;
    private String review;
    private Integer stars;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="user", referencedColumnName="ID")
    private User user;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="section", referencedColumnName="ID")
    private Section section;
}
