package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kadrovska.kadrovskasluzba.model.EmployeeChild;
import com.kadrovska.kadrovskasluzba.repositories.EmployeeChildJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeChildServiceInterface;

public class EmployeeChildService implements EmployeeChildServiceInterface {

	@Autowired
	EmployeeChildJPARepository employeeChildJPARepository;
	
	@Override
	public List<EmployeeChild> findAll() {
		return employeeChildJPARepository.findAll();
	}

	@Override
	public EmployeeChild findOne(Long id) {
		return employeeChildJPARepository.findOne(id);
	}

	@Override
	public EmployeeChild save(EmployeeChild child) {
		return employeeChildJPARepository.save(child);
	}

	@Override
	public List<EmployeeChild> save(List<EmployeeChild> children) {
		return employeeChildJPARepository.save(children);
	}

	@Override
	public void delete(Long id) {
		employeeChildJPARepository.delete(id);
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}
	
	
}
