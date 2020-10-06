package nopcommerce.web.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Conmons.AbstractPage;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Register_Login extends AbstractPage {
	// AbstractPage abstractPage;
	WebDriver driver;
	String source_folder = System.getProperty("user.dir");
	String firstName, lastName, dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear, company, password, comfirmPassword,
			email;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.geckodriver.driver", source_folder + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// abstractPage = new AbstractPage();
		firstName = "Nga";
		lastName = "Do";
		dateOfBirthDay = "10";
		dateOfBirthMonth = "January";
		dateOfBirthYear = "1995";
		company = "Apple";
		password = "123456";
		comfirmPassword = "123456";
		email = "ngado" + getEmailRandom() + "@gmail.com";

		driver.get("https://demo.nopcommerce.com/");
		homepage = new HomePageObject(driver);

	}

	@Test
	public void TC_01_Register() {
		homepage.clickToRegisterLink();
		register = new RegisterPageObject(driver);
		//register.isRegisterPage();
		register.clickToGenderMaleRadioButton();
		register.inputToFirstNameTextBox(firstName);
		register.inputToLastNameTextBox(lastName);
		register.selectDayDropdown(dateOfBirthDay);
		register.selectMonthDropdown(dateOfBirthMonth);
		register.selectYearDropdown(dateOfBirthYear);
		register.inputToEmailTexbox(email);
		register.inputToCompanyTextbox(company);
		register.inputToPasswordTextbox(password);
		register.inputToComfirmPassword(comfirmPassword);
		register.clickToRegisterButton();
		Assert.assertTrue(register.isRegisterSuccessMessage());
		Assert.assertTrue(register.isMyAccountLinkDisplay());
		Assert.assertTrue(register.isLogoutLinkDisplay());
		
		
		register.clicktoLogoutButton();
		homepage = new HomePageObject(driver);	
		
		
	}

	@Test
	public void TC_02_Login() {
		homepage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();

		homepage = new HomePageObject(driver);
		Assert.assertTrue(homepage.isMyAccountLinkDisplay());
		Assert.assertTrue(homepage.isLogoutLinkDisplay());

	}

	@Test
	public void TC_03_View_My_Accout() {
		homepage.clickToMyAccoutLink();
		customerInfor = new CustomerInforPageObject(driver);

		Assert.assertTrue(customerInfor.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInfor.getFirstNameTextBox(), firstName);
		Assert.assertEquals(customerInfor.getLastNameTextBox(), lastName);
		Assert.assertEquals(customerInfor.getSelectedTextInDayDropdown(), dateOfBirthDay);
		Assert.assertEquals(customerInfor.getSelectedTextInMonthDropdown(), dateOfBirthMonth);
		Assert.assertEquals(customerInfor.getSelectedTextInYearDropdown(), dateOfBirthYear);

		Assert.assertEquals(customerInfor.getEmailTexBoxValue(), email);
		Assert.assertEquals(customerInfor.getCompanyTextBoxValue(), company);

		Assert.assertTrue(customerInfor.isNewsLetterChecked());

	}

	public int getEmailRandom() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	HomePageObject homepage;
	RegisterPageObject register;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInfor;

}
