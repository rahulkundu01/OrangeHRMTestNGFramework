package testClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utilities.ListenerImplementation;
import pageClasses.OrangeHRM_AddEmployee;
import pageClasses.OrangeHRM_LoginPage;
import utilities.BaseClass;

@Listeners(ListenerImplementation.class)
public class OrangeHRM_AddEmployeeTest extends BaseClass {
	
	
	
	OrangeHRM_LoginTest lt1 = new OrangeHRM_LoginTest();

	@Test(priority = 1,groups="sanity", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void addEmployeeTest() throws IOException, InterruptedException {
		
		ae1 = new OrangeHRM_AddEmployee(driver);
		test = reports.createTest("Registration Test");
		
		
		test.createNode("Login Test");
		test.log(Status.INFO, "Login Test Initiated");
		
		Thread.sleep(5000);
		
		
		lt1.loginTest();
		logger.info("Login method is called");
		
		ae1.clickOnPimMenu();
		test.log(Status.INFO, "PIM button is clicked");
		logger.info("PIM button is clicked");
		
		
		addExplicitWait(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary' and text()=' Add ']"));
		ae1.clickOnAddButton();
		test.log(Status.INFO, "Add button is clicked");
		logger.info("Add button is clicked");
		
		addExplicitWait(By.xpath("//input[@name='firstName']"));
		ae1.enterFirstName("Harry");
		test.log(Status.INFO, "Entered First name");
		logger.info("Entered First name");
		
		addExplicitWait(By.xpath("//input[@name='lastName']"));
		ae1.enterLastName("dsouza");
		test.log(Status.INFO, "Entered Last Name");
		logger.info("Entered Last Name");
		
		addExplicitWait(By.xpath("//button[@type='submit']"));
		ae1.clickOnSaveButton();
		test.log(Status.INFO, "Clicked on Save button");
		logger.info("Clicked on Save button");
		
		addExplicitWait(By.xpath("//h6[contains(normalize-space(),'Personal Details')]"));
		WebElement dashProfile = ae1.verifySuccessPIM();
		if (dashProfile.isDisplayed()) {
			//System.out.println("Test Case Passed");
			test.log(Status.PASS, "Test Passes: Added Employee and navigated to profile page");
			logger.info("Test Passes:  Added Employee and navigated to profile page");
		}
		else {
			//System.out.println("Test Case Failed");
			test.log(Status.FAIL, "Test Failed: Not able to add the Empolyee");
			logger.info("Test Failed: Not able to add the Employee");
		}
		
	}

}
