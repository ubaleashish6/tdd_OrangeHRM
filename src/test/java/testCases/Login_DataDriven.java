package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.OrangeHRM_LoginPage;
import utilities.ReadConfig;
import utilities.XLSUtils;

public class Login_DataDriven extends BaseTest {
	ReadConfig objConfig=new ReadConfig();
	//static String testDataFile=objConfig.getTestDataFile();
	
	@BeforeMethod
	public void init() {
		setup();
	}
	@AfterMethod
	public void closeSession() {
		tearDown();
	}
	
	@Test(dataProvider="LoginData")
	public void loginWithDifferentSetOfData(String userName, String password) {
		OrangeHRM_LoginPage loginPage=new OrangeHRM_LoginPage(driver);
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		try {
			if(driver.findElement(By.linkText("Welcome Admin")).isDisplayed()) {
				Assert.assertTrue(true);
				driver.findElement(By.linkText("Welcome Admin")).click();
			}
		}
		catch(Exception e) {
			
				takeScreenshot(driver, "Login_DataDriven");
				Assert.assertTrue(false);
			
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String fileName = System.getProperty("user.dir")+"/src/main/java/testData/TestData.xlsx";
		String sheetName="LoginData";
		int totalRows=XLSUtils.getRowCount(fileName, sheetName);
		int totalColCount=XLSUtils.getCellCount(fileName, sheetName, 1);
		
		String[][] testData=new String[totalRows][totalColCount];
		for(int rowNum=1;rowNum<=totalRows;rowNum++) {
			for(int cellNum=0;cellNum<totalColCount;cellNum++) {
				System.out.println(XLSUtils.getCellData(fileName, sheetName, rowNum, cellNum));
				testData[rowNum-1][cellNum]=XLSUtils.getCellData(fileName, sheetName, rowNum, cellNum);
			}
		}
		
		return testData;
	}

}
