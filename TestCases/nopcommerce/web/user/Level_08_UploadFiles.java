package nopcommerce.web.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Conmons.AbstractTest;
import pageObjects.PageManagerObject;
import pageObjects.UploadFilesPageObject;

public class Level_08_UploadFiles extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadFiles = PageManagerObject.getUploadPage(driver);

	}

	@Test
	public void Tc_01_UploadFiles() {
		uploadFiles.uploadMutilFilesPageObject("FilesPath", "image1.jpg", "image2.jpg");

		Assert.assertTrue(uploadFiles.isFileDisplays("image1.jpg", "image2.jpg"));

		uploadFiles.clicKForUploadFiles("image1.jpg", "image2.jpg");
		uploadFiles.sleepInSecond(5);
		uploadFiles.isFilesUploadedSuccess("image1.jpg", "image2.jpg");
	}

	@AfterClass
	public void afterClass() {
	}

	UploadFilesPageObject uploadFiles;

}
