package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;

@Component
public class EpqtoEpqDTO implements Converter<EmployeeProfessionalQualification, EmployeeProfessionalQualificationDTO> {

	@Override
	public EmployeeProfessionalQualificationDTO convert(EmployeeProfessionalQualification arg0) {

		EmployeeProfessionalQualificationDTO epqDTO = new EmployeeProfessionalQualificationDTO();

		epqDTO.setDateOfGraduation(arg0.getDateOfGraduation());
		epqDTO.setEducationalInstitution(arg0.getEducationalInstitution());
		epqDTO.setProfession(arg0.getProfession());
		epqDTO.setePQId(arg0.getID());

		if (arg0.getEmployee() != null) {
			epqDTO.setEmployeeId(arg0.getEmployee().getID());
		}

		if (arg0.getProfessionalQualification() != null) {
			epqDTO.setProfessionalQId(arg0.getProfessionalQualification().getID());
		}

		return epqDTO;
	}

}
