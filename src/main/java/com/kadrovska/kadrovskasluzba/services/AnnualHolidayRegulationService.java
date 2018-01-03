package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;
import com.kadrovska.kadrovskasluzba.repositories.AnnualHolidayRegulationJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.AnnualHolidayRegulationServiceInterface;

@Transactional
@Service
public class AnnualHolidayRegulationService implements AnnualHolidayRegulationServiceInterface {

	@Autowired
	AnnualHolidayRegulationJPARepository annualHolidayRegSerJPARep;

	@Override
	public AnnualHolidayRegulation findOne(Long id) {
		return annualHolidayRegSerJPARep.findOne(id);
	}

	@Override
	public List<AnnualHolidayRegulation> findAll() {
		return annualHolidayRegSerJPARep.findAll();
	}

	@Override
	public AnnualHolidayRegulation save(AnnualHolidayRegulation annualHolidayRegulation) {
		return annualHolidayRegSerJPARep.save(annualHolidayRegulation);
	}

	@Override
	public void delete(Long id) {
		annualHolidayRegSerJPARep.delete(id);
	}

	@Override
	public List<AnnualHolidayRegulation> findByBusinessYear(Integer year) {
		return annualHolidayRegSerJPARep.findByBusinessYear(year);
	}
	
	@Override
	public AnnualHolidayRegulation findByEmployeeEmployeeIdAndBusinessYear(Long id, Integer businessYear) {
		
		return annualHolidayRegSerJPARep.findByEmployeeEmployeeIdAndBusinessYear(id, businessYear);
	}

}