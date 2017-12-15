package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;

@Component
public class EpqtoEpqDTO implements Converter<EmployeeProfessionalQualification, EmployeeProfessionalQualificationDTO> {

	@Override
	public EmployeeProfessionalQualificationDTO convert(EmployeeProfessionalQualification epq) {

		EmployeeProfessionalQualificationDTO epqDTO = new EmployeeProfessionalQualificationDTO();

		epqDTO.setDateOfGraduation(epq.getDateOfGraduation());
		epqDTO.setEducationalInstitution(epq.getEducationalInstitution());
		epqDTO.setProfession(epq.getProfession());
		epqDTO.setePQId(epq.getID());

		if (epq.getEmployee() != null) {
			epqDTO.setEmployeeId(epq.getEmployee().getID());
		}

		if (epq.getProfessionalQualification() != null) {
			epqDTO.setProfessionalQId(epq.getProfessionalQualification().getID());
		}

		return epqDTO;
	}
}