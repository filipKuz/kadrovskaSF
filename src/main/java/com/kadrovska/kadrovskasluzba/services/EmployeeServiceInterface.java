package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.Employee;

public interface EmployeeServiceInterface {
	
	Employee findOne(Long id);
	List<Employee> findAll();
	Employee save(Employee e); 
	
}
