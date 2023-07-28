package Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.AppiumUtils;
import Utils.TestReportNg;
import io.appium.java_client.AppiumDriver;

public class Listeners  implements ITestListener{
	public AppiumDriver driver;
	AppiumUtils appiumutils = new AppiumUtils(driver);

	

	ExtentTest test;
	ExtentReports extents=TestReportNg.GetReportObject();
	@Override
	public void onTestStart(ITestResult result) {
		 test=extents.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver=(AppiumDriver)result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		try {
			test.addScreenCaptureFromPath(appiumutils.GetScreenshot( result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extents.flush();
	}

}
