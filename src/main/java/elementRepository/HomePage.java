package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	
	@FindBy(linkText="Register")
	private WebElement register;
	
	@FindBy(linkText="Login")
	private WebElement login;

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getLogin() {
		return login;
	}
   
	
}
