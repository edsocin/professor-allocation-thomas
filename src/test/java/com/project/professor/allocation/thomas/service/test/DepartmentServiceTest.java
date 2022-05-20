package com.project.professor.allocation.thomas.service.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.thomas.entity.Department;
import com.project.professor.allocation.thomas.service.DepartmentService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTest {

	DepartmentService departmentService;

	@Test
	public void findAll() {
		// Act
		List<Department> departments = departmentService.findAll();

		// Print
		departments.forEach(System.out::println);
	}

	@Test
	public void findAllByName() {
		// Act
		List<Department> departments = departmentService.findByNameContainingIgnoreCase("Tecnologia da Informação");

		// Print
		departments.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Department department = departmentService.findById(1L);

		// Print
		System.out.println(department);
	}

	@Test
	public void save() {
		// Arrange
		Department department = new Department();
		department.setId(null);
		department.setName("Bussiness Intelligence");

		// Act
		department = departmentService.save(department);

		// Print
		System.err.println(department);
	}

	@Test
	public void update() {
		// Arrange
		Department department = new Department();
		department.setId(1L);
		department.setName("Governança de Dados");

		// Act
		department = departmentService.update(department);

		// Print
		System.out.println(department);
	}

	@Test
	public void deleteById() {
		// Act
		departmentService.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		departmentService.deleteAll();
	}

}
