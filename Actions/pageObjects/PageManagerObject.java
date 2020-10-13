package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageManagerObject {
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static CustomerInforPageObject getCustomerInfor(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	
	public static DownloadablePageObject getDownloadablePage(WebDriver driver) {
		return new DownloadablePageObject(driver);
	}
	
	public static BackInStockPageObject getBackInStock(WebDriver driver) {
		return new BackInStockPageObject(driver) ;
	}
	
	public static RewardPointPageObject getRewardPoint(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	
	public static ChangePasswordPageOject getChangePassword(WebDriver driver) {
		return new ChangePasswordPageOject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	
	public static ExamPageObject getLoginAdminPage(WebDriver driver) {
		return new ExamPageObject(driver);
	}
	
	public static UploadFilesPageObject getUploadPage(WebDriver driver) {
		return new UploadFilesPageObject(driver);
	}
	
}
