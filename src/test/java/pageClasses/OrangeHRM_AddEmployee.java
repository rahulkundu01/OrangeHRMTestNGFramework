package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class OrangeHRM_AddEmployee extends BaseClass {
	WebDriver driver;
	
	public OrangeHRM_AddEmployee(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")
	WebElement pimMenu;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary' and text()=' Add ']")
	WebElement btnAdd;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSave;
	
	@FindBy(xpath="//h6[contains(normalize-space(),'Personal Details')]")
	WebElement verifyPersonal;
	
	
	
	public void clickOnPimMenu() {
		pimMenu.click();
	}
	public void clickOnAddButton() {
		btnAdd.click();
	}
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void clickOnSaveButton() {
		btnSave.click();
	}
	public WebElement verifySuccessPIM() {
		return verifyPersonal;
	}

}
