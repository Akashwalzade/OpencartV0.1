package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

//	locators

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpwd;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	
	
	public void addemail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void addpassword(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	
	public void clicklogin() {
		btnLogin.click();
	}
	
	

}
