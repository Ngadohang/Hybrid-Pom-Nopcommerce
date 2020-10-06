package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.LoginPageUI;

	public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXBOX );
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXBOX, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXBOX );
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXBOX, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);
	}
	

}
