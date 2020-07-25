package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.OrangeHRM_LoginPage;
import utilities.ReadConfig;

public class Login_Test extends BaseTest {
	
	OrangeHRM_LoginPage page_login;
	ReadConfig readConfig=new ReadConfig();

	/*
	 * @BeforeTest public void openBrowser() {
	 * 
	 * setup(readConfig.getBrowserType()); }
	 */
	@Test
	public void login() {
		page_login=new OrangeHRM_LoginPage(driver);
		logger.info("Entering username......");
		page_login.enterUsername(readConfig.getUserName());
		logger.info("Entering password.....");
		page_login.enterPassword(readConfig.getPassword());
		logger.info("Hitting login button....");
		page_login.clickLogin();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		logger.info("I am on homepage..........");
		System.out.println("Login successful.........");
	}

}

