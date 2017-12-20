package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.CompanyDTO;
import com.kadrovska.kadrovskasluzba.model.City;
import com.kadrovska.kadrovskasluzba.model.Company;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CityServiceInterface;

@Component
public class CompanyDTOToCompany implements Converter<CompanyDTO, Company> {

	@Autowired
	CityServiceInterface cityService;

	@Override
	public Company convert(CompanyDTO companyDTO) {
		Company company = new Company();

		company.setId(companyDTO.getCompanyId());
		company.setName(companyDTO.getName());
		company.setAddress(companyDTO.getAddress());
		company.setEmail(companyDTO.getEmail());
		company.setPhoneNumber(companyDTO.getPhoneNumber());
		company.setVat(companyDTO.getVat());

		City city = cityService.findOne(companyDTO.getCityId());
		if (city != null) {
			company.setCity(city);
		}

		return company;
	}
}