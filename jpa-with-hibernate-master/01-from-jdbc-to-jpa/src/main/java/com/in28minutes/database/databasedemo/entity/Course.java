package com.in28minutes.database.databasedemo.entity;

import java.util.ArrayList;
import java.util.List;
import com.in28minutes.database.databasedemo.entity.Review;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
@Cacheable//this enables second level cashing for this entity
@SQLDelete(sql="update courses set id_deleted=true where id=?")//here we put this in order to
//change property id_deleted and to not delete antity from table courses but only to mark it
//in column id_deleted as true, but when we retrieve courses this row will apear even it is being deleted
//to prevent that we will use @Where
@Where(clause = "is_deleted = false")//here we tell that when we retrieve the courses it have to
//omit these with is_deleted = true
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private boolean is_deleted;

    @PreRemove//here we make is_deleted true when in same transaction where it is being deleted
    //// we attempt to access the property
    //is_deleted @PreRemove is hook and there are another hooks which can be called there are pre delete post delete
    //pre persist post persist
    private void preRemove(){
        this.is_deleted = true;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @Column(nullable = false,name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public Course(){}

    public Course(String name){
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
