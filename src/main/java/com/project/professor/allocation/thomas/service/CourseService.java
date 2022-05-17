package com.project.professor.allocation.thomas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.thomas.entity.Allocation;
import com.project.professor.allocation.thomas.entity.Course;
import com.project.professor.allocation.thomas.repository.AllocationRepository;
import com.project.professor.allocation.thomas.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;
	private final AllocationRepository allocationRepository;

	public CourseService(CourseRepository courseRepository, AllocationRepository allocationRepository) {
		super();
		this.courseRepository = courseRepository;
		this.allocationRepository = allocationRepository;
	}

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public Course findById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public List<Course> findByNameContainingIgnoreCase(String name) {
		return courseRepository.findByNameContainingIgnoreCase(name);
	}

	public Course save(Course course) {
		course.setId(null);
		return saveInternal(course);
	}

	public Course saveInternal(Course course) {
		course = courseRepository.save(course);

		List<Allocation> allocations = allocationRepository.findByCourseId(course.getId());
		course.setAllocations(allocations);

		return course;
	}

	public Course update(Course course) {
		Long id = course.getId();
		if (id != null && courseRepository.existsById(id)) {
			return saveInternal(course);
		}
		return null;
	}

	public void deleteById(Long id) {
		if (id != null && courseRepository.existsById(id)) {
			courseRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		courseRepository.deleteAll();
//		professorRepository.deleteAllInBatch();
	}

}
