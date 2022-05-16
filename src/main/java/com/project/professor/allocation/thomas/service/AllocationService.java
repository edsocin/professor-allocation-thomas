package com.project.professor.allocation.thomas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.thomas.entity.Allocation;
import com.project.professor.allocation.thomas.repository.AllocationRepository;

@Service
public class AllocationService {

//	private final AllocationRepository allocationRepository;
//    private final ProfessorService professorService;
//    private final CourseService courseService;
	private final AllocationRepository allocationRepository;
//	private final ProfessorService  professorService;
//	private final CourseService courseService;

	public AllocationService(AllocationRepository allocationRepository) {

		super();
		this.allocationRepository = allocationRepository;

	}

	public List<Allocation> findAll() {
		return this.allocationRepository.findAll();
	}

	public Allocation findById(Long id) {
		return allocationRepository.findById(id).orElse(null);
	}

	public Allocation save(Allocation allocation) {
		allocation.setId(null);
		return saveInternal(allocation);
	}

	private Allocation saveInternal(Allocation allocation) {
		allocation = allocationRepository.save(allocation);

//		Professor professor = professorService.findById(allocation.getProfessorId());
//		allocation.setProfessor(professor);

//		Course course = courseService.findById(allocation.getCourseId());
//		allocation.setCourse(course);

		return allocation;
	}

	public Allocation update(Allocation allocation) {
		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id)) {
			return saveInternal(allocation);
		} else {
			return null;
		}
	}

}
