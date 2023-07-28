package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReportNg {
	public static ExtentReports extents;
public static ExtentReports GetReportObject() {
	String path=System.getProperty("user.dir")+"\\Reprot\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("WebAutomation result");
	reporter.config().setReportName("test report");
	
	 extents = new ExtentReports();
	 extents.attachReporter(reporter);
	 extents.setSystemInfo("analyst", "pratik meher");
	 return extents;
}

}
