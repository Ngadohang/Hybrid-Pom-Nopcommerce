package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.AddressesPageUI;

public class AddressesPageObject extends AbstractPage {
	WebDriver driver;
	public AddressesPageObject(WebDriver driver) {
		this.driver=driver;
	}
//	public OrderPageObject openOrderPage() {
//		waitToElementClickable(driver, AddressesPageUI.ORDER_LINK);
//		clickToElement(driver, AddressesPageUI.ORDER_LINK);
//		return PageManagerObject.getOrderPage(driver);
//	}
	
	
	
}
