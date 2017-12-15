package com.kadrovska.kadrovskasluzba.dto;

public class CompanyDTO {

	private Long companyId;
	private String name;
	private Long vat;
	private String address;
	private String email;
	private String phoneNumber;
	private Long cityId;

	public CompanyDTO() {
	}

	public CompanyDTO(Long companyId, String name, Long vat, String address, String email, String phoneNumber,
			Long cityId) {
		this.companyId = companyId;
		this.name = name;
		this.vat = vat;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.cityId = cityId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
