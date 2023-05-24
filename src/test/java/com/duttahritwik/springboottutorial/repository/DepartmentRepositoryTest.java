package com.duttahritwik.springboottutorial.repository;

import com.duttahritwik.springboottutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = new Department("MECHANICAL_ENGINEERING",
                "Surathkal, India", "MECH_SURATHKAL");

        testEntityManager.persist(department);
    }

    @Test
    public void validateDepartmentID() {
        Department department = departmentRepository.findById(2L).get();

        assertEquals(department.getDepartmentName(), "MECHANICAL_ENGINEERING");
    }
}