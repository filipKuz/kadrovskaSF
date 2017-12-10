package com.kadrovska.kadrovskasluzba.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.convert.converter.Converter;
import com.kadrovska.kadrovskasluzba.dto.WorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation.WorkPlaceService;

@Component
public class WorkPlaceDTOtoWorkPlace implements Converter<WorkPlaceDTO, WorkPlace> {
	
	@Autowired
	WorkPlaceService wpS;
	

	@Override
	public WorkPlace convert(WorkPlaceDTO wpDTO) {
		
		WorkPlace wp = new WorkPlace();
		
		wp.setWorkplaceId(wpDTO.getwPiD());
		wp.setName(wpDTO.getName());
		wp.setCoefficient(wpDTO.getCoefficient());
		
		return wp;
	}


	
}
