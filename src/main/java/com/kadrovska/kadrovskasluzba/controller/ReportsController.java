package com.kadrovska.kadrovskasluzba.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.serviceInterfaces.ReportsServiceInterface;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@Controller
@RequestMapping("/api/reports")
public class ReportsController {

	@Autowired
	private ReportsServiceInterface reportsServiceInterface;

	@GetMapping("AHR")
	public ResponseEntity<?> getReportAHR() {

		
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(reportsServiceInterface.GeneratePdfReport()));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=report.pdf");

			return ResponseEntity
		       		.ok()
		       		.headers(headers)
		       		.contentType(MediaType.APPLICATION_PDF)
		       		.body(new InputStreamResource(bis));
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("children")
	public ResponseEntity<?> getReportChildren() {

		
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(reportsServiceInterface.GeneratePdfReport()));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=report.pdf");

			return ResponseEntity
		       		.ok()
		       		.headers(headers)
		       		.contentType(MediaType.APPLICATION_PDF)
		       		.body(new InputStreamResource(bis));
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
