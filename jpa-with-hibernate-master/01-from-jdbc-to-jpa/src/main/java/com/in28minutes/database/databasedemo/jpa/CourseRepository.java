package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional//proper place for this is service; everything in this class is in one transaction
public class CourseRepository {

    @PersistenceContext
    public EntityManager manager;

    public void save(Course course){
        if(course.getId() == null){
            this.manager.persist(course);
        } else {
            this.manager.merge(course);//here we update
        }
    }

    public void playWithWntityManager(){

        Course course = new Course("Something");

        this.manager.persist(course);
        this.manager.flush();//this method send and save every changes until that point to database

        course.setName("Other");//here since cource is tracked from manager and it is attached to context
        //after saving if we change something it will be changed bacause of tracking and because it is
        //in single transaction
        this.manager.flush();

        Course course1 = new Course("Something1");

        this.manager.persist(course1);
        this.manager.flush();
        //if we do not want to track changes which we will made below with setName, we can do
        manager.detach(course1);//that way course1 is detached from context and it is not tracked
        //and code below will not have influence
        course1.setName("Another");
        this.manager.refresh(course1);//with this method changes we made above will not be saved and
        //that way we revert the changes and name will be Something1 not Another
        this.manager.flush();
    }

}
