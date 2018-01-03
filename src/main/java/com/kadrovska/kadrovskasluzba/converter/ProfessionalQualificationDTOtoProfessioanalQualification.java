package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.ProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;

@Component
public class ProfessionalQualificationDTOtoProfessioanalQualification
		implements Converter<ProfessionalQualificationDTO, ProfessionalQualification> {

	@Override
	public ProfessionalQualification convert(ProfessionalQualificationDTO professionalQualificationDTO) {

		ProfessionalQualification professionalQualification = new ProfessionalQualification();

		professionalQualification.setID(professionalQualificationDTO.getProfessionalQualificationId());
		professionalQualification.setName(professionalQualificationDTO.getName());
		professionalQualification.setQualificationDegree(professionalQualificationDTO.getQualificationDegree());
		professionalQualification.setActive(professionalQualificationDTO.getIsActive());

		return professionalQualification;
	}
}