package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.ChangePasswordPageUI;

public class ChangePasswordPageOject extends AbstractPage{
	WebDriver driver;
	public ChangePasswordPageOject(WebDriver driver) {
		this.driver=driver;
	}
//	public MyProductReviewPageObject openMyProduct() {
//		waitToElementClickable(driver, ChangePasswordPageUI.MYPRODUCT_LINK);
//		clickToElement(driver, ChangePasswordPageUI.MYPRODUCT_LINK);
//		return PageManagerObject.getBackCustomerInfo(driver);
//	}

	

}
