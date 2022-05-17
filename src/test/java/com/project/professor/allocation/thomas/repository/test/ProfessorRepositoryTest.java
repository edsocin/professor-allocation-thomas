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

import com.project.professor.allocation.thomas.entity.Professor;
import com.project.professor.allocation.thomas.repository.ProfessorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	ProfessorRepository professorRepository;

	@Test
	public void findAll() {
		// Act
		List<Professor> professors = professorRepository.findAll();

		// Print
		professors.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Professor professor = professorRepository.findById(1L).orElse(null);

		// Print
		System.out.println(professor);
	}

	@Test
	public void findByDepartmentId() {
		// Act
		List<Professor> professors = professorRepository.findByDepartmentId(1L);

		// Print
		professors.forEach(System.out::println);
	}

	@Test
	public void findByNameContainingIgnoreCase() {
		// Arrange
		String busca = "Brian O'Conner";

		// Act
		List<Professor> professors = professorRepository.findByNameContainingIgnoreCase(busca);

		// Print
		professors.forEach(System.out::println);
	}

	@Test
	public void save_create() throws ParseException {
		// Arrange
		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Brian O'Conner");
		professor.setCpf("059.526.800-54");
		professor.setDepartmentId(1L);

		// Act
		professor = professorRepository.save(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange
		Professor professor = new Professor();
		professor.setId(1L);
		professor.setName("Dominic Toretto");
		professor.setCpf("422.249.250-77");
		professor.setDepartmentId(1L);

		// Act
		professor = professorRepository.save(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void deleteById() {
		// Act
		professorRepository.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		professorRepository.deleteAll();
	}

}
