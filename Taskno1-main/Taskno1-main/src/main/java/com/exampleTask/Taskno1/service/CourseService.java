package com.exampleTask.Taskno1.service;

import java.util.List;

import com.exampleTask.Taskno1.entities.Courses;
public interface CourseService {
 public List<Courses> getCourses();
 
 public Courses getCourse(long courseId);
 public Courses addCourse(Courses course);

public Courses addCourses(Courses course);

public Courses updateCourses(Courses course);

public void deleteCourses(long parseLong);


}
