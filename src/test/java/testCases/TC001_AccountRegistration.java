package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{

	

	@Test(groups ={"sanity","Master"})
	public void verify_account_registration() {
		
		try {
			logger.info("**** Test Execution has been started *****");
			HomePage hp = new HomePage(driver);
			
			logger.info("click on the my account");
			hp.ClickMyAccount();
			
			logger.info("click on the register");

			hp.ClickRegister();
			
			logger.info("providing the customer info..");

			AccountRegistrationPage accreg = new AccountRegistrationPage(driver);

			accreg.setFirstname(randomString().toUpperCase());
			accreg.setLastname(randomString().toUpperCase());
			accreg.setEmail(randomString()+"@gmail.com");

			accreg.setphone(randomNumber());
			String password = randomalphanumneric();
			accreg.setPassword(password);
			accreg.setcfmPassword(password);

			accreg.checkPrivacy();
			accreg.clickContinue();

			logger.info("Validating the confirmation message");

			String cfmmessage = accreg.cnfmMessage();
			if(cfmmessage.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
				
			}

//			Assert.assertEquals(cfmmessage, "Your Account Has  Created!#");
			
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
		logger.info("**** Finished Test Execution *****");

		
		

	}
	
	
	
	

}
