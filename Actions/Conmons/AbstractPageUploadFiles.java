package Conmons;

import org.openqa.selenium.WebDriver;

import Conmons.AbstractPage;
import Conmons.GlobalConstants;
import pageUI.AbstractPageUI;

public class AbstractPageUploadFiles extends AbstractPage {

	private String osName = System.getProperty("os.name");

	public String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	public boolean isWindow() {
		return (osName.toLowerCase().indexOf("window") >= 0);
	}

	public boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	public boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0
				|| osName.toLowerCase().indexOf("aix") > 0);
	}

	public boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

	public void uploadMutilFiles(WebDriver driver, String folderName, String... files) {
		String fullFilePath = "";
		for (String File : files) {
			fullFilePath = fullFilePath + GlobalConstants.FOLDER_NAME + getDirectorySlash(folderName) + File + "\n";
		}
		fullFilePath = fullFilePath.trim();
		senkeyToElement(driver, AbstractPageUI.DYNAMIC_FILE_TYPE, fullFilePath);

	}

}
