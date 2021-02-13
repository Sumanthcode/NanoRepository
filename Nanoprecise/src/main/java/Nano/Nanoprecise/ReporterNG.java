package Nano.Nanoprecise;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReporterNG {

	static ExtentReports extents;
	 public static ExtentReports getReport()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web testing");
		 extents=new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("tester","Sumanth");
		return extents;
	}
}
