package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	private String lastName;
	private String firstName;
	private String parentName;
	private String madenName;
	private Date birthDate;
	private Sex sex;
	private String address;
	private Integer numberOfVacationDaysLeft;
	
	@ManyToOne
	private Company company;
	
	@OneToMany
	private Set<EmployeeChild> children;
	
	@OneToMany
	private Set<EmployeeProfessionalQualification> professionalQualifications;
	
	@OneToMany
	private Set<VacationRequest> vacationRequests;
	
	@OneToMany
	private Set<WorkHistory> workingHistory; 
	
	@ManyToOne
	private City city;
	
	public Employee() {}

	public long getID() {
		return id;
	}

	public void setID(long iD) {
		id = iD;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMadenName() {
		return madenName;
	}

	public void setMadenName(String madenName) {
		this.madenName = madenName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumberOfVacationDaysLeft() {
		return numberOfVacationDaysLeft;
	}

	public void setNumberOfVacationDaysLeft(Integer numberOfVacationDaysLeft) {
		this.numberOfVacationDaysLeft = numberOfVacationDaysLeft;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<EmployeeChild> getChildren() {
		return children;
	}

	public void setChildren(Set<EmployeeChild> children) {
		this.children = children;
	}

	public Set<EmployeeProfessionalQualification> getProfessionalQualifications() {
		return professionalQualifications;
	}

	public void setProfessionalQualifications(Set<EmployeeProfessionalQualification> professionalQualifications) {
		this.professionalQualifications = professionalQualifications;
	}

	public Set<VacationRequest> getVacationRequests() {
		return vacationRequests;
	}

	public void setVacationRequests(Set<VacationRequest> vacationRequests) {
		this.vacationRequests = vacationRequests;
	}

	public Set<WorkHistory> getWorkingHistory() {
		return workingHistory;
	}

	public void setWorkingHistory(Set<WorkHistory> workingHistory) {
		this.workingHistory = workingHistory;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
