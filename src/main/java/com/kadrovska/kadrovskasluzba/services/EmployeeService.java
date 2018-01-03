package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.repositories.EmployeeJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;
@Transactional
@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeJPARepository employeeRepo;

	@Override
	public Employee findOne(Long id) {
		return employeeRepo.findOne(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee save(Employee e) {
		return employeeRepo.save(e);
	}

	@Override
	public Page<Employee> findActiveEmployees(PageRequest pageRequest, String searchTerm) {
		return employeeRepo.findActiveEmployees(pageRequest, searchTerm);
	}

	@Override
	public List<Employee> findActiveEmployees() {
		return employeeRepo.findActiveEmployees();
	}
	
}
