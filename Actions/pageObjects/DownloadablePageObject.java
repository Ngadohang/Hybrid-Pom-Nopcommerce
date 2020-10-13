package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.BackInStockPageUI;
import pageUI.DownloadablePageUI;

public class DownloadablePageObject extends AbstractPage {
	WebDriver driver;
	public DownloadablePageObject(WebDriver driver) {
		this.driver=driver;
	}
//	public BackInStockPageObject openBackInStock() {
//		waitToElementClickable(driver,DownloadablePageUI.BACKINTOSTOCK_LINK);
//		clickToElement(driver, DownloadablePageUI.BACKINTOSTOCK_LINK);
//		return PageManagerObject.getBackInStock(driver);
//	}
	
	
	

}
