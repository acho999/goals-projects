package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Review {

    @Id
    @GeneratedValue
    private Long Id;

    @Enumerated(EnumType.STRING)//here we mapp enumeration and it is good to
    //add EnumType.STRING but not EnumType.ORDINAL and when we insert values we will insert strings
    //because if we use ordinal if we add a new value the ordinal will change itself.
    private ReviewRating rating;

    @Column(nullable = false, name = "description")
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Course course;

    public Review(){}

    public Review(ReviewRating rating,String descr){
        this.description = descr;
        this.rating = rating;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public void setRating(ReviewRating rating) {
        this.rating = rating;
    }
}
