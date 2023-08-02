package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(id = "Password")
	WebElement txtPassword;

	
	@FindBy(css = ".button-1")
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	WebElement lnkLogout;
	
	
	public void enterUserName(String username) {
		txtEmail.clear();
		txtEmail.sendKeys(username);

	}

	public void enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickLogout() {
		lnkLogout.click();
	}
	
}
