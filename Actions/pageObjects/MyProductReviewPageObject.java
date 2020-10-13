package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.MyProductReviewPageUI;
import pageUI.RewardPointsPageUI;

public class MyProductReviewPageObject extends AbstractPage {
	WebDriver driver;
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver=driver;
	}
//	public CustomerInforPageObject openCustomerInfor() {
//		waitToElementClickable(driver,MyProductReviewPageUI.CUSTOMER_LINK );
//		clickToElement(driver, MyProductReviewPageUI.CUSTOMER_LINK);
//		return PageManagerObject.getCustomerInfor(driver);
//	}

}
