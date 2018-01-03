package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadrovska.kadrovskasluzba.model.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Long> {
	
	@Query("select e from Employee e, WorkHistory wh" 
			+ " where e.employeeId = wh.employee and wh.endDate is NULL"
			+ " and (LOWER(e.firstName) like (CONCAT( '%', LOWER(:searchTerm), '%'))"
			+ " or LOWER(e.lastName) like (CONCAT( '%', LOWER(:searchTerm), '%'))"
			+ " or LOWER(e.birthDate) like (CONCAT( '%', LOWER(:searchTerm), '%')))")
	Page<Employee> findActiveEmployees(Pageable pageable, @Param("searchTerm") String searchTerm);
	
}
