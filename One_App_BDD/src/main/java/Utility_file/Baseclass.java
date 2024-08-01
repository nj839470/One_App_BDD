package Utility_file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Baseclass implements Library, Extent_report_generator, Config_data_provider, Excel_data_provider {

	public static Logger log;
	public static ExtentSparkReporter report;
	public static AppiumDriverLocalService service;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Listner lis;
	public static WebDriverWait wait;
	public static DesiredCapabilities capabilities;
	String confipath = System.getProperty("user.dir") + "/config_data/config.properties";
	String excelpath = System.getProperty("user.dir") + "/Data/data1.xlsx";
	public static AndroidDriver driver;
	String enveronment = config_getdata("env");
	String Apikey = "gb2hycp3rd35mt73jy4vc85f", username = "anil1.singh@heromotocorp.com";

	@BeforeTest
	public AndroidDriver OPEN_AND_INSTALL_APP() {
		String deviceName = config_getdata("Platform_name");
		if (deviceName.equalsIgnoreCase("emulator")) {
			try {
				UiAutomator2Options options = new UiAutomator2Options();
				options.setCapability("appium:automationName", "uiautomator2");
				options.setCapability("platformName", "Android");
				options.setCapability("appium:deviceName", "Pixel_6_API_31");
				options.setCapability("appium:udid", "emulator-5554");
				options.setCapability("appium:avdLaunchTimeout", 90000);
				options.setCapability("appium:app", System.getProperty("user.dir") + "\\apk\\app-debug.apk");
				options.setCapability("appium:ensureWebviewsHavePages", true);
				options.setCapability("appium:nativeWebScreenshot", true);
				options.setCapability("appium:newCommandTimeout", 9600);

				driver = new AndroidDriver(new URL(config_getdata("IpAddress")), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

				log = LogManager.getLogger("Hero_App");
				lis = new Listner();
			} catch (Exception e) {
				log.error("Failed to open and install app: " + e.getMessage(), e);
			}
		} else if (deviceName.equalsIgnoreCase("pcloudy")) {
			try {
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("appium:newCommandTimeout", 600);
				capabilities.setCapability("appium:launchTimeout", 90000);
				capabilities.setCapability("appium:platformVersion", "12.0.0");
				capabilities.setCapability("appium:platformName", "Android");
				capabilities.setCapability("appium:automationName", "uiautomator2");
				capabilities.setCapability("appium:appPackage", "com.customerapp.hero");
				capabilities.setCapability("appium:appActivity", "com.customerapp.hero.views.activity.HmcDashboard");
				HashMap<String, Object> pcloudyOptions = new HashMap<String, Object>();
				pcloudyOptions.put("pCloudy_Username", username);
				pcloudyOptions.put("pCloudy_ApiKey", Apikey);
				pcloudyOptions.put("pCloudy_DurationInMinutes", 120);
				pcloudyOptions.put("pCloudy_DeviceManufacturer", "SAMSUNG");
				pcloudyOptions.put("pCloudy_DeviceVersion", "13.0.0");
				if (enveronment.equalsIgnoreCase("prod")) {
					pcloudyOptions.put("pCloudy_ApplicationName", "One_App_Prod_9_2_2.apk");
				} else {
					pcloudyOptions.put("pCloudy_ApplicationName", "app-debug-uat-9_2_1.apk");
				}
				pcloudyOptions.put("pCloudy_WildNet", "false");
				pcloudyOptions.put("pCloudy_EnableVideo", "true");
				pcloudyOptions.put("pCloudy_EnablePerformanceData", "true");
				pcloudyOptions.put("pCloudy_EnableDeviceLogs", "true");
				pcloudyOptions.put("appiumVersion", "2.0.0");
				capabilities.setCapability("pcloudy:options", pcloudyOptions);
				driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);

//					https://device.pcloudy.com/appiumcloud/wd/hub   https://ind-west.pcloudy.com/appiumcloud/wd/hub
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				log = LogManager.getLogger("Hero_App");
				lis = new Listner();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (deviceName.equalsIgnoreCase("realdevice")) {
			try {
				UiAutomator2Options db = new UiAutomator2Options();
				db.setCapability("appium:automationName", "uiautomator2");
				db.setCapability("platformName", "Android");
				db.setCapability("appium:deviceName", "Redmi 10 Prime");
				db.setCapability("appium:udid", "41f7d4580507"); // 3323262910AA04DS //192.168.1.3:55555
				db.setCapability("appium:avdLaunchTimeout", 600000);
				db.setCapability("appPackage", "com.customerapp.hero");
				db.setCapability("appActivity", "com.customerapp.hero.views.activity.HmcDashboard");
				db.setCapability("appium:noReset", "false");
//			db.setCapability("appium:app", (System.getProperty("user.dir") + "\\apk\\app-debug-connected.apk"));
				driver = new AndroidDriver(new URL(config_getdata("IpAddress")), db);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				db.setCapability("appium:ensureWebviewsHavePages", true);
				db.setCapability("appium:nativeWebScreenshot", true);
				db.setCapability("appium:newCommandTimeout", 6600);
				log = LogManager.getLogger("Hero_App");
				lis = new Listner();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return driver;
	}

	@Override
	public String config_getdata(String key) {
		String value = "";
//		ResourceBundle ro = ResourceBundle.getBundle("config");
//		value=ro.getString(key);
		try {
			FileInputStream fis = new FileInputStream(confipath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (Exception e) {
			System.out.println("Problem in read data from property file" + e);
		}
		return value;
	}

	@Override
	public String excel_getdata(int sheetno, int row_No, int col_No) {
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook wf = new XSSFWorkbook(fis);
			XSSFSheet sheet = wf.getSheetAt(sheetno);
			value = sheet.getRow(row_No).getCell(col_No).getStringCellValue();

		} catch (Exception e) {
			System.out.println("Problem in read data from excel file" + e);
		}
		return value;
	}

	@Override
	public int getRowCount(int sheetno) {
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook wf = new XSSFWorkbook(fis);
			XSSFSheet sheet = wf.getSheetAt(sheetno);
			count = sheet.getLastRowNum();

		} catch (Exception e) {
			System.out.println("Problem in read data from excel file for Row_Count" + e);
		}
		return count;
	}

	@Override
	public int getColCount(int sheetno) {
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook wf = new XSSFWorkbook(fis);
			XSSFSheet sheet = wf.getSheetAt(sheetno);
			count = sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			System.out.println("Problem in read data from excel file for Row_Count" + e);
		}
		return count;
	}

	@Override
	public void excel_writedata(int sheetno, int row_No, int col_No, String value) {
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(sheetno);
			sheet.createRow(row_No).createCell(col_No).setCellValue(value);
			FileOutputStream fos = new FileOutputStream(excelpath);
			workbook.write(fos);
			workbook.close();
		} catch (Exception e) {
			System.out.println("Problem in Write data in excel file" + e);
		}

	}

	@Override
	public ExtentReports getreports() {
		String currenttime = new SimpleDateFormat("dd.MM.YYYY.HH.mm.ss").format(new Date());
		String path = System.getProperty("user.dir") + "\\Report\\Test-Report -" + currenttime + ".html";
		report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Hero_App Test Report");
		report.config().setReportName("Hero_App");
		report.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Project Name", "Hero App");
		extent.setSystemInfo("Laptop", "Dell intel core i7");
		extent.setSystemInfo("QA", "Nitesh Kumar");
		extent.setSystemInfo("Operating system", "Windows 10 pro");
		extent.setSystemInfo("BrowserName", "Android Studio");
		return extent;
	}

	@Override
	public void custom_sendkeys(WebElement element, String value, String fieldname) {
		try {
			if (element.isEnabled() || element.isDisplayed() == true) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				element.sendKeys(value);
				test.log(Status.PASS, fieldname + " send successfully =" + value);
				log.info(fieldname + " send successfully");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + " is not able to send" + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
			log.error(fieldname + " is not able to send");
		}

	}

	@Override
	public void Custom_click(WebElement element, String fieldname) {
		try {
			if (element.isDisplayed() || element.isEnabled() == true) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				test.log(Status.PASS, "Successfully click on = " + fieldname);
				log.info(fieldname + " is clickable");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + "=Unable To Click =" + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
			log.error(fieldname + " is not clickable");

		}
	}

//======================================================================================================================================================	    
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void Scroll_down_page_Action(String fieldname) {
		try {
			Dimension dim = driver.manage().window().getSize();
			int startx = (int) (dim.width / 2);
			int starty = (int) (dim.height / 2);
			int endx = (int) (dim.width / 2);
			int endy = (int) (dim.height * 0.25);
			TouchAction action = new TouchAction(driver);
			for (int i = 0; i <= 1; i++) {
				action.press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
						.moveTo(PointOption.point(endx, endy)).release().perform();

			}
			test.log(Status.PASS, "Successfully Scroll page Action ==" + fieldname);
			log.info("Successfully  Scroll page down Action " + fieldname);

		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + "Unable To Scroll page Action ==" + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
			log.error("==NOT==Unable To Scroll page down Action " + fieldname);
		}
	}

	// ======================================================================================================================================================
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void Scroll_UP_page_Action(String fieldname) {
		try {
			Dimension dim = driver.manage().window().getSize();
			int startx = (int) (dim.width / 2);
			int starty = (int) (dim.height / 2);
			int endx = (int) (dim.width * 0);
			int endy = (int) (dim.height * 0);
			TouchAction action = new TouchAction(driver);
			for (int i = 0; i <= 1; i++) {
				action.press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(endx, endy)).release().perform();
			}
			test.log(Status.PASS, "Successfully Scroll page Action ==" + fieldname);
			log.info("Successfully  Scroll page up Action " + fieldname);
		} catch (Exception e) {
			log.error("==NOT==Unable To Scroll up page Action " + fieldname);
		}
	}

//======================================================================================================================================================
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void swipe_page_direction(int startx, int starty, int endx, int endy, String fieldname) {
		try {
			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
			log.info("Successfully  Swipe page direction Action " + fieldname);
			test.log(Status.PASS, "Successfully  Swipe page direction Action = " + fieldname);
		} catch (Exception e) {
			log.error("==NOT==Unable To Swipe page direction Action " + fieldname);
			test.log(Status.FAIL, fieldname + "Unable To Swipe page direction Action " + fieldname + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
		}
	}

	// =================================================================================================================================
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void horizontal_scroll_image(WebElement end_position, WebElement Start_position, String fieldname) {
		try {
			TouchAction action = new TouchAction(driver);
			if (end_position.isDisplayed() || end_position.isEnabled() && Start_position.isDisplayed()
					|| Start_position.isEnabled() == true) {
				Point location1 = end_position.getLocation();
				Point location2 = Start_position.getLocation();
				System.out.println("location1 =" + location1 + "location2 =" + location2);
				int end_x = location1.x;
				int end_y = location1.y - 90;
				int start_x = location2.x;
				int start_y = location2.y - 90;
				System.out.println(
						"end_x =" + end_x + "end_y =" + end_y + "start_x = " + start_x + "start_y =" + start_y);
				action.press(PointOption.point(start_x, start_y))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
				log.info("Successfully  Swipe page direction Action " + fieldname);
				test.log(Status.PASS, "Successfully  Swipe page direction Action = " + fieldname);
			}
		} catch (Exception e) {
			log.error("==NOT==Unable To Swipe page direction Action " + fieldname);
			test.log(Status.FAIL, fieldname + "Unable To Swipe page direction Action " + fieldname + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
		}
	}
//=================================================================================================================================

	// ======================================================================================================================================================
	public void scrollByText(String menuText) {

		try {

			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
							+ menuText + "\").instance(0));"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void VerifyImagePresent(WebElement image, String fieldname) {
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					image);
			if (ImagePresent) {
				test.log(Status.PASS, "Image is present:  " + fieldname);
				log.info("Image is present " + fieldname);
			} else {
				test.log(Status.FAIL, fieldname + "==Image is not present ==");
				test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
				log.error("Image is not present" + fieldname);

			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + "==Image is not present ==" + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
			log.error("Image is not present" + fieldname);

		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void PageLoaded() {
		String Title = null;
		try {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Title = driver.getTitle();
			test.log(Status.PASS, "Page is loaded :  " + Title);
			log.info("Page is loaded " + Title);
		} catch (Exception e) {
			test.log(Status.FAIL, "==page is not loaded :" + e);
			log.error("page is not able to loaded " + Title);

		}
	}

	@Override
	public void VerifyElementPresent(WebElement ele, String fieldname) {
		try {
			if (ele.isDisplayed() && ele.isEnabled() == true) {
				String Text = ele.getText();
				test.log(Status.PASS, fieldname + " present:");
				log.info(fieldname + " present");
			} else {
				test.log(Status.PASS, fieldname + "  not present");
				log.info(fieldname + "  not present");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, fieldname + " not present" + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
			log.error(fieldname + "  not present");
		}

	}

	@Override
	public void msg(WebElement ele, String filedname) {
		try {
			if (ele.isDisplayed()) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(12));
				wait.until(ExpectedConditions.visibilityOf(ele));
				String mes = ele.getText();
				test.log(Status.PASS, filedname + mes);
				log.info(filedname + mes);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, filedname + " is not readable" + e);
			test.addScreenCaptureFromPath(lis.getcapcture(filedname));
			log.error(filedname + " is not readable" + e);
		}

	}

	@Override
	public void Message(String message) {
		test.log(Status.PASS, message);
		log.info(message);
	}

	public void error_message(String message) {
		test.log(Status.FAIL, message);
		log.error(" ");
		test.addScreenCaptureFromPath(lis.getcapcture(message));
	}

}
