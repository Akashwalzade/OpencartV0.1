package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement textpwd;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement textcrmpwd;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkpolicy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmmessage;

//	Action methods

	public void setFirstname(String firstname ) {
		txtfirstname.sendKeys(firstname);

	}

	public void setLastname(String Lastname) {
		txtlastname.sendKeys(Lastname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setphone(String number) {
		txttelephone.sendKeys(number);
	}

	public void setPassword(String pwd) {
		textpwd.sendKeys(pwd);
	}

	public void setcfmPassword(String pwd) {
		textcrmpwd.sendKeys(pwd);

	}
	public void checkPrivacy() {
		chkpolicy.click();
	}

	public void clickContinue() {
		btncontinue.click();
		
//		btncontinue.submit();
		
//		Actions act = new Actions(driver);
//		act.moveToElement(btncontinue).click().perform();
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();

	}
	
	public String cnfmMessage() {
		try {
			return (confirmmessage.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
	

}
