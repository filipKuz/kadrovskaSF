package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.Company;

public interface CompanyServiceInterface {

	Company findOne(Long id);

	List<Company> findAll();

	Company save(Company city);

	void delete(Long id);
}