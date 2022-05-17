package com.project.professor.allocation.thomas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.thomas.entity.Allocation;
import com.project.professor.allocation.thomas.entity.Professor;
import com.project.professor.allocation.thomas.repository.AllocationRepository;
import com.project.professor.allocation.thomas.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;
//	private final DepartmentService departmentService;
	private final AllocationRepository allocationRepository;

//	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService, AllocationRepository allocationRepository) {

	public ProfessorService(ProfessorRepository professorRepository, AllocationRepository allocationRepository) {
		super();
		this.professorRepository = professorRepository;
//		this.departmentService = departmentService;
		this.allocationRepository = allocationRepository;
	}

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	public List<Professor> findByNameContainingIgnoreCase(String name) {
		return professorRepository.findByNameContainingIgnoreCase(name);
	}

	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}

	public List<Professor> findByDepartment(Long departmentId) {
		return professorRepository.findByDepartmentId(departmentId);
	}

	public Professor save(Professor professor) {
		professor.setId(null);
		return saveInternal(professor);
	}

	public Professor saveInternal(Professor professor) {
		professor = professorRepository.save(professor);

		// Department department = departmentService.
		// professor.setDepartment(department);

		List<Allocation> allocations = allocationRepository.findByProfessorId(professor.getId());
		professor.setAllocations(allocations);

		return professorRepository.save(professor);
	}

	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id != null && professorRepository.existsById(id)) {
			return saveInternal(professor);
		}
		return null;
	}

	public void deleteById(Long id) {
		if (id != null && professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		professorRepository.deleteAll();
//		professorRepository.deleteAllInBatch();
	}

}
