package genericUtility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	
	String repname;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
    public ExtentTest test;
   
	public void onStart(ITestContext testContext) {
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp = df.format(dt);*/
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());//time stamp of the report
		repname ="Test Report-" + timestamp + ".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\" +repname); //specify location of the reports
		sparkReporter.config().setCss("Opencart Automation Report"); //Title of the report
		sparkReporter.config().setDocumentTitle("Opencart Functional Testing"); //name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();	
		
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
		
	}
	
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS, result.getName()+"got successfully executed");
		
		
		}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			
			String imagepath=new WebDriverUtility().toTakeScreenshot(BaseClass.sDriver, result.getName());
			test.addScreenCaptureFromPath(imagepath);
		}
		catch(IOException e1){
			e1.printStackTrace();
			
		}
		
		
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+"got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext testcontext) {
		extent.flush();
		
		String pathOFExtentReport = System.getProperty("user.dir")+"\\reports\\"+repname; 
		File extentReport=new File(pathOFExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}
		catch(IOException e){
			e.printStackTrace(); 
		}
	}
	
	
}
