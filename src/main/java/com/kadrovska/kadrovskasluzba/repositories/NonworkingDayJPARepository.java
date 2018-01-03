package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.NonworkingDay;

public interface NonworkingDayJPARepository extends JpaRepository<NonworkingDay, Long> {

}
