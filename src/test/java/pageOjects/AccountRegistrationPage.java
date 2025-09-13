package pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txtLastname;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtpwd;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txtCpwd;
	@FindBy(xpath = "//input[@name='agree']") WebElement btnCheck;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmmessag;
	
	
	
	public void setfirstname(String firstname) {
		txtFirstName.sendKeys(firstname);
	}
	
	public void setLatname(String lastname) {
		txtLastname.sendKeys(lastname);
		
	}
	public void setemail(String email) {
		txtEmail.sendKeys(email);
	}
	public void settelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	public void setpassword(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	public void setCpassword(String cpwd) {
		txtCpwd.sendKeys(cpwd);
	}
	public void clickpp() {
		btnCheck.click();
	}
	public void btncontinue() {
		btnContinue.click();
	}
	
	public String getConfirmationmessage() {
		
		try {
			return (confirmmessag.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
}
