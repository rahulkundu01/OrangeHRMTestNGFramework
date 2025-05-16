package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class OrangeHRM_LogoutPage extends BaseClass {
	
	WebDriver driver;
	
	public OrangeHRM_LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement accountDropdown;
	
	@FindBy(xpath="(//a[@class='oxd-userdropdown-link'])[4]")
	WebElement clickOnLogout;
	
	
	public void clickOnAccountDropdown() {
		accountDropdown.click();
	}
	public void clickOnLogoutOption() {
		clickOnLogout.click();
	}

}
