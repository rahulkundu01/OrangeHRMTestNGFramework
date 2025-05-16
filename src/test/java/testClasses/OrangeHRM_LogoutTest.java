package testClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageClasses.OrangeHRM_LogoutPage;
import utilities.BaseClass;
import utilities.ListenerImplementation;

@Listeners(ListenerImplementation.class)

public class OrangeHRM_LogoutTest extends BaseClass {
	
	OrangeHRM_LoginTest lt1 = new OrangeHRM_LoginTest();
	
	@Test(priority = 2 , groups="sanity", retryAnalyzer = utilities.RetryAnalyzer.class)
	public void testLogout() throws InterruptedException, IOException {
		lp2 = new OrangeHRM_LogoutPage(driver);
		test = reports.createTest("Test case for Logout");
		
		test.createNode("Login Test");
		test.log(Status.INFO, "Login Test Initiated");
		
		Thread.sleep(5000);
		
		logger.info("Login method is called");
		lt1.loginTest();
		
		
		addExplicitWait(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
		lp2.clickOnAccountDropdown();
		test.log(Status.INFO, "Clicked on account dropdown");
		logger.info("Clicked on account dropdown");
		
		addExplicitWait(By.xpath("(//a[@class='oxd-userdropdown-link'])[4]"));
		lp2.clickOnLogoutOption();
		test.log(Status.INFO, "Clicked on logout option");
		logger.info("Clicked on logout option");
		
	}
	
	

}
