package com.cognixia.jump.model;

import java.time.LocalDate;

public class Employee {

	//attributes
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String dept;
	
	
	public Employee() {
		this(-1, "N/A", "N/A", LocalDate.now(), "N/A");
	}
	
	
	public Employee(int id, String firstName, String lastName, LocalDate dob, String dept) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.dept = dept;
	}
	
	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", dept="
				+ dept + "]";
	}
	
	
	
	
	
	
	
	
	
}
