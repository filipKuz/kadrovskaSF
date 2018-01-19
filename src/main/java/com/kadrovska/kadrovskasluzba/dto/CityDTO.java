package com.kadrovska.kadrovskasluzba.dto;

public class CityDTO {

	private Long cityId;
	private String cityName;
	private Integer zipCode;

	public CityDTO() {
	}

	public CityDTO(Long cityId, String cityName, Integer zipCode) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.zipCode = zipCode;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
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
}
