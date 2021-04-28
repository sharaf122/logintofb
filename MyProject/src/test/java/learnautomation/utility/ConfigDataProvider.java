package learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider() {
		try {
		File src= new File("./Config/config.properties");
		FileInputStream fis = new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
		}catch(Exception e){
			System.out.println("not able load config file"+e.getMessage());
		}
		
		
		
	}
	public String getdatafromconfig(String KeyToSearch) {
		return pro.getProperty(KeyToSearch);
	}
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getStagingURL() {
		return pro.getProperty("qaURL");
	}
	
	
}
