package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

//	Add the constructor
	public ProductPage(WebDriver driver) {
		super(driver);
	}

//	add the webelements or locators

	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addcartbtm;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;
	
	public void clickAddToCart() {
		addcartbtm.click();
	}
	
	public boolean isSuccessMessageDisplayed() {
		try{
			return successmsg.isDisplayed();
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public String  getsuccessmsg() {
		return successmsg.getText();
	}

}
