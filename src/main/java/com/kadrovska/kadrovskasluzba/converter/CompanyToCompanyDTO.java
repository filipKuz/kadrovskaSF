package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.CompanyDTO;
import com.kadrovska.kadrovskasluzba.model.City;
import com.kadrovska.kadrovskasluzba.model.Company;

@Component
public class CompanyToCompanyDTO implements Converter<Company, CompanyDTO> {

	@Override
	public CompanyDTO convert(Company company) {
		CompanyDTO companyDTO = new CompanyDTO();

		companyDTO.setCompanyId(company.getId());
		companyDTO.setName(company.getName());
		companyDTO.setAddress(company.getAddress());
		companyDTO.setEmail(company.getEmail());
		companyDTO.setPhoneNumber(company.getPhoneNumber());
		companyDTO.setVat(company.getVat());

		City city = company.getCity();
		if (city != null) {
			companyDTO.setCityId(city.getID());
		}

		return companyDTO;
	}
}