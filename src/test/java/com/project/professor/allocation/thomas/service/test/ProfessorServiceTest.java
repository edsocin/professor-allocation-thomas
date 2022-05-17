package com.project.professor.allocation.thomas.service.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.thomas.entity.Professor;
import com.project.professor.allocation.thomas.service.ProfessorService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {

	@Autowired
	ProfessorService professorService;

	@Test
	public void findAll() {
		// Act
		List<Professor> professors = professorService.findAll();

		// Print
		professors.forEach(System.out::println);
	}

	@Test
	public void findAllByName() {
		// Act
		List<Professor> professors = professorService.findByNameContainingIgnoreCase("Brian O'Conner");

		// Print
		professors.forEach(System.out::println);
	}

	@Test
	public void findByDepartment() {
		// Act
		List<Professor> professors = professorService.findByDepartment(1L);

		// Print
		professors.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Professor professor = professorService.findById(1L);

		// Print
		System.out.println(professor);
	}

	@Test
	public void save() {
		// Arrange
		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("John Wick");
		professor.setCpf("656.020.870-28");
		professor.setDepartmentId(1L);

		// Act
		professor = professorService.save(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void update() {
		// Arrange
		Professor professor = new Professor();
		professor.setId(1L);
		professor.setName("Frank Castle");
		professor.setCpf("037.082.360-50");
		professor.setDepartmentId(1L);

		// Act
		professor = professorService.save(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void deleteById() {
		// Act
		professorService.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		professorService.deleteAll();
	}

}
