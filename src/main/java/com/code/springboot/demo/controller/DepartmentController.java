package com.code.springboot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.code.springboot.demo.error.DepartmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.springboot.demo.entity.Department;
import com.code.springboot.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
			LOGGER.info("Creating a department entity");
		return departmentService.saveDepartment(department);
		
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Getting a list of department entity");
		return departmentService.fetchDepartmentList();

	}

	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Getting a department entity by id");
		return departmentService.fetchDepartmentById(departmentId);

	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		LOGGER.info("Deleting a department entity by id");
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted sucessfully";

	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@Valid  @RequestBody Department department) {
		LOGGER.info("Updating a department entity by id");
		return departmentService.updateDepartment(departmentId, department);

	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		LOGGER.info("Getting a department entity by name");
		return departmentService.fetchDepartmentByName(departmentName);

	}
}