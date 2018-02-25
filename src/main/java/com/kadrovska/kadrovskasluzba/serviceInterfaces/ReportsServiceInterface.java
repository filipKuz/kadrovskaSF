package com.kadrovska.kadrovskasluzba.serviceInterfaces;


import net.sf.jasperreports.engine.JasperPrint;

public interface ReportsServiceInterface {
	
	JasperPrint GeneratePdfReport(String par, int BY);
	
	void CompileJrxmlTemplate(String par, int BY);

}
