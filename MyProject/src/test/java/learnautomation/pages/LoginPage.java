package learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy (name="email") WebElement username;
	@FindBy (name="pass") WebElement password;
	@FindBy (name="login") WebElement loginbtn;
	
	public void logintofb(String username1, String password1) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username.sendKeys(username1);
		password.sendKeys(password1);
		loginbtn.click();
	}
	
}
