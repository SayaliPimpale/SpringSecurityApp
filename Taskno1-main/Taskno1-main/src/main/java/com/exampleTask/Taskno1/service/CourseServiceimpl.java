package com.exampleTask.Taskno1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exampleTask.Taskno1.entities.Courses;
@Service
public class CourseServiceimpl implements CourseService {

	List<Courses> list;
	
	public CourseServiceimpl () {
		list=new ArrayList<>();
		list.add(new Courses(145,"java course","this is springboot"));
		list.add(new Courses(145,"Springboot  course","Creating  springboot"));
	}
	
	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public Courses getCourse(long courseId) {
		Courses c=null;
		for(Courses course:list) {
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Courses addCourses(Courses course) {
		// TODO Auto-generated method stub
		list.add(course);
		
		return course;
	}
	
	@Override
	public Courses updateCourses(Courses course) {
		
		list.forEach(e ->{
			if(e.getId()== course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
				
			}
		});
		
		return course;
	}
	

	@Override
	public void deleteCourses(long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	

}
}
