package genericUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {
	public static WebDriver driver;
	
	
	
	public String toTakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./screenShots"+screenshotName+"_"+timestamp+".jpeg");
		FileHandler.copy(temp, src);
		String completePath = src.getAbsolutePath();
		return completePath;
		
		
	}
	

}
