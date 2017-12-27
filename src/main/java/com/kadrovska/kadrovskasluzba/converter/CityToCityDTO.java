package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

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

	public List<CityDTO> convert(List<City> cities) {
		List<CityDTO> retValue = new ArrayList<>();

		for (City city : cities) {
			retValue.add(convert(city));
		}

		return retValue;
	}
}