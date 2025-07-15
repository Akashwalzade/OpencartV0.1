package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCart extends BaseClass {
	@Test
	public void verify_Addtocart() {
		logger.info("****..started TC005_AddToCart ....***");
		try {
			HomePage hp = new HomePage(driver);
			
			SearchPage sp = new SearchPage(driver);
			ProductPage pp = new ProductPage(driver);

            // Search for product
            sp.enterProductName("MacBook");
            sp.clickSearchButton();
            
         // Select product from results
            sp.selectproductname("MacBook");
            
//            click on addtocart button for the product
            pp = new ProductPage(driver);
            pp.clickAddToCart();
            
            Thread.sleep(2000);
            
            
            Assert.assertTrue(pp.isSuccessMessageDisplayed(),"Add To Cart Message Not Displayed !");
            Assert.assertTrue(pp.getsuccessmsg().contains("Success"),"Unexpected success message!");
            
		}
		catch(Exception e) {
			logger.error("Add to cart is falied because of"+ e.getMessage());
			Assert.fail();
		}
		
		logger.info("***..Finished TC005_AddToCart ....***");
		
	}

}
