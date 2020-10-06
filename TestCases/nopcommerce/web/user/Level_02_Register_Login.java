package nopcommerce.web.user;

import org.testng.annotations.Test;

import Conmons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Level_02_Register_Login extends AbstractPage {
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
		

	}

	@Test
	public void TC_01_Register() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		clickToElement(driver, "//a[text()='Register']");
		waitForElementVisible(driver, "//h1[text()='Register']");
		checkToCheckBox(driver, "//span[@class='male']");
		senkeyToElement(driver, "//input[@id='FirstName']", "Do Hang");
		senkeyToElement(driver, "//input[@id='LastName']", "Nga");
		selectItemInDropdownDefault(driver, "//select[@name='DateOfBirthDay']", "6");
		selectItemInDropdownDefault(driver, "//select[@name='DateOfBirthMonth']", "February");
		selectItemInDropdownDefault(driver, "//select[@name='DateOfBirthYear']", "1995");
		senkeyToElement(driver, "//input[@id='Email']", "ngado123@gmail.com");
		senkeyToElement(driver, "//input[@id='Company']", "Apple");
		senkeyToElement(driver, "//input[@id='Password']", "123456");
		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		clickToElement(driver, "//input[@id='register-button']");
		waitForElementVisible(driver, "//div[@class='result']");
		clickToElement(driver, "//input[@name='register-continue']");
		waitForElementVisible(driver, "//div[@class='header-links']//a[text()='My account']");

	}

	@Test
	public void TC_02_Login() {

	}

	@Test
	public void TC_03_View_My_Accout() {

	}

	@AfterClass
	public void afterClass() {
	}

}
