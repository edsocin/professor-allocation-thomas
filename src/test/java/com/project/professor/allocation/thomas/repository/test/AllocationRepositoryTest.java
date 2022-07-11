package com.project.professor.allocation.thomas.repository.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.thomas.entity.Allocation;
import com.project.professor.allocation.thomas.repository.AllocationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationRepository allocationRepository;

	@Test
	public void findAll() {
		// Act
		List<Allocation> allocations = allocationRepository.findAll();

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Act
		Optional<Allocation> optionAllocation = allocationRepository.findById(100L);
		Allocation allocation = optionAllocation.orElse(null);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void findByProfessorId() {
		// Act
		List<Allocation> allocations = allocationRepository.findByProfessorId(1L);

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findByCourseId() {
		// Act
		List<Allocation> allocations = allocationRepository.findByCourseId(1L);

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void save_create() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(DayOfWeek.SUNDAY);
		allocation.setStartHour(sdf.parse("16:00-0300"));
		allocation.setEndHour(sdf.parse("20:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = allocationRepository.save(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(1L);
		allocation.setDay(DayOfWeek.FRIDAY);
		allocation.setStartHour(sdf.parse("06:00-0300"));
		allocation.setEndHour(sdf.parse("08:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = allocationRepository.save(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void deleteById() {
		// Act
		allocationRepository.deleteById(1L);
	}

	@Test
	public void deleteAll() {
		// Act
		allocationRepository.deleteAll();
	}

}
