package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageManagerObject {
	
	public LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public CustomerInforPageObject getCustomerInfor(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
	public RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
}
