package com.kadrovska.kadrovskasluzba.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Long cityId;

	@Column(nullable = false, columnDefinition = "VARCHAR(30)")
	private String cityName;

	@Column(nullable = false)
	private Integer zipCode;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Set<Employee> employees = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Set<Company> companies = new HashSet<>();

	public City() {
	}

	public Long getID() {
		return cityId;
	}

	public void setID(Long iD) {
		cityId = iD;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
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
