package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageClasses.OrangeHRM_AddEmployee;
import pageClasses.OrangeHRM_LoginPage;
import pageClasses.OrangeHRM_LogoutPage;
import testClasses.OrangeHRM_AddEmployeeTest;
import testClasses.OrangeHRM_LoginTest;
import utilities.FetchDataFromProperty;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public OrangeHRM_LoginPage lp1;
	public OrangeHRM_LoginTest lt1;
	public OrangeHRM_AddEmployee ae1;
	public OrangeHRM_LogoutPage lp2;
	
	
    @BeforeSuite(alwaysRun = true)
    public void setupExtent() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "test-output/SparkReport/SparkReport.html";
        htmlReporter = new ExtentSparkReporter(reportPath);
        
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine", "RKTest1");
        reports.setSystemInfo("OS", "Windows11");
        reports.setSystemInfo("User", "Rahul Kundu");
        reports.setSystemInfo("Browser", "Chrome");

        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("Regression Suite for Open MRS");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
	
	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws IOException
	{
		String browserName=FetchDataFromProperty.readDataFromProperty().getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
			//for logging
			logger = (Logger) LogManager.getLogger("Orange HRM");
			logger.info("URL opened in Chrome");
		}
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
			logger.info("URL opened in Firefox");
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			driver.get(FetchDataFromProperty.readDataFromProperty().getProperty("URL"));
			driver.manage().window().maximize();
			logger.info("URL opened in Edge");
		}
			
	}
	
	public static void addExplicitWait(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void addImpicitWait() {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void scrollDown()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", " ");
	}
	
	@AfterTest (alwaysRun = true)
	public void teardownDriver() throws InterruptedException {
		
		
		if (driver != null) {
	        for (String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	            logger.info("Test Completed");
	            driver.close();
	        }
		
		
	}
	}
	
	
	@AfterSuite(alwaysRun=true)
    public void tearDown() {
        reports.flush(); // Important to write the report!
    }
	
	

}
