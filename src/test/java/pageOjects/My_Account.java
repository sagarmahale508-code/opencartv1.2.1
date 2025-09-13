package pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_Account extends BasePage {

	public My_Account(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement msgHeading;
	
	public boolean ismyaccountDisplayed() {
	
		try{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
}
