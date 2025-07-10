package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void Verify_login() {
		
		logger.info("**** Sterted TC002_LoginTest ****");
		
		try {
//			Homepage
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.clickLogin();
			
//			Login
			
			LoginPage lp = new LoginPage(driver);
			lp.addemail(p.getProperty("email"));
			lp.addpassword(p.getProperty("pwd"));
			lp.clicklogin();
			
//			Assert MyAccount
			
			MyAccountPage ma = new MyAccountPage(driver);
			boolean target = ma.validateacc();
			Assert.assertEquals(target, true,"Test Failed");
			
		}catch(Exception e) {
			
			Assert.fail();	
			
		}
		
		logger.info("**** Finished TC002_LoginTest ****");

		
		

		
		
	}

}
