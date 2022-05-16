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
    	List <Allocation> allocations =  allocationRepository.findAll();

        // Print
    	for (Allocation allocation2 : allocations) {
    		System.out.println(allocation2);
		}
    	
    	allocations.forEach(System.out::println);
        
    }

    @Test
    public void findById() {
        // Arrange
    	Optional<Allocation>  optionAllocation = allocationRepository.findById(100L);
        Allocation allocation = optionAllocation.orElse(null);

        // Act
        

        // Print
        System.out.println(allocation);
        
    }

    @Test
    public void findByProfessorId() {
        // Arrange
        

        // Act
        

        // Print
        
    }

    @Test
    public void findByCourseId() {
        // Arrange
        

        // Act
        

        // Print
        
    }

    @Test
    public void save_create() throws ParseException {
    	 // Arrange
        Allocation allocation = new Allocation();
        allocation.setId(null);
        allocation.setDay(DayOfWeek.SUNDAY);
        allocation.setStart(sdf.parse("16:00-0300"));
        allocation.setEnd(sdf.parse("20:00-0300"));
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
        allocation.setStart(sdf.parse("06:00-0300"));
        allocation.setEnd(sdf.parse("08:00-0300"));
        allocation.setProfessorId(1L);
        allocation.setCourseId(1L);

        // Act
        allocation = allocationRepository.save(allocation);

        // Print
        System.out.println(allocation);
        
    }

    @Test
    public void deleteById() {
    	// Arrange
    	List <Allocation> allocations =  allocationRepository.findAll();
    	allocations.forEach(System.out::println);
    	
    	allocationRepository.deleteById(1L);

        // Act
    	List <Allocation> allocations2 =  allocationRepository.findAll();
    	
    	// Print
    	allocations2.forEach(System.out::println);
        
    }

    @Test
    public void deleteAll() { // deletes podem ter só o delete sem as listagens
    	// Arrange
    	List <Allocation> allocations =  allocationRepository.findAll();
    	allocations.forEach(System.out::println);
    	
    	allocationRepository.deleteAll();

        // Act
    	List <Allocation> allocations2 =  allocationRepository.findAll();
    	
    	// Print
    	allocations2.forEach(System.out::println);
        
    }
}
