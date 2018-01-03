package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.CityDTO;
import com.kadrovska.kadrovskasluzba.model.City;

@Component
public class CityDTOToCity implements Converter<CityDTO, City> {

	@Override
	public City convert(CityDTO cityDTO) {
		City city = new City();

		city.setID(cityDTO.getCityId());
		city.setCityName(cityDTO.getCityName());
		city.setZipCode(city.getZipCode());

		return city;
	}
}