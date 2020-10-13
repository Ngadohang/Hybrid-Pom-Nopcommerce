package pageUI;

public class AbstractPageUI {
	
	public static final String ADDRESSES_LINK="//div[@class='side-2']//a[contains(@href,'addresses')]";
	public static final String ORDER_LINK="//div[@class='side-2']//a[contains(@href,'order')]";
	public static final String BACKINSTOCK_LINK="//div[@class='side-2']//a[contains(@href,'back')]";
	public static final String CHANGEPASSWORD_LINK="//div[@class='side-2']//a[contains(@href,'change')]";
	public static final String CUSTOMER_LINK="//div[@class='side-2']//a[contains(@href,'customer')]";
	public static final String DOWNLOADABLE_LINK="//div[@class='side-2']//a[contains(@href,'download')]";
	public static final String REWARDPOINT_LINK="//div[@class='side-2']//a[contains(@href,'reward')]";
	public static final String MYPRODUCT_LINK="//div[@class='side-2']//a[contains(@href,'productreview')]";
	
	
	public static final String DYNAMIC_LOCATOR= "//div[@class='side-2']//a[text()='%s']";
	
	public static final String DYNAMIC_FILE_TYPE="//input[@type='file']";

	public static final String DYNAMIC_FILE_NAME="//td//p[text()='%s']";
	public static final String DYNAMIC_BUTTON_START =DYNAMIC_FILE_NAME+ "/parent::td/following-sibling::td/button[contains(@class,'start')]";
	
	public static final String DYNAMIC_FILE_LINK ="//td//p[@class='name']//a[@title='%s']";

}

