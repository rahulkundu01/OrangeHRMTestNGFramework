package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class OrangeHRM_LoginPage extends BaseClass {
	
	WebDriver driver; 
	
	
	public OrangeHRM_LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath = "//input[@name='username']")
	WebElement loginUserName;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement loginPassword;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement loginBtnLogin;
	
	@FindBy(xpath="//h6[contains(normalize-space(),'Dashboard')]")
	WebElement textMessage;
	
	public  void enterUsername(String luname) {
		loginUserName.sendKeys(luname);
	}
	public void enterPassword(String lpwd) {
		loginPassword.sendKeys(lpwd);
	}
	public  void clickOnLogin() {
		loginBtnLogin.click();
	}
	public  WebElement verifyDashboard() {
		return textMessage;
	}

}
