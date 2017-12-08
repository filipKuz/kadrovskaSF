package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.ProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;

@Component
public class ProfessionalQualificationtoProfessioanalQualificationDTO implements Converter<ProfessionalQualification, ProfessionalQualificationDTO>{

	@Override
	public ProfessionalQualificationDTO convert(ProfessionalQualification pq) {
		
		ProfessionalQualificationDTO pqDTO = new ProfessionalQualificationDTO();
		
		pqDTO.setpQId(pq.getID());
		pqDTO.setName(pq.getName());
		pqDTO.setQualificationDegree(pq.getQualificationDegree());
		
		return pqDTO;
	}

	public List<ProfessionalQualificationDTO> convert(List<ProfessionalQualification> pqs) {
		
		List<ProfessionalQualificationDTO> retVal = new ArrayList<>();
		
		for(ProfessionalQualification pq: pqs) {
			retVal.add(convert(pq));
		}
		
		return retVal;
		
	}
	
}
