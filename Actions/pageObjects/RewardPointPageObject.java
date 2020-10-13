package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import pageUI.AddressesPageUI;
import pageUI.RewardPointsPageUI;

public class RewardPointPageObject extends AbstractPage{
	WebDriver driver;
	public RewardPointPageObject(WebDriver driver) {
		this.driver=driver;
	}

//	public ChangePasswordPageOject openChangePassword() {
//		waitToElementClickable(driver,RewardPointsPageUI.CHANGEPASSWORD_LINK );
//		clickToElement(driver, RewardPointsPageUI.CHANGEPASSWORD_LINK);
//		return PageManagerObject.getChangePassword(driver);
//	}

	

}
