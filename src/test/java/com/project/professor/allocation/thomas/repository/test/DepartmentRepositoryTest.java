package com.project.professor.allocation.thomas.repository.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.thomas.entity.Department;
import com.project.professor.allocation.thomas.repository.DepartmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	public void findAll() {
		// Act
		List<Department> departments = departmentRepository.findAll();

		// Print
		departments.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Department department = departmentRepository.findById(1L).orElse(null);

		// Print
		System.out.println(department);
	}

	public void findByNameContainingIgnoreCase() {
		// Act
		List<Department> departments = departmentRepository.findByNameContainingIgnoreCase("Tecnologia");

		// Print
		departments.forEach(System.out::println);
	}

	@Test
	public void save_create() throws ParseException {
		// Arrange
		Department department = new Department();
		department.setId(null);
		department.setName("Tecnologia da Informação");

		// Act
		department = departmentRepository.save(department);

		// Print
		System.out.println(department);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange
		Department department = new Department();
		department.setId(1L);
		department.setName("Engenharia de Software");

		// Act
		department = departmentRepository.save(department);

		// Print
		System.out.println(department);
	}

	@Test
	public void deleteById() {
		// Act
		departmentRepository.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		departmentRepository.deleteAll();
	}

}
