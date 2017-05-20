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
		String sourceFileName = null;
		try {
			
			sourceFileName = this.getClass().getClassLoader().getResource("reportes/" + reportName).getPath();
			System.out.println(sourceFileName);
		} catch (Exception e) {
			// TODO: handle exception
		}

		String printFileName = null;
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);

		try {
			printFileName = JasperFillManager.fillReportToFile(sourceFileName, parameters, beanColDataSource);
			if (printFileName != null) {
				/**
				 * 1- export to PDF
				 */
				JasperExportManager.exportReportToPdfFile(printFileName, folderPath + "/ReporteMedico.pdf");

				/**
				 * 2- export to HTML
				 */
				// JasperExportManager.exportReportToHtmlFile(printFileName,
				// folderPath+"/reportePaciente2.html");

			}
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

}