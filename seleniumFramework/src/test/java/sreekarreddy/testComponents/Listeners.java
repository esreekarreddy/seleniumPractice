package sreekarreddy.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import srekarreddy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;
	ExtentReports extentReports = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		//entry for test report start
		test = extentReports.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		//screenshot & save it to report
		
		threadLocal.get().log(Status.FAIL, "Test failed");
		threadLocal.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		String filePath = null;
		try {
			filePath = takeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		threadLocal.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	
	
}
