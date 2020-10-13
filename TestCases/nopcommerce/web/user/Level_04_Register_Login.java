package nopcommerce.web.user;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Conmons.AbstractPage;
import Conmons.AbstractTest;
import pageObjects.AddressesPageObject;
import pageObjects.BackInStockPageObject;
import pageObjects.ChangePasswordPageOject;
import pageObjects.CustomerInforPageObject;
import pageObjects.DownloadablePageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.OrderPageObject;
import pageObjects.PageManagerObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_04_Register_Login extends AbstractTest {
	// AbstractPage abstractPage;
	WebDriver driver;
	String firstName, lastName, dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear, company, password, comfirmPassword,
			email;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
		driver = getBrowserDriver(browserName,url);
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
		homePage = pageManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.selectDayDropdown(dateOfBirthDay);
		registerPage.selectMonthDropdown(dateOfBirthMonth);
		registerPage.selectYearDropdown(dateOfBirthYear);
		registerPage.inputToEmailTexbox(email);
		registerPage.inputToCompanyTextbox(company);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToComfirmPassword(comfirmPassword);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMessage());
		Assert.assertTrue(registerPage.isMyAccountLinkDisplay());
		Assert.assertTrue(registerPage.isLogoutLinkDisplay());

		// handel
		registerPage.clicktoLogoutButton();

		// homepage = new HomePageObject(driver);

	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox(email);
		loginPage.inputToPasswordTextBox(password);
		homePage = loginPage.clickToLoginButton();

		// homepage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
		Assert.assertTrue(homePage.isLogoutLinkDisplay());

	}

	@Test
	public void TC_03_View_My_Accout() {
		customerInfor = homePage.clickToMyAccoutLink();

		// customerInfor = new CustomerInforPageObject(driver);

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

	@Test
	public void TC_04_Switch_Page() {
		// customerInfo switch all page
		// customerInfor = homePage.clickToMyAccoutLink();
		addressPage = customerInfor.openAddressesPage(driver);
		orderPage = addressPage.openOrderPage(driver);
		dowloadablePage = orderPage.openDownloadabePage(driver);
		backInStock = dowloadablePage.openBackInStockPage(driver);
		rewardPoint = backInStock.openRewardPoint(driver);
		changePassword = rewardPoint.openChangepasswordPage(driver);
		myProduct = changePassword.openMyProductPage(driver);
		customerInfor = myProduct.openCustomerPage(driver);
	}

	public int getEmailRandom() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInfor;
	PageManagerObject pageManager;
	AddressesPageObject addressPage;
	DownloadablePageObject dowloadablePage;
	OrderPageObject orderPage;
	BackInStockPageObject backInStock;
	RewardPointPageObject rewardPoint;
	ChangePasswordPageOject changePassword;
	MyProductReviewPageObject myProduct;

}
