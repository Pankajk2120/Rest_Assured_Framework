package reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import edu.emory.mathcs.backport.java.util.Arrays;

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
	
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
		String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
		stackTrace = stackTrace.replaceAll(",", "<br>");
		String formmatedTrace = "<details>\r\n"
				+ "  <summary>Click Here To Exception Logs</summary>\n"
				+ "  "+stackTrace+"\n"
				+ "</details>\r\n"
				+ "";
		ExtentReportManager.logExceptionDetails(formmatedTrace);
	}
}
