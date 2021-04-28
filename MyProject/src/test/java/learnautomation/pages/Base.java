package learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import learnautomation.utility.BrowserFactory;
import learnautomation.utility.ConfigDataProvider;
import learnautomation.utility.Helper;

public class Base {
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupsuite() {
		config= new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/fb.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		
	}
	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startapplication(driver, config.getBrowser(), config.getStagingURL());
		
	}
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void teardown2(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			try {
				logger.fail("Test failed"+MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			try {
				logger.fail("Test failed"+MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(result.getStatus()==ITestResult.SKIP) {
			try {
				logger.fail("Test Skipped"+MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
	}



}
