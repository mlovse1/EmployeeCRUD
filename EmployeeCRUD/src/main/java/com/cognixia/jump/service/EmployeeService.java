package com.cognixia.jump.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Employee;


@Service
public class EmployeeService {

	private static List<Employee> employeeDatabase = new ArrayList<>();
	private static int idCounter = 1;
	
	static {
		employeeDatabase.add(new Employee(idCounter++, "Agent", "K", LocalDate.of(1948, 6, 5), "NYC"));
		employeeDatabase.add(new Employee(idCounter++, "Agent", "Q", LocalDate.of(1998, 7, 1), "FTW"));
		employeeDatabase.add(new Employee(idCounter++, "Agent", "J", LocalDate.of(2003, 8, 5), "DAL"));
		employeeDatabase.add(new Employee(idCounter++, "Agent", "T", LocalDate.of(2010, 3, 5), "FTW"));
		employeeDatabase.add(new Employee(idCounter++, "Agent", "D", LocalDate.of(2000, 2, 14), "SAC"));
		employeeDatabase.add(new Employee(idCounter++, "Agent", "A", LocalDate.of(1995, 4, 1), "NYC"));
	
	}
	
	public List<Employee> getAllEmployees() {
		return employeeDatabase;
	}
	
	public Employee getEmployeeById(int id) {
		
		for(Employee e : employeeDatabase) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	public List<Employee> getEmployeeByDept(String dept){
		
		List<Employee> results = new ArrayList<>();
		
		results = employeeDatabase.stream().filter(e -> e.getDept().equalsIgnoreCase(dept))
				.collect(Collectors.toList());
		
		return results;
	}
	
	public Employee addEmployee(Employee input) {
		Employee newEmployee = input;
		input.setId(idCounter++);
		employeeDatabase.add(input);
		return input;
	}
	
	public Employee updateEmployee(Employee input) {
		Employee toUpdate = getEmployeeById(input.getId());
		
		if (input.getId() != -1) {
			toUpdate.setFirstName(input.getFirstName());
			toUpdate.setLastName(input.getLastName());
			toUpdate.setDob(input.getDob());
			toUpdate.setDept(input.getDept());
		}
		return toUpdate;
	}
	
	public Employee deleteEmployee(int id) {
		Employee toUpdate = getEmployeeById(id);
		
		if (toUpdate.getId() != -1) {
			employeeDatabase.remove(toUpdate);
		}
		return toUpdate;
	}
	
	
	
	
	
	
	
}
