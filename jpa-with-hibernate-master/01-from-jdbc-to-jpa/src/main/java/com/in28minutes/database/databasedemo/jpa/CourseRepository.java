package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Course;
import com.in28minutes.database.databasedemo.entity.Review;
import com.in28minutes.database.databasedemo.entity.ReviewRating;
import com.in28minutes.database.databasedemo.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;

import java.util.ArrayList;
import java.util.List;

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
        //and code below will not have influence the same thing can be achieved with manager.clear().
        course1.setName("Another");
        this.manager.refresh(course1);//with this method changes we made above will not be saved and
        //that way we revert the changes and name will be Something1 not Another
        this.manager.flush();
    }

    public void addReviewsForCourse(){

         Course course = this.manager.find(Course.class,5L);

        Review review = new Review(ReviewRating.FOUR,"Java");

        List<Review> reviews = new ArrayList<>();

        reviews.add(review);

        course.setReviews(reviews);//here we set reviews for the course

        review.setCourse(course);//here we set cource for particular review

        this.manager.persist(review);//here we add review in database, cource is retrieved from database and it is tracked
        //that is why changes are made immediately when we set reviews for the course

    }

    @Transactional//we make this because of fetching strategy needs persistance context, transactional also
    //enables first level cash i.e in one transaction if we have two quires which are same when first is executed
    //it will be cashed and secon will not go to the database, first level cash is autoconfigured
    @org.springframework.transaction.annotation.Transactional(isolation = Isolation.SERIALIZABLE)//this is for
    //managing multiple transactions and in it we can choose isolation level
    public List<Review> getReviewsForCource(Long courseId){

        Course course = this.manager.find(Course.class, courseId);

        return course.getReviews();//this operation needs context

    }

    @Transactional//we make this because of fetching strategy needs persistance context
    public Course getCourseForReview(Long reviewId){

        Review review = this.manager.find(Review.class, reviewId);

        return review.getCourse();//this operation needs context

    }

    @Transactional//we make this because of fetching strategy needs persistance context
    public List<Student> getStudentsForCourse(Long courseId){

        Course course = this.manager.find(Course.class, courseId);

        return course.getStudents();//this operation needs context

    }
    @Transactional//we make this because of fetching strategy needs persistance context
    public List<Course> getCoursesForStudent(Long studentId){

        Student student = this.manager.find(Student.class, studentId);

        return student.getCourses();//this operation needs context

    }

}
