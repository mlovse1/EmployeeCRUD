package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Employee;
import com.cognixia.jump.service.EmployeeService;

@RequestMapping("/api/employees")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@GetMapping("/id/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return service.getEmployeeById(Integer.parseInt(id));
	}
	
	@GetMapping("dept/{dept}")
	public List<Employee> getEmployeeInDept(@PathVariable String dept) {
		return service.getEmployeeByDept(dept);
	}
	
	//Create Employee
	@PostMapping("/create/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		
		Employee newEmployee = service.addEmployee(employee);
		
		//print to console, not postman
		System.out.println("New employee added: " + newEmployee);
		
		return ResponseEntity.ok(newEmployee + " created.");
		
	}
	
	//update student - full update - all fields = Put
	//update student - partial update - some fields = Patch
	@PutMapping("/update/employee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee input){
		
		Employee toUpdate = service.updateEmployee(input);
		
		return ResponseEntity.ok(toUpdate + " updated.");
		
		
	}
	
	//Delete Student
	@DeleteMapping("/delete/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id){
		Employee deleted = service.deleteEmployee(id);
		
		return ResponseEntity.ok(deleted + "deleted.");
		
	}
	
	
	
}
