package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.CustomerInforPageUI;
import pageUI.HomePageUI;

public class CustomerInforPageObject extends AbstractPage {
	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextBox() {
		waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextBox() {
		waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.LASTNAME_TEXTBOX, "value");

	}

	public String getSelectedTextInDayDropdown() {
		waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdownDefault(driver, CustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdownDefault(driver, CustomerInforPageUI.MONTH_DROPDOWN);

	}

	public String getSelectedTextInYearDropdown() {
		waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdownDefault(driver, CustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTexBoxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXBOX);
		return getElementAttribute(driver, CustomerInforPageUI.EMAIL_TEXBOX, "value");
	}

	public String getCompanyTextBoxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_TEXBOX);
		return getElementAttribute(driver, CustomerInforPageUI.COMPANY_TEXBOX, "value");
	}

	public boolean isNewsLetterChecked() {
		waitForElementVisible(driver, CustomerInforPageUI.NEWSLETTER_CHECKED);
		return isElementSelected(driver, CustomerInforPageUI.NEWSLETTER_CHECKED);
	}

	public boolean isCatelogDisplay() {
		waitForElementVisible(driver, CustomerInforPageUI.CATELOG);
		return isElementDisplay(driver, CustomerInforPageUI.CATELOG);
	}

//	public AddressesPageObject openAddressesPage() {
//		waitToElementClickable(driver, CustomerInforPageUI.ADDRESSES_LINK);
//		clickToElement(driver, CustomerInforPageUI.ADDRESSES_LINK);
//		return PageManagerObject.getAddressesPage(driver);
//	}

	


}
