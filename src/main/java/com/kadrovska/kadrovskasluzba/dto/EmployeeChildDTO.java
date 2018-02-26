package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeChildDTO {

	private Long employeeChildId;

	@NotBlank(message = "Child name cannot be empty")
	@Length(max = 30, message = "Child name cannot contain more than 30 characters")
	private String name;

	@NotBlank(message = "Child last name cannot be empty")
	@Length(max = 30, message = "Child last name cannot contain more than 30 characters")
	private String lastName;

	@NotNull(message = "Birth date cannot be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@NotBlank(message = "Child sex cannot be empty")
	@Length(max = 30, message = "Child sex cannot contain more than 6 characters")
	private String sex;

	@NotNull(message="ParentId cannot be null")
	@Min(value=0, message="ParentId must be >= than 0")
	private Long parentId;

	public EmployeeChildDTO() {
	}

	public EmployeeChildDTO(String name, String lastName, Date birthDate, String sex, Long parentId) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.sex = sex;
		this.parentId = parentId;
	}

	public Long getEmployeeChildId() {
		return employeeChildId;
	}

	public void setEmployeeChildId(Long employeeChildId) {
		this.employeeChildId = employeeChildId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "EmployeeChildDTO [employeeChildId=" + employeeChildId + ", name=" + name + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", sex=" + sex + ", parentId=" + parentId + "]";
	}
}