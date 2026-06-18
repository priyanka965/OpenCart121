package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.AccountRegistrationPage;
import elementRepository.HomePage;
import genericUtility.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_Registration() {
		try{
		logger.info("**** Starting TC001_AccountRegistrationTest****");
		HomePage hp=new HomePage(driver);
		hp.getMyAccount().click();
		logger.info("Clicked on MyAccount Link");
		hp.getRegister().click();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details...");
		regpage.getTxtFirstname().sendKeys(randomString().toUpperCase());
		regpage.getTxtLastname().sendKeys(randomString().toUpperCase());
		regpage.getTxtEmail().sendKeys(randomString()+"@gmail.com");
		regpage.getTxtTelephone().sendKeys(randomNumber());
		
		String password=randomAlphaNumeric();
		regpage.getTxtPassword().sendKeys(password);
		regpage.getTxtConfirmPassword().sendKeys(password);
		
		regpage.getChkdPolicy().click();
		regpage.getBtnContinue().click();
		
		logger.info("Validating Expected Message...");
		
		String confMsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		
		logger.info("*******TC001_AccountRegistrationTest end*********");
			
		}
		catch(Exception e) {
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.fail();
			
			
			
		}
		
		
	}
	
	
	

}
