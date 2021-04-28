package learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	//Screenshots,Alerts,Frames,Windows,Sync issue,JavascriptExecutor
	public static  String captureScreenshot(WebDriver driver) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots"+Helper.getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("screenshots captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to capture screenshots"+e.getMessage());
		}
		return screenshotPath;
	}
	public static String getCurrentDateTime() {
		DateFormat format= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate=new Date();
		return format.format(currentdate);
	}

}
