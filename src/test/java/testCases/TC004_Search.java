package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_Search extends BaseClass {
	
	@Test(groups = {"Regression", "Master"})
    public void verify_search() throws InterruptedException {
        logger.info("***** Starting TC004_Search *****");
		try {
			 HomePage hp = new HomePage(driver);

	            SearchPage sp = new SearchPage(driver);
	            sp.enterProductName("MacBook");
	            sp.clickSearchButton();
	            
	            boolean result = sp.isProductExist("MacBook");
	            Assert.assertTrue(result, "Product not found in search results!");
			
		}catch(Exception e) {
			logger.error("Search test failed due to exception: " + e.getMessage());
            Assert.fail();
			
		}
		Thread.sleep(3000);
		
        logger.info("***** Finished  TC004_Search *****");

		
	}
	

}
