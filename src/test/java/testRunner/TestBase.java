package testRunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DateUtils;
import utilities.ScreenshotUtils;

public class TestBase
{

	public static final String browser = "Chrome";
	static WebDriver driver;
	static String executionStartDate;
	//ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	String reportFileName;
	static String currentWorkingDirectory;
	public static ExtentTest extentTest;
	String screenshotFileNanme;
	
	static
	{
		try
		{
			currentWorkingDirectory = System.getProperty("user.dir");
			executionStartDate = DateUtils.getCurrentDateAndTime();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Parameters ("reportfilename")
	@BeforeSuite
	public void preSetup(String filename)
	{
		extent = new ExtentReports();
		reportFileName = String.format("%s\\reports\\"+filename+"-%s.html", currentWorkingDirectory, executionStartDate);
		ExtentSparkReporter spark = new ExtentSparkReporter(reportFileName);
		extent.setSystemInfo("Host name", "Kavyashree Gowda");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser ", browser);
		extent.attachReporter(spark);
		extentTest = extent.createTest("Set up the pre-requisit to run automated test case");
		extentTest.log(Status.INFO, "Browser invoked is " + browser);
	}
	@BeforeClass
	public void setup()
	{
		 
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		String testcaseName = result.getName();
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(Status.PASS, "Test case passed - " +testcaseName);
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(Status.FAIL, "Test case failed - " +testcaseName);
			String temp=ScreenshotUtils.getScreenshot(driver);
			extentTest.log(Status.FAIL, result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			//extentTest.log(Status.FAIL, (Markup) extentTest.addScreenCaptureFromPath(temp));
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, "Test case skipped - " +testcaseName);
		}
		else
		{
			extentTest.log(Status.WARNING , "Warning - " +testcaseName);
		}
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void postCleanup()
	{
		extent.flush();
	}


}
