package com.kadrovska.kadrovskasluzba.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long companyId;

	@Column(nullable = false, columnDefinition="VARCHAR(30)")
	private String name;

	@Column(nullable = false)
	private Long vat;
	
	@Column(columnDefinition="VARCHAR(30)")
	private String address;

	@Column(columnDefinition="VARCHAR(30)")
	private String email;
	
	@Column (nullable=false, columnDefinition="tinyint(1) default 0")
	private Boolean isOurs;

	@Column(columnDefinition="VARCHAR(15)")
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityId", nullable=false)
	private City city;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<Employee> employees = new HashSet<>();

	public Company() {
	}

	public Long getId() {
		return companyId;
	}

	public void setId(Long id) {
		this.companyId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVat() {
		return vat;
	}

	public void setVat(Long vat) {
		this.vat = vat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Boolean getIsOurs() {
		return isOurs;
	}

	public void setIsOurs(Boolean isOurs) {
		this.isOurs = isOurs;
	}
	
	
}
