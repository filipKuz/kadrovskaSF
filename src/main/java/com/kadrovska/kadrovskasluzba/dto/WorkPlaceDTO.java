package com.kadrovska.kadrovskasluzba.dto;

public class WorkPlaceDTO {
	
	private Long wPiD;
	private String name;
	private Double coefficient;
	
	
	public WorkPlaceDTO() {}
	
	
	public WorkPlaceDTO(Long wPiD, String name, Double coefficient) {
		super();
		this.wPiD = wPiD;
		this.name = name;
		this.coefficient = coefficient;
	}


	public Long getwPiD() {
		return wPiD;
	}


	public void setwPiD(Long wPiD) {
		this.wPiD = wPiD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getCoefficient() {
		return coefficient;
	}


	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}


	@Override
	public String toString() {
		return "WorkPlaceDTO [wPiD=" + wPiD + ", name=" + name + ", coefficient=" + coefficient + "]";
	}
	
	

}
