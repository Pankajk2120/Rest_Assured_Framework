package reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;

public class Setup implements ITestListener {
	private static ExtentReports extentReports;
	public void onStart(ITestContext context) {
		String fileName = ExtentReportManager.getReportNameWithTimeStamp();
		String fullReportPath = System.getProperty("user.dir")+ "\\reports\\" + fileName;
		extentReports = ExtentReportManager.createInstance(fileName, "Test API Automation Reports", "Test ExcecutionReport");
	}
	
	public void onFinish(ITestContext context) {
		if(extentReports != null)
			extentReports.flush();
	}
	
}
