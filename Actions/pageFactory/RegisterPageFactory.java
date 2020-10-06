package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Conmons.AbstractPage;
import pageUI.RegisterPageUI;

public class RegisterPageFactory extends AbstractFactory {
	WebDriver driver;

	public RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
	}
//	public void isRegisterPage() {
//		waitForElementInvisible(driver, RegisterPageUI.REGISTER_TEXT);
//
//	}

	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement Gender_Male_Raido;

	@FindBy(xpath = "//h1[text()='Register']")
	WebElement Register_Text;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement Firstname_Textbox;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement LastName_Textbox;

	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement Day_DropDown;

	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement Month_DropDown;

	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement Year_DropDown;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement Email_Textbox;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement Company_Texbox;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement Password_Texbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement Confirm_Password_Textbox;

	@FindBy(xpath = "//div[@class='result']")
	WebElement Register_success_message;

	@FindBy(xpath = "//input[@id='register-button']")
	WebElement Register_Button;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continue_Button;

	@FindBy(xpath = "//a[text()='My account']")
	WebElement Link_My_Account;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement Link_Logout;

	@FindBy(xpath = "//input[@id='Newsletter']")
	WebElement Newsletter_Checked;

	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, Gender_Male_Raido);
		clickToElement(driver, Gender_Male_Raido);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, Firstname_Textbox);
		senkeyToElement(driver, Firstname_Textbox, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, LastName_Textbox);
		senkeyToElement(driver, LastName_Textbox, lastName);

	}

	public void selectDayDropdown(String dateOfBirthDay) {
		waitForElementVisible(driver,Day_DropDown);
		selectItemInDropdownDefault(driver, Day_DropDown, dateOfBirthDay);

	}

	public void selectMonthDropdown(String dateOfBirthMonth) {
		waitForElementVisible(driver, Month_DropDown);
		selectItemInDropdownDefault(driver, Month_DropDown, dateOfBirthMonth);

	}

	public void selectYearDropdown(String dateOfBirthYear) {
		waitForElementVisible(driver, Year_DropDown);
		selectItemInDropdownDefault(driver, Year_DropDown, dateOfBirthYear);

	}

	public void inputToEmailTexbox(String email) {
		waitForElementVisible(driver, Email_Textbox);
		senkeyToElement(driver, Email_Textbox, email);
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, Company_Texbox);
		senkeyToElement(driver,Company_Texbox, company);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, Password_Texbox);
		senkeyToElement(driver, Password_Texbox, password);

	}

	public void inputToComfirmPassword(String comfirmPassword) {
		waitForElementVisible(driver, Confirm_Password_Textbox);
		senkeyToElement(driver, Confirm_Password_Textbox, comfirmPassword);

	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, Register_Button);
		clickToElement(driver,Register_Button);
	}

	public boolean isRegisterSuccessMessage() {
		waitForElementVisible(driver,Register_success_message);
		return isElementDisplay(driver,Register_success_message);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, Link_My_Account);
		return isElementDisplay(driver, Link_My_Account);
	}

	public boolean isLogoutLinkDisplay() {
		waitForElementVisible(driver, Link_Logout);
		return isElementDisplay(driver, Link_Logout);
	}

//	public void clickToContinue() {
//		waitToElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
//		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
//		
//	}

	public void clicktoLogoutButton() {
		waitToElementClickable(driver, Link_Logout);
		clickToElement(driver, Link_Logout);

	}

}
