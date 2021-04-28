package learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import learnautomation.pages.Base;
import learnautomation.pages.LoginPage;
import learnautomation.utility.BrowserFactory;
import learnautomation.utility.Helper;

public class LoginTestCRM extends Base{
	 
	
	@Test(priority=1)
	public void loginApp() {
		logger = report.createTest("login to fb");
		System.out.println(driver.getTitle());
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting application");
		loginpage.logintofb("anjumsharaf@gmail.com", "@allahuakbar1");
		logger.pass("login successfully");
		
	}
	@Test(priority=2)
	public void loginApp1() {
		logger = report.createTest("Logout");
		logger.fail("logout failed");
		
	}
	
	
}
