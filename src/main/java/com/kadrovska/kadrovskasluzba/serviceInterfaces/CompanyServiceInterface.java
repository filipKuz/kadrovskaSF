package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.Set;

import com.kadrovska.kadrovskasluzba.model.Company;

public interface CompanyServiceInterface {

	Company findOne(Long id);

	Set<Company> findAll();

	Company save(Company city);

	void delete(Long id);
}