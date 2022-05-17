package com.project.professor.allocation.thomas.service.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.thomas.entity.Course;
import com.project.professor.allocation.thomas.service.CourseService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTest {

	@Autowired
	CourseService courseService;

	@Test
	public void findAll() {
		// Act
		List<Course> courses = courseService.findAll();

		// Print
		courses.forEach(System.out::println);
	}

	@Test
	public void findAllByName() {
		// Act
		List<Course> courses = courseService.findByNameContainingIgnoreCase("Frontend");

		// Print
		courses.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Course course = courseService.findById(1L);

		// Print
		System.out.println(course);
	}

	@Test
	public void save() {
		// Arrange
		Course course = new Course();
		course.setId(null);
		course.setName("Governanaça de TI");

		// Act
		course = courseService.save(course);

		// Print
		System.out.println(course);
	}

	@Test
	public void update() {
		// Arrange
		Course course = new Course();
		course.setId(1L);
		course.setName("Banco de Dados");

		// Act
		course = courseService.update(course);

		// Print
		System.err.println(course);
	}

	@Test
	public void deleteById() {
		// Act
		courseService.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		courseService.deleteAll();
	}

}
