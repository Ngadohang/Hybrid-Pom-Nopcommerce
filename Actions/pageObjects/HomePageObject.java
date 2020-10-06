package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.HomePageUI;

    public class HomePageObject extends AbstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public  HomePageObject  getHomePage() {
		return pagemanager.getHomePage(driver);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
		return pagemanager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickElementByJs(driver, HomePageUI.LOGIN_LINK);
		return pagemanager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.LINK_MY_ACCOUNT);
		return isElementDisplay(driver, HomePageUI.LINK_MY_ACCOUNT);
	}

	public boolean isLogoutLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.LINK_LOGOUT);
		return isElementDisplay(driver, HomePageUI.LINK_LOGOUT);
	}

	public CustomerInforPageObject clickToMyAccoutLink() {
		waitToElementClickable(driver, HomePageUI.LINK_LOGOUT);
		clickToElement(driver, HomePageUI.LINK_MY_ACCOUNT);
		return pagemanager.getCustomerInfor(driver);
	}

	public void clicktoLogoutButton() {
		if(driver.toString().equalsIgnoreCase("edge")) {
			sleepInMilisecond(500);
		}
		waitToElementClickable(driver, HomePageUI.LINK_LOGOUT);
		clickToElement(driver, HomePageUI.LINK_LOGOUT);

	}
	
	PageManagerObject pagemanager;

}
