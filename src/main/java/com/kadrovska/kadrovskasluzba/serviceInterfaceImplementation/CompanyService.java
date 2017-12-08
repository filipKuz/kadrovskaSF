package com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.Company;
import com.kadrovska.kadrovskasluzba.repositories.CompanyJPARepository;
import com.kadrovska.kadrovskasluzba.services.CompanyServiceInterface;

@Transactional
@Service
public class CompanyService implements CompanyServiceInterface {

	@Autowired
	private CompanyJPARepository companyRepo;
	
	@Override
	public Company findOne(Long id) {
		return companyRepo.findOne(id);
	}

}
