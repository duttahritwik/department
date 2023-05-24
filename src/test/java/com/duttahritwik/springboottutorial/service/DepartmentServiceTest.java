package com.duttahritwik.springboottutorial.service;

import com.duttahritwik.springboottutorial.entity.Department;
import com.duttahritwik.springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = new Department(1234L, "TECHNOLOGY",
                "Gurgaon, Haryana, India", "TECH-GUR");

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("TECHNOLOGY")).thenReturn(department);
    }

    @Test
    public void validateDepartmentName() {
        String departmentName = "TECHNOLOGY";

        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}