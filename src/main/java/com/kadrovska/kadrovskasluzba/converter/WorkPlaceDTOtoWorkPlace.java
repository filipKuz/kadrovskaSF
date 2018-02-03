package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;
import com.kadrovska.kadrovskasluzba.dto.WorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;

@Component
public class WorkPlaceDTOtoWorkPlace implements Converter<WorkPlaceDTO, WorkPlace> {

	@Override
	public WorkPlace convert(WorkPlaceDTO workPlaceDTO) {

		WorkPlace workPlace = new WorkPlace();

		workPlace.setWorkPlaceId(workPlaceDTO.getWorkPlaceId());
		workPlace.setName(workPlaceDTO.getName());
		workPlace.setCoefficient(workPlaceDTO.getCoefficient());
		workPlace.setExtraVacationDays(workPlaceDTO.getExtraVacationDays());

		return workPlace;
	}
}