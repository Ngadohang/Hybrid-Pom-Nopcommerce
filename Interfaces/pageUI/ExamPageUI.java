package pageUI;

public class ExamPageUI {
	public static final String DYNAMIC_PAGINATION = "//li/a[contains(@class,'qgrd-pagination-page-link' )and text()='%s']";
	public static final String DYNAMIC_COLOMN_SIZE = "//div[text()='%s']//ancestor::th/preceding-sibling::th";

	public static final String DYNAMIC_TITLE_COLOMN_BY_CELL_TEXT_INDEX = "//tr//td[%s and text()='%s']";

	public static final String DYNAMIC_REMOVE_EDIT_BUTTON = DYNAMIC_TITLE_COLOMN_BY_CELL_TEXT_INDEX +"/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";

	public static final String DYNAMIC_CELL_DATA_BY_TITLE_CELL = "//td[text()='%s']/parent::tr/td[%s]";

}
