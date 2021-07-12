package com.in28minutes.database.databasedemo.springDataJpaRepos;

import com.in28minutes.database.databasedemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepoDataJPA extends JpaRepository<Course, Long> {//here we can change with CRUDRepository<Course,Long>
        public Course findByName(String name);
    public Course findByNameAndId(String name,Long id);//here And will be recognized by JPA and
    //will make such query
}
