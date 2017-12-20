package com.kadrovska.kadrovskasluzba.dto;

public class CityDTO {

	private Long cityId;
	private Integer zipCode;
	private String cityName;

	public CityDTO() {
	}

	public CityDTO(Long cityId, Integer zipCode, String cityName) {
		this.cityId = cityId;
		this.zipCode = zipCode;
		this.cityName = cityName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
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
}
