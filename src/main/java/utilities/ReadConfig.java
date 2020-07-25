package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop=null;
	
	public ReadConfig() {
		File src=new File("./configuration/Config.properties");
		try {
			FileInputStream fin=new FileInputStream(src);
			prop=new Properties();
			prop.load(fin);
		}
		catch(Exception e){
			System.out.println("Error message : "+e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url=prop.getProperty("baseUrl");
		return url;
	}
	public String getUserName() {
		String userName=prop.getProperty("userName");
		return userName;
	}
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String path=prop.getProperty("chromeDriverPath");
		return path;
	}
	public String getBrowserType() {
		String browser=prop.getProperty("browser");
		return browser;
	}
	/*
	 * public static String getTestDataFile() { String
	 * fileName=prop.getProperty("testData"); return fileName; }
	 */

}
