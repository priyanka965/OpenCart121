package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.MyAccountPage;
import genericUtility.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("*****Starting_TC002_LoginTest*****");
		
		  try {
		  //HomePage
		  HomePage hp=new HomePage(driver);
		  hp.getMyAccount().click();
		  hp.getLogin().click();
		  
		  //LoginPage
		  LoginPage lp=new LoginPage(driver);
		  lp.getTxtEmailAddress().sendKeys(prop.getProperty("email"));
		  lp.getTxtPassword().sendKeys(prop.getProperty("password"));
		  lp.getBtnLogin().click();
		   
		  //MyAccountPage
		  MyAccountPage macc=new MyAccountPage(driver);
		  boolean targetpage = macc.isMyAccountPageExists();
		  Assert.assertTrue(targetpage);
		 // Assert.assertEquals(targetpage, true,"Login Passed");
		  }
		  catch(Exception e) {
			  Assert.fail();
		  }
		  logger.info("*****Finished_TC002_LoginTest*****");
		  
		
	}
	

}
