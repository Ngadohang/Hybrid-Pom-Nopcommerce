package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Conmons.AbstractPage;
import pageUI.ExamPageUI;

public class ExamPageObject extends AbstractPage {
	WebDriver driver;
	WebElement element;

	public ExamPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagination(String idPage) {
		waitToElementClickable(driver, ExamPageUI.DYNAMIC_PAGINATION, idPage);
		clickToElement(driver, ExamPageUI.DYNAMIC_PAGINATION, idPage);
	}

	public List<String> getDataByTitle(String columnTitle, String cellTitleValues, String columnData) {
		List<String> listData = new ArrayList<String>();
		String indexColomnTitle = String
				.valueOf(findElementsByXpath(driver, ExamPageUI.DYNAMIC_COLOMN_SIZE, columnTitle).size() + 1);
		String indexColomnData = String
				.valueOf(findElementsByXpath(driver, ExamPageUI.DYNAMIC_COLOMN_SIZE, columnData).size() + 1);
		List<WebElement> allCellTitle = findElementsByXpath(driver, ExamPageUI.DYNAMIC_TITLE_COLOMN_BY_CELL_TEXT_INDEX,
				indexColomnTitle, cellTitleValues);
		for (WebElement CellTitle : allCellTitle) {
			String cellDataValues = getElementByXpath(driver, ExamPageUI.DYNAMIC_CELL_DATA_BY_TITLE_CELL,
					cellTitleValues, indexColomnData).getText();
			listData.add(cellDataValues);
		}
		return listData;

	}

	public void clickDeleteOrEditByTitleName(String columnTitle,String cellTitleValues, String choose) {
		String index = String
				.valueOf(findElementsByXpath(driver, ExamPageUI.DYNAMIC_COLOMN_SIZE, columnTitle).size() + 1);
		List<WebElement> allCell = findElementsByXpath(driver, ExamPageUI.DYNAMIC_TITLE_COLOMN_BY_CELL_TEXT_INDEX,
				index, cellTitleValues);
		for (WebElement Cell : allCell) {
			System.out.println(Cell);
			getElementByXpath(driver, ExamPageUI.DYNAMIC_REMOVE_EDIT_BUTTON, index, cellTitleValues ,choose).click();
		}

	}

	public boolean isRemovedByTileName(String columnTitle, String cellTitleValues) {
		boolean status = false;
		String indexColomnTitle = String
				.valueOf(findElementsByXpath(driver, ExamPageUI.DYNAMIC_COLOMN_SIZE, columnTitle).size() + 1);
		List<WebElement> allCellTitle = findElementsByXpath(driver, ExamPageUI.DYNAMIC_TITLE_COLOMN_BY_CELL_TEXT_INDEX,
				indexColomnTitle, cellTitleValues);
		if(allCellTitle.size()==0) {status=true;}
		return status;
	}

}
