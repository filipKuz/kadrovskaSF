package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.EmployeeChild;

public interface EmployeeChildServiceInterface {

	List<EmployeeChild> findAll();

	EmployeeChild findOne(Long id);

	EmployeeChild save(EmployeeChild child);

	List<EmployeeChild> save(List<EmployeeChild> children);

	void delete(Long id);

	void delete(List<Long> ids);
}
