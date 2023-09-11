package srekarreddy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		String file = System.getProperty("user.dir") +"/reports/index.html";
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(file);
		extentSparkReporter.config().setReportName("Web Automation Results");
		extentSparkReporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Sreekar Reddy");
		
		return extentReports;
	}
}
