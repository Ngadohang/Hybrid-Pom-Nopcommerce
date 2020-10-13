package pageObjects;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import Conmons.AbstractPageUploadFiles;
import Conmons.GlobalConstants;
import pageUI.AbstractPageUI;

public class UploadFilesPageObject extends AbstractPage {
	WebDriver driver;

	public UploadFilesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	AbstractPageUploadFiles abstractUploadFiles = new AbstractPageUploadFiles();

	public void uploadMutilFilesPageObject(String folderName, String... files) {
		abstractUploadFiles.uploadMutilFiles(driver, folderName, files);
	}

	public boolean isFileDisplays(String... files) {
		boolean status = false;
		for (String File : files) {
			waitForElementDynamicVisible(driver, AbstractPageUI.DYNAMIC_FILE_NAME, File);
			status = isElementDisplay(driver, AbstractPageUI.DYNAMIC_FILE_NAME, File);
		}
		return status;
	}

	public void clicKForUploadFiles(String... files) {
		for (String File : files) {
			waitForElementDynamicVisible(driver, AbstractPageUI.DYNAMIC_BUTTON_START, File);
			clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON_START, File);
		}

	}

	public boolean isFilesUploadedSuccess(String... files) {
		boolean status = false;
		for (String File : files) {
			waitForElementDynamicVisible(driver, AbstractPageUI.DYNAMIC_FILE_LINK,File);
			status = isElementDisplay(driver, AbstractPageUI.DYNAMIC_FILE_LINK, File);
		}
		return status;
	}

}
