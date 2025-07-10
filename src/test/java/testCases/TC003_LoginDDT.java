package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "logindata", dataProviderClass = DataProviders.class) // getting data provier from different
																				// class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {
		logger.info("**** Starting TC003_LoginDDT ****");

		try {

			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.clickLogin();

//			Login

			LoginPage lp = new LoginPage(driver);
			lp.addemail(email);
			lp.addpassword(pwd);
			lp.clicklogin();

//			Assert MyAccount

			MyAccountPage ma = new MyAccountPage(driver);
			boolean targetpage = ma.validateacc();

//		most important part for the data validation

			/*
			 * Data is valid - login success - test passed - logout login failed - test fail
			 * 
			 * 
			 * Data is invalid - login success - test failed - logout login failed - test
			 * passed
			 * 
			 */

			if (exp.equalsIgnoreCase("valid")) {
				if (targetpage == true) {
					ma.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("invalid")) {
				if (targetpage == true) {
					ma.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}

			}

		} catch (Exception e) {
			Assert.fail();

		}
		Thread.sleep(3000);
		logger.info("**** Finished TC003_LoginDDT ****");

	}

}
