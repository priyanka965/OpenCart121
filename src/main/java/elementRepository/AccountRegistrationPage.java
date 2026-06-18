package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {
	
	public AccountRegistrationPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement chkdPolicy;
	
    @FindBy(xpath="//input[@value='Continue']") 
    private WebElement btnContinue;
    
    @FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
    private WebElement msgConfirmation;

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtLastname() {
		return txtLastname;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtTelephone() {
		return txtTelephone;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getTxtConfirmPassword() {
		return txtConfirmPassword;
	}

	public WebElement getChkdPolicy() {
		return chkdPolicy;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getMsgConfirmation() {
		return msgConfirmation;
	}
    
    public String getConfirmationMsg() {
    	try {
    		return(msgConfirmation.getText());
    	}
    	catch(Exception e){
    	  return(e.getMessage());	
    	}
    }
	
	
	
	
	
	
	
	
	
	
	

}
