package eam.desarrollo.hospital.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportExporter {

	public void export(String reportName, String folderPath, Map<String, Object> parameters, ArrayList<?> list)
			throws JRException {
		
		//String sourceFileName = this.getClass().getClassLoader().getResource(e).getPath();
		String sourceFileName = "C:/Users/Casa1/Documents/GitHub/Hospitalproyecto/reportes/ReporteMedicos2.jasper";
		System.out.println(sourceFileName);
		String printFileName = null;
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);

		try {
			printFileName = JasperFillManager.fillReportToFile(sourceFileName, parameters, beanColDataSource);
			if (printFileName != null) {
				/**
				 * 1- export to PDF
				 */
				JasperExportManager.exportReportToPdfFile(printFileName, folderPath + "/ReporteMedico2.pdf");

				/**
				 * 2- export to HTML
				 */
				JasperExportManager.exportReportToHtmlFile(printFileName,folderPath+"/reportePaciente2.html");

			}
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}

}