package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MyAccountPage;
import genericUtility.BaseClass;
import genericUtility.DataProviders;
/*Data is valid - login success - test pass- logout
                  login failed - test fail
 * Data is Invalid - login success - test fail - logout 
                  login unsuccessful - test pass
 */
public class TC003_LoginDDT extends BaseClass{
	 
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_LoginDDT(String email,String password,String exp) {
		
		logger.info("********Starting TC_003_LoginDDT**********");
		
		try {
		 //HomePage
		  HomePage hp=new HomePage(driver);
		  hp.getMyAccount().click();
		  hp.getLogin().click();
		  
		  //LoginPage
		  LoginPage lp=new LoginPage(driver);
		  lp.getTxtEmailAddress().sendKeys(email);
		  lp.getTxtPassword().sendKeys(password);
		  lp.getBtnLogin().click();
		   
		  //MyAccountPage
		  MyAccountPage macc=new MyAccountPage(driver);
		  boolean targetpage = macc.isMyAccountPageExists();
		  
		  if(exp.equalsIgnoreCase("Valid")) {
			  if(targetpage=true) {
				  macc.getLinkLogout().click();
				  Assert.assertTrue(true);
			  }
			  else {
				  Assert.assertTrue(false);
			  }
		  }
		  
		  if(exp.equalsIgnoreCase("Invalid")) {
			  if(targetpage=true) {
				  macc.getLinkLogout().click();
				  Assert.assertTrue(false);
			  }
			  else {
				  Assert.assertTrue(true);
			  }
		  }
		}
		catch(Exception e) {
			Assert.fail();
		}
		  
		  logger.info("********Finished TC_003_LoginDDT**********");
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	}

}
