package testClasses;

import java.io.IOException;import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utilities.ListenerImplementation;
import pageClasses.OrangeHRM_LoginPage;
import utilities.BaseClass;
import utilities.FetchDataFromProperty;

@Listeners(ListenerImplementation.class)
public class OrangeHRM_LoginTest extends BaseClass {
	//public WebDriver driver;
	
	//OrangeHRM_LoginPage lp1 = new OrangeHRM_LoginPage(driver);
	
	@Test(priority = 0,groups="sanity", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void loginTest() throws IOException, InterruptedException {
		
		test = reports.createTest("Login Test");
		
		
		test.log(Status.INFO, "Login Test Initiated");
		lp1 = new OrangeHRM_LoginPage(driver);
		
		String fdUser = FetchDataFromProperty.readDataFromProperty().getProperty("uname");
		
		String fdPwd = FetchDataFromProperty.readDataFromProperty().getProperty("pwd");
		
		System.out.println(fdUser + " " + fdPwd);
		
		lp1.enterUsername(fdUser);
		test.log(Status.INFO, "Username is entered");
		logger.info("Username is entered");
		
		lp1.enterPassword(fdPwd);
		test.log(Status.INFO, "Password is entered");
		logger.info("Password is entered");
		
		lp1.clickOnLogin();
		test.log(Status.INFO, "Clicked on Login Button");
		logger.info("Clicked on Login Button");
		
		Thread.sleep(5000);
		WebElement msg = driver.findElement(By.xpath("//h6[contains(normalize-space(),'Dashboard')]"));
		//addExplicitWait((By) msg);
		WebElement dashElement = lp1.verifyDashboard();
		if (dashElement.isDisplayed()) {
			//System.out.println("Test Case Passed");
			test.log(Status.PASS, "Test Passes: User logged in and navigated to Dashboard");
			logger.info("Test Passes: User logged in and navigated to Dashboard");
		}
		else {
			//System.out.println("Test Case Failed");
			test.log(Status.FAIL, "Test Failed: Login is not successful");
			logger.info("Test Failed: Login is not successful");
		}
		
		
	}

}
