package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.DownloadablePageUI;
import pageUI.OrderPageUI;

public class OrderPageObject extends AbstractPage {
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public DownloadablePageObject openDownloadablePage() {
//		waitToElementClickable(driver, OrderPageUI.DOWNLOAD_LINK);
//		clickToElement(driver, OrderPageUI.DOWNLOAD_LINK);
//		return PageManagerObject.getDownloadablePage(driver);
//	}

	

}
