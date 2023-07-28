package ExtentReport;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	ExtentReports extents;
	@BeforeMethod
	public void report() {
		String path=System.getProperty("user.dir")+"\\Reprot\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("WebAutomation result");
		reporter.config().setReportName("test report");
		
		 extents = new ExtentReports();
		 extents.attachReporter(reporter);
		 extents.setSystemInfo("analyst", "pratik meher");
	}
	
	@Test
	public void Test1() {
		extents.createTest("initial demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pmeher\\eclipse-workspace\\ExtentReport\\src\\test\\java\\Resources\\chromedriver.exe");
		System.out.println("hello world");
		extents.flush();
	}

}
