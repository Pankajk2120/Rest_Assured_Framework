package reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Setup implements ITestListener {
	private static ExtentReports extentReports;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	
	public void onStart(ITestContext context) {
		String fileName = ExtentReportManager.getReportNameWithTimeStamp();
		String fullReportPath = System.getProperty("user.dir")+ "\\reports\\" + fileName;
		extentReports = ExtentReportManager.createInstance(fileName, "Test API Automation Reports", "Test ExcecutionReport");
	}
	
	public void onFinish(ITestContext context) {
		if(extentReports != null)
			extentReports.flush();
	}
	
	public void onTestStart(ITestResult result) {
		ExtentTest test = extentReports.createTest("Test Name" + result.getTestClass().getName()+ " - "+result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public static void logPassDetails(String log) {
		Setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
	}
	
	public static void logFailureDetails(String log) {
		Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
	}
	
	public static void logInfoDetails(String log) {
		Setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
	}
	
	public static void logWarningDetails(String log) {
		Setup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
	}
}
