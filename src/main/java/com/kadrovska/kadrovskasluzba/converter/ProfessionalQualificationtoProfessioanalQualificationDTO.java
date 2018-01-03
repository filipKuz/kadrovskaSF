package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.ProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;

@Component
public class ProfessionalQualificationtoProfessioanalQualificationDTO
		implements Converter<ProfessionalQualification, ProfessionalQualificationDTO> {

	@Override
	public ProfessionalQualificationDTO convert(ProfessionalQualification professionalQualification) {

		ProfessionalQualificationDTO pqDTO = new ProfessionalQualificationDTO();

		pqDTO.setProfessionalQualificationId(professionalQualification.getID());
		pqDTO.setName(professionalQualification.getName());
		pqDTO.setQualificationDegree(professionalQualification.getQualificationDegree());
		pqDTO.setIsActive(professionalQualification.getActive());

		return pqDTO;
	}

	public List<ProfessionalQualificationDTO> convert(List<ProfessionalQualification> pqs) {

		List<ProfessionalQualificationDTO> retVal = new ArrayList<>();

		for (ProfessionalQualification pq : pqs) {
			retVal.add(convert(pq));
		}

		return retVal;
	}
}