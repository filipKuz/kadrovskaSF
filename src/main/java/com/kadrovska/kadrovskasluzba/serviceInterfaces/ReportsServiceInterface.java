package com.kadrovska.kadrovskasluzba.serviceInterfaces;


import net.sf.jasperreports.engine.JasperPrint;

public interface ReportsServiceInterface {
	
	JasperPrint GeneratePdfReport(String par);
	
	void CompileJrxmlTemplate(String par);

}
