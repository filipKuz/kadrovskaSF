package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.EmployeeChild;

public interface EmployeeChildServiceInterface {

	EmployeeChild findAll();

	EmployeeChild findOne(Long id);

	EmployeeChild save(EmployeeChild child);

	List<EmployeeChild> save(List<EmployeeChild> children);

	EmployeeChild delete(Long id);

	void delete(List<Long> ids);
}
