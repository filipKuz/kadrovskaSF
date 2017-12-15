package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;
import com.kadrovska.kadrovskasluzba.dto.WorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;

@Component
public class WorkPlaceDTOtoWorkPlace implements Converter<WorkPlaceDTO, WorkPlace> {

	@Override
	public WorkPlace convert(WorkPlaceDTO wpDTO) {

		WorkPlace wp = new WorkPlace();

		wp.setWorkPlaceId(wpDTO.getWorkPlaceId());
		wp.setName(wpDTO.getName());
		wp.setCoefficient(wpDTO.getCoefficient());

		return wp;
	}
}