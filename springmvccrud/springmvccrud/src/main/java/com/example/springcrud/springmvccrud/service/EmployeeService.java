package com.example.springcrud.springmvccrud.service;

import java.util.List;

import com.example.springcrud.springmvccrud.model.Employee;

public interface EmployeeService {
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}