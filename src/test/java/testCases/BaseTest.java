package testCases;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;

import utilities.ReadConfig;

public class BaseTest {
	
	WebDriver driver;
	public static Logger logger=null;
	ReadConfig readConfig=new ReadConfig();
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browserValue) {
		
		logger=Logger.getLogger(getClass());
		PropertyConfigurator.configure("Log4j.properties");
		if(browserValue.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(readConfig.getApplicationURL());
	}
	/*
	 * public void launchOrangeHRMLoginPage() {
	 * driver.get("https://opensource-demo.orangehrmlive.com/"); }
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	public void takeScreenshot(WebDriver driver,String tcName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile= ts.getScreenshotAs(OutputType.FILE);
		String screenshotFolder=System.getProperty("user.dir")+"/screenShots";
		File srcFolder= new File(screenshotFolder);
		if(!srcFolder.exists()) {
			srcFolder.mkdir();
		}
		File targetFile=new File(srcFolder+"/tcName"+".png");
		//FileUtil.class
		
	}

}
