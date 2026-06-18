package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MyAccountPage {
     
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement msgHeading;

	public WebElement getMsgHeading() {
		return msgHeading;
	}
	
	
	public WebElement getLinkLogout() {
		return linkLogout;
	}

	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	private WebElement linkLogout;
	
	
	public boolean isMyAccountPageExists() {
		try{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
}
