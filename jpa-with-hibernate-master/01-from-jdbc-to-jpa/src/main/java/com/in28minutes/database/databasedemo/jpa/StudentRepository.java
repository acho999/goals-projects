package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Passport;
import com.in28minutes.database.databasedemo.entity.Student;
import com.in28minutes.database.databasedemo.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional//proper place for this is service; everything in this class is in one transaction
public class StudentRepository {

    @PersistenceContext
    public EntityManager manager;

    public void save(Student student){
        if(student.getId() == null){
            this.manager.persist(student);
        } else {
            this.manager.merge(student);//here we update
        }
    }

    @Transactional//we add this because of Leazy loading because it needs to have session otherwise will have
    //exception - no session Wen we use Transactional all in method anotated with it is in Persistance context
    //in our case in Persistance context we will have passport and student objects
    //also with this anotation in method we will have one transaction but not transaction for any operation
    //this will be performance optimisaton
    public Student retrieveTheStudent(long id){

        Student student = this.manager.find(Student.class,id);
        Passport passport = student.getPassport();
        student.setName("Gosho");
        passport.setNumber("12345L");//we use transactional also to ensure that if setNumber fails
        //the database will not being changed
        System.out.println(student.getPassport().getNumber());
        return student;
    }

    public void playWithWntityManager(){

        Student st = new Student("Pesho");

        this.manager.persist(st);
        this.manager.flush();//this method send and save every changes until that point to database

        st.setName("Other");//here since cource is tracked from manager and it is attached to context
        //after saving if we change something it will be changed bacause of tracking and because it is
        //in single transaction
        this.manager.flush();

        Student student1 = new Student("Something1");

        this.manager.persist(student1);
        this.manager.flush();
        //if we do not want to track changes which we will made below with setName, we can do
        manager.detach(student1);//that way Student1 is detached from context and it is not tracked
        //and code below will not have influence the same thing can be achieved with manager.clear().
        student1.setName("Another");
        this.manager.refresh(student1);//with this method changes we made above will not be saved and
        //that way we revert the changes and name will be Something1 not Another
        this.manager.flush();
    }

}
