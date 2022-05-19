package com.project.professor.allocation.thomas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.thomas.entity.Department;
import com.project.professor.allocation.thomas.entity.Professor;
import com.project.professor.allocation.thomas.repository.DepartmentRepository;
import com.project.professor.allocation.thomas.repository.ProfessorRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final ProfessorRepository professorRepository;

	public DepartmentService(DepartmentRepository departmentRepository, ProfessorRepository professorRepository) {
		super();
		this.departmentRepository = departmentRepository;
		this.professorRepository = professorRepository;
	}

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public Department findById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}

	public List<Department> findByNameContainingIgnoreCase(String name) {
		return departmentRepository.findByNameContainingIgnoreCase(name);
	}

	public Department save(Department department) {
		department.setId(null);
		return saveInternal(department);
	}

	public Department saveInternal(Department department) {
		department = departmentRepository.save(department);

		List<Professor> professors = professorRepository.findByDepartmentId(department.getId());
		department.setProfessors(professors);

		return department;
	}

	public Department update(Department department) {
		Long id = department.getId();
		if (id != null && departmentRepository.existsById(id)) {
			return saveInternal(department);
		}
		return null;
	}

	public void deleteById(Long id) {
		if (id != null && departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		departmentRepository.deleteAll();
//		departmentRepository.deleteAllInBatch();
	}

}
