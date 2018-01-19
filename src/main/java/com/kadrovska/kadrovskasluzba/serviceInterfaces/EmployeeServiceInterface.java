package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kadrovska.kadrovskasluzba.model.Employee;

public interface EmployeeServiceInterface {

	Employee findOne(Long id);

	List<Employee> findAll();

	Employee save(Employee e);

	List<Employee> findByCityId(long cityId);

	Page<Employee> findActiveEmployees(PageRequest pageRequest, String searchTerm);

	Page<Employee> findAllEmployees(PageRequest pageRequest, String searchTerm);

	List<Employee> findActiveEmployees();
}
