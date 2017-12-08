package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Long> {

}
