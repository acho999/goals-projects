package com.in28minutes.database.databasedemo.springDataJpaRepos;

import com.in28minutes.database.databasedemo.entity.Course;

import java.util.List;

public interface ICOurseService {

     Course findCourseById(Long id);

     List<Course> findAllStudents();

}
