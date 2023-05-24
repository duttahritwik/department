package com.duttahritwik.springboottutorial.controller;

import com.duttahritwik.springboottutorial.entity.Department;
import com.duttahritwik.springboottutorial.error.DepartmentNotFoundException;
import com.duttahritwik.springboottutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside save department service");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/get-departments")
    public List<Department> getAllDepartments() {
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("/get-department/{departmentId}")
    public Department getSpecificDepartment(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/delete-department/{departmentId}")
    public String deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("/update-department/{departmentId}")
    public Department updateDepartment(@PathVariable Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/get-department-by-name/{departmentName}")
    public Department getDepartmentByName(@PathVariable String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

}
