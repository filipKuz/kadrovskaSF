package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;
import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.ProfessionalQualificationServiceInterface;

@Component
public class EpqDTOtoEpq implements Converter<EmployeeProfessionalQualificationDTO, EmployeeProfessionalQualification> {

	@Autowired
	ProfessionalQualificationServiceInterface professionalQualificationService;

	@Autowired
	EmployeeServiceInterface employeeService;

	@Override
	public EmployeeProfessionalQualification convert(EmployeeProfessionalQualificationDTO arg0) {

		EmployeeProfessionalQualification epq = new EmployeeProfessionalQualification();

		epq.setID(arg0.getePQId());
		epq.setDateOfGraduation(arg0.getDateOfGraduation());
		epq.setEducationalInstitution(arg0.getEducationalInstitution());
		epq.setProfession(arg0.getProfession());

		ProfessionalQualification pq = professionalQualificationService.findOne(arg0.getProfessionalQId());
		if (pq != null) {
			epq.setProfessionalQualification(pq);
		}

		Employee e = employeeService.findOne(arg0.getEmployeeId());
		if (e != null) {
			epq.setEmployee(e);
		}
		return epq;
	}
}
