package com.kadrovska.kadrovskasluzba.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;
import com.kadrovska.kadrovskasluzba.repositories.VacationRequestJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.VacationRequestServiceInterface;

@Transactional
@Service
public class VacationRequestService implements VacationRequestServiceInterface {

	@Autowired
	VacationRequestJPARepository vacationRequestJPARepository;

	@Autowired
	NonworkingDayServive nwdService;

	@Override
	public List<VacationRequest> findAll() {
		return vacationRequestJPARepository.findAll();
	}

	@Override
	public VacationRequest findOne(Long id) {
		return vacationRequestJPARepository.findOne(id);
	}

	@Override
	public VacationRequest save(VacationRequest vacationRequest) {
		return vacationRequestJPARepository.save(vacationRequest);
	}

	@Override
	public List<VacationRequest> save(List<VacationRequest> vacationRequests) {
		return vacationRequestJPARepository.save(vacationRequests);
	}

	@Override
	public void delete(Long id) {
		vacationRequestJPARepository.delete(id);
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<VacationRequest> findByAnnualHolidayRegulationAnnualHolidayRegulationId(Long id) {
		return vacationRequestJPARepository.findByAnnualHolidayRegulationAnnualHolidayRegulationId(id);
	}

	@Override
	public Date generateEndDate(Date strDate, Integer numOfDays) {
		Date endDate = new Date(0);
		endDate.setTime(strDate.getTime());

		while (nwdService.isNonworking(endDate)) {
			System.out.println("Krece na neradni pa se uvecao za jedan");
			endDate.setTime(endDate.getTime() + 1 * 86400000);
		}
		for (int i = 0; i < numOfDays; i++) {
			endDate.setTime(endDate.getTime() + 1 * 86400000);
			if (nwdService.isNonworking(endDate)) {
				System.out.println("Uvecao se za jedan jer je neradan");
				i -= 1;
			}
		}

		return endDate;
	}

}
