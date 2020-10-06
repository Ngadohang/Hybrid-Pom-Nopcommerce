package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.RegisterPageUI;

	public class RegisterPageObject extends AbstractPage {
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver=driver;
	}
//	public void isRegisterPage() {
//		waitForElementInvisible(driver, RegisterPageUI.REGISTER_TEXT);
//
//	}
	
	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void selectDayDropdown(String dateOfBirthDay) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdownDefault(driver, RegisterPageUI.DAY_DROPDOWN, dateOfBirthDay);

	}

	public void selectMonthDropdown(String dateOfBirthMonth) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdownDefault(driver, RegisterPageUI.MONTH_DROPDOWN, dateOfBirthMonth);

	}

	public void selectYearDropdown(String dateOfBirthYear) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdownDefault(driver, RegisterPageUI.YEAR_DROPDOWN, dateOfBirthYear);


	}

	public void inputToEmailTexbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXBOX, email);
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXBOX);
		senkeyToElement(driver, RegisterPageUI.COMPANY_TEXBOX, company);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXBOX, password);

	}

	public void inputToComfirmPassword(String comfirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXBOX, comfirmPassword);

	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}


	public boolean isRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplay(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, RegisterPageUI.LINK_MY_ACCOUNT);
		return isElementDisplay(driver, RegisterPageUI.LINK_MY_ACCOUNT);
	}

	public boolean isLogoutLinkDisplay() {
		waitForElementVisible(driver, RegisterPageUI.LINK_LOGOUT);
		return isElementDisplay(driver, RegisterPageUI.LINK_LOGOUT);
	}

//	public void clickToContinue() {
//		waitToElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
//		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
//		
//	}

	public HomePageObject clicktoLogoutButton() {
		waitToElementClickable(driver, RegisterPageUI.LINK_LOGOUT);
		clickToElement(driver, RegisterPageUI.LINK_LOGOUT);
		return pagemanager.getHomePage(driver);
	}

	PageManagerObject pagemanager;

}
