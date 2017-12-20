package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.core.convert.converter.Converter;

import com.kadrovska.kadrovskasluzba.dto.CityDTO;
import com.kadrovska.kadrovskasluzba.model.City;

public class CityToCityDTO implements Converter<City, CityDTO> {

	@Override
	public CityDTO convert(City city) {
		CityDTO cityDTO = new CityDTO();

		cityDTO.setCityId(city.getID());
		cityDTO.setCityName(city.getCityName());
		cityDTO.setZipCode(city.getZipCode());

		return cityDTO;
	}
}