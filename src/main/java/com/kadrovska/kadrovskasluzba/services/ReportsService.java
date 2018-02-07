package com.kadrovska.kadrovskasluzba.services;

import com.kadrovska.kadrovskasluzba.serviceInterfaces.ReportsServiceInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
@Transactional
public class ReportsService implements ReportsServiceInterface {

	@Autowired
	private Environment env;

	@Override
	public JasperPrint GeneratePdfReport(String par) {
		CompileJrxmlTemplate(par);
		String sourceFileName="";
		
		if (par.equals("1")){
			sourceFileName = "src/main/resources/reports/Blank_A4.jasper";
		}else if(par.equals("2")){
			sourceFileName = "src/main/resources/reports/children.jasper";
		}
		
		
		JasperPrint printFileName = null;

		String dbUrl = env.getProperty("spring.datasource.url");
		String dbDriver = env.getProperty("spring.datasource.driver-class-name");
		String dbUname = env.getProperty("spring.datasource.username");
		String dbPwd = env.getProperty("spring.datasource.password");

		
		try {
			
			// Load the JDBC driver
			Class.forName(dbDriver);
			// Get the connection
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);

			printFileName = JasperFillManager.fillReport(sourceFileName, null, conn);
			if (printFileName != null) {
				/**
				 * 1- export to PDF
				 */
				JasperExportManager.exportReportToPdfFile(printFileName, "src/main/resources/pdfReports/report.pdf");
				
			}
			return printFileName;
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.print("Exceptiion" + e);
		}
		return null;

	}

	@Override
	public void CompileJrxmlTemplate(String par) {
		String sourceFileName="";
		
		if (par.equals("1")){
			sourceFileName = "src/main/resources/reports/Blank_A4.jrxml";
		}else if(par.equals("2")){
			sourceFileName = "src/main/resources/reports/children.jrxml";
		}
		
		try {
			/**
			 * Compile the report to a file name same as the JRXML file name
			 */
			JasperCompileManager.compileReportToFile(sourceFileName);
		} catch (JRException e) {
			e.printStackTrace();
		}
		System.out.println("Done compiling!!! ...");
	}
}
