package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver=null;
    public static WebDriver sDriver;
    public org.apache.logging.log4j.Logger logger; 
	public Properties prop;
	@BeforeClass(groups= {"Sanity","Regression","Master"})
    @Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("./src//test//resources//config.properties");
		prop.load(fis);
		
		logger=LogManager.getLogger(this.getClass()); //log4j
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
		
			//os
			if(os.equalsIgnoreCase("windows")){
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No Matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No Matching Browser"); return;
			
			
			}
			
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) 
			{
			case "chrome":driver=new ChromeDriver(); break;
			case "edge":driver=new EdgeDriver(); break;
			case "firefox":driver=new FirefoxDriver(); break;
			case "default": System.out.println("Invalid browser name..."); return;
			}
		}
	     
	
		
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	
	driver.get(prop.getProperty("appURL2"));
	driver.manage().window().maximize();
	sDriver=driver;
	

}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
		
}
	
	
	public String randomString() {
		String generatedstring =RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber() {
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
		
	}
	
	public String randomAlphaNumeric() {
		String generatedstring =RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return (generatedstring+"@"+generatednumber);
		
		
	}

	
}
