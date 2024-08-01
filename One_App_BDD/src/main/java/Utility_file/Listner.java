package Utility_file;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listner extends Baseclass implements ITestListener {

	ExtentReports extent = getreports();
	ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName() + " = " + result.getMethod().getMethodName());

		extent_test.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case Pass");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case Fail");
		test.addScreenCaptureFromPath(getcapcture(result.getName()));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Case Skip");
		test.addScreenCaptureFromPath(getcapcture(result.getName()));
	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

	public String getcapcture(String screenshot_name) {
		String destination = System.getProperty("user.dir") + "/failed_Tests_ScreenShots/" + screenshot_name + ".png"
				+ date_and_Time("dd-MM-yyyy_hh mm ss");
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File finaldestination = new File(destination);
			FileUtils.copyFile(source, finaldestination);

		} catch (Exception e) {
			System.out.println(e);
		}
		return destination;
	}

	public String date_and_Time(String formate) {
		String value = "";
		try {
			Date db = new Date();
			DateFormat df = new SimpleDateFormat(formate);
			value = df.format(db);
		} catch (Exception e) {
			System.out.println("Problem in data and time" + e);
		}
		return value;
	}

}
