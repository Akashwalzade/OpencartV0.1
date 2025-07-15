package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    // Add meaningful locators instead of "xpathvalue"
    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    WebElement searchButton;

    // Example for product result
    public boolean isProductExist(String productName) {
        try {
            return driver.findElement(By.linkText(productName)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterProductName(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
    public void selectproductname(String Productname) {
    	driver.findElement(By.linkText(Productname)).click();
    }
}
