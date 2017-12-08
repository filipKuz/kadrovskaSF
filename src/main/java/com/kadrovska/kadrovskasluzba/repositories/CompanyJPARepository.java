package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.Company;

public interface CompanyJPARepository extends JpaRepository<Company, Long> {

}
