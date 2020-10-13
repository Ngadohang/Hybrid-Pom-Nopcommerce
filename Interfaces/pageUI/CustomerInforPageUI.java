package pageUI;

import nopcommerce.web.user.Level_03_Register_Login;

public class CustomerInforPageUI extends Level_03_Register_Login {
	public static final String REGISTER_TEXT = "//h1[text()='Register']";
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXBOX = "//input[@id='Email']";
	public static final String COMPANY_TEXBOX = "//input[@id='Company']";
	public static final String PASSWORD_TEXBOX = "//input[@id='Password']";

	public static final String NEWSLETTER_CHECKED = "//input[@id='Newsletter']";
	
	public static final String ADDRESSES_LINK="//div[@class='side-2']//a[contains(@href,'addresses')]";
	public static final String CATELOG="//div[@class='side-2']";
}
