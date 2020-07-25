package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LoginPage {
	
	WebDriver driver;
	
	public OrangeHRM_LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	
	}
	@FindBy(id="txtUsername")
	WebElement txt_userName;
	
	@FindBy(id="txtPassword")
	WebElement txt_password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	
	public void enterUsername(String userName) {
		txt_userName.sendKeys(userName);
	}
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	public void clickLogin() {
		btn_login.click();
	}
	public void login(String userName,String password) {
		txt_userName.sendKeys(userName);
		txt_userName.sendKeys(password);
		btn_login.click();
	}

}
