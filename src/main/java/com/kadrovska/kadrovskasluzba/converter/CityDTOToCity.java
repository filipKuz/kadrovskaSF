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

		System.out.println("OVO JE CITYDTO OBJECT");
		System.out.println(cityDTO.getCityId() + " " + cityDTO.getCityName() + " " + cityDTO.getZipCode());
		System.out.println(" ");

		city.setID(cityDTO.getCityId());
		city.setCityName(cityDTO.getCityName());
		city.setZipCode(cityDTO.getZipCode());

		System.out.println("OVO JE CITY OBJECT");
		System.out.println(city.getID() + " " + city.getCityName() + " " + city.getZipCode());
		return city;
	}
}