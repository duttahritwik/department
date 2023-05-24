package com.duttahritwik.springboottutorial.controller;

import com.duttahritwik.springboottutorial.entity.Department;
import com.duttahritwik.springboottutorial.error.DepartmentNotFoundException;
import com.duttahritwik.springboottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department(1L, "Legal",
                "Chennai, India", "LEGAL-CHENNAI");

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = new Department("Legal",
                "Chennai, India", "LEGAL-CHENNAI");

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").
                contentType(MediaType.APPLICATION_JSON).
                content("{\n" +
                        "        \"departmentName\": \"Legal\",\n" +
                        "        \"departmentAddress\": \"Chennai, India\",\n" +
                        "        \"departmentCode\": \"LEGAL-CHENNAI\"\n" +
                        "    }"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getSpecificDepartment() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/get-department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}