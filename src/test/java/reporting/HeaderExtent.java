package reporting;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class HeaderExtent {

	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;

	public ExtentReports generateReport() {

		String reportDir = System.getProperty("user.dir") + "/Reports/ExtentReport/";
		String reportPath = reportDir + "Report.html";
		new File(reportDir).mkdir();
		reporter=new ExtentHtmlReporter(reportPath);
		reporter.config().setDocumentTitle("");
		reporter.config().setReportName("Amity Online");
		reporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm");
		reporter.config().setTheme(Theme.STANDARD);

		reports=new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("Tester Name", "Jatin & Nitish");
		reports.setSystemInfo("Website URL", "https://amityonline.com");
		return reports;

	}




}
