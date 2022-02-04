package com.exampleTask.Taskno1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.exampleTask.Taskno1.entities.Courses;
import com.exampleTask.Taskno1.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	
	
	//get the courses
	@GetMapping("/courses")
	public List<Courses>getCourses(){
		
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		
		
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	@PostMapping(path="/courses" ,consumes="application/json")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourses(course);
	}
@PutMapping("/courses")
public Courses updateCourse(@RequestBody Courses course) {
	return this.courseService.updateCourses(course);
	
}

@DeleteMapping("/courses/{courseId}")
public ResponseEntity<HttpStatus>deleteCourses(@PathVariable String courseId){
	try {
		this.courseService.deleteCourses(Long.parseLong(courseId));
		return new  ResponseEntity<>(HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}
