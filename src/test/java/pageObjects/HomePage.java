package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//	Create the consturctor
	public HomePage(WebDriver driver) {
		super(driver);
	}

//	Create Webelemts

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnklogin;

//Add Action Method
	public void ClickMyAccount() {
		lnkMyAccount.click();
	}

	public void ClickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnklogin.click();
	}

}
