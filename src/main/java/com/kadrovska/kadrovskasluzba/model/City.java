package com.kadrovska.kadrovskasluzba.model;

import java.util.Set;

import javax.persistence.OneToMany;

public class City {

	private Long id;
	private Integer zipCode;
	private String cityName;
	
	@OneToMany
	private Set<Employee> employees;
	
	@OneToMany
	private Set<Company> companies;
	
	public City() {}
	
	public Long getID() {
		return id;
	}
	public void setID(Long iD) {
		id = iD;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
	
	
	
}
