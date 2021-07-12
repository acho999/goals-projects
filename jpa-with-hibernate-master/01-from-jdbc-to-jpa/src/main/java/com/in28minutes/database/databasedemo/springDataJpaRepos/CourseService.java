package com.in28minutes.database.databasedemo.springDataJpaRepos;

import com.in28minutes.database.databasedemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICOurseService{

    @Autowired
    CourseRepoDataJPA repo;

    @Override
    public Course findCourseById(Long id) {
        return this.repo.findById(id).get();//here we have get() because findById returns Optional
    }

    @Override
    public List<Course> findAllStudents() {
        PageRequest pages = PageRequest.of(0,3);
        Page<Course> firstPage = this.repo.findAll(pages);
        Pageable secondPage = firstPage.nextPageable();//here we can do pagination
        List<Course> courses = this.repo.findAll(Sort.by("name").descending());
        //that way we sort the result by name descending
        return courses;
    }

    public Course findByName(String name){
        return this.repo.findByName(name);//here we use other JPA methods for CRUD oparations
    }

    public Course findByNameAndId(String name,Long id){
        return this.repo.findByNameAndId(name,id);//here we use other JPA methods for CRUD oparations
    }
}
