package com.kadrovska.kadrovskasluzba.serviceInterfaces;


import net.sf.jasperreports.engine.JasperPrint;

public interface ReportsServiceInterface {
	
	JasperPrint GeneratePdfReport();
	
	void CompileJrxmlTemplate();

}
