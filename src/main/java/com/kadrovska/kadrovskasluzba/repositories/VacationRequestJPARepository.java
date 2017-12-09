package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;

public interface VacationRequestJPARepository extends JpaRepository<VacationRequest, Long> {

}
