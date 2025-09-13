package pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login_page extends BasePage{

	public login_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']") WebElement emailtext;
	@FindBy(xpath = "//input[@id='input-password']") WebElement pwdText;
	@FindBy(xpath = "//input[@value='Login']") WebElement btnloginnn;
	
	public void setemail(String email) {
		emailtext.sendKeys(email);;
	}
	
	public void setpwd(String pwd) {
		pwdText.sendKeys(pwd);;
	}
	
	public void clickLoginl() {
		btnloginnn.click();;
	}
	
}
