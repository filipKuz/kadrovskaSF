package com.kadrovska.kadrovskasluzba.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.Company;
import com.kadrovska.kadrovskasluzba.repositories.CompanyJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CompanyServiceInterface;

@Transactional
@Service
public class CompanyService implements CompanyServiceInterface {

	@Autowired
	private CompanyJPARepository companyRepo;

	@Override
	public Company findOne(Long id) {
		return companyRepo.findOne(id);
	}

	@Override
	public Set<Company> findAll() {
		return new HashSet<Company>(companyRepo.findAll());
	}

	@Override
	public Company save(Company company) {
		return companyRepo.save(company);
	}

	@Override
	public void delete(Long id) {
		companyRepo.delete(id);
	}

}
