package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;

import pageUI.BackInStockPageUI;

public class BackInStockPageObject extends AbstractPage {
	WebDriver driver;
	
	public BackInStockPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
//	public RewardPointPageObject openRewardPoint() {
//		waitToElementClickable(driver,BackInStockPageUI.REWARDPOINT_LINK);
//		clickToElement(driver, BackInStockPageUI.REWARDPOINT_LINK);
//		return PageManagerObject.getRewardPoint(driver);
//	}

}
