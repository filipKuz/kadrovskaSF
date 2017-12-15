package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.ProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;

@Component
public class ProfessionalQualificationDTOtoProfessioanalQualification
		implements Converter<ProfessionalQualificationDTO, ProfessionalQualification> {

	@Override
	public ProfessionalQualification convert(ProfessionalQualificationDTO arg0) {

		ProfessionalQualification professionalQualification = new ProfessionalQualification();

		professionalQualification.setID(arg0.getProfessionalQualificationId());
		professionalQualification.setName(arg0.getName());
		professionalQualification.setQualificationDegree(arg0.getQualificationDegree());

		return professionalQualification;
	}
}