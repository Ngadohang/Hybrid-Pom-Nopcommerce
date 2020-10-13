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
import org.openqa.selenium.remote.server.handler.GetPageSource;
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
import pageObjects.ExamPageObject;
import pageObjects.LoginPageObject;

import pageObjects.MyProductReviewPageObject;
import pageObjects.OrderPageObject;
import pageObjects.PageManagerObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_07_Handel_Data_Table extends AbstractTest {
	// AbstractPage abstractPage;
	WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
		driver=getBrowserDriver(browserName, url);
		examPage= new ExamPageObject(driver);
	
	}
	
	
//	@Test
//	public void TC_01_Open_Pagination() {
//		examPage.openPagination("1");
//		
//	}
//	@Test
//	public void TC_02_Get_Total_ByCountry() {
//		examPage.openPageUrl(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid");
//		System.out.println(examPage.getDataByTitle("Country", "Afghanistan", "Total"));
//		System.out.println(examPage.getDataByTitle("Country", "Afghanistan", "Females"));
//		System.out.println(examPage.getDataByTitle("Country", "Afghanistan", "Males"));
//		
//		
//		
//	}
	@Test
	public void TC_03_Delete_Edit_Icon() {
		//examPage.refreshCurrentPage(driver);
		examPage.clickDeleteOrEditByTitleName("Country","Albania","remove");
		
		Assert.assertTrue(examPage.isRemovedByTileName("Country","Albania"));
	}
//	@Test
//	public void TC_04_SenKey_ByColumnName_AtRow() {
//		
//		
//	}
//	


	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	ExamPageObject examPage;
}
	