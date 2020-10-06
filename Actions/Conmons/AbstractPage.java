package Conmons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		;

	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void senkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String titleCurrent = getCurrentPageTitle(driver);
			if (titleCurrent.equals(title)) {
				break;
			}
		}
	}

	public void closeWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public void closeWindowWithoutTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String titleCurrent = getCurrentPageTitle(driver);
			if (!titleCurrent.equals(title)) {
				driver.close();
			}
		}

		driver.switchTo().window(driver.getWindowHandle());
	}

	public WebElement getElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(By.xpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		sleepInMilisecond(500);
		getElementByXpath(driver, locator).click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String value) {
		getElementByXpath(driver, locator).clear();
		if(driver.toString().toUpperCase().contains("chrome") || driver.toString().toUpperCase().contains("edge")) {
			sleepInMilisecond(1000);
		}
		getElementByXpath(driver, locator).sendKeys(value);
	}
	
	public void sleepInMilisecond(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectItemInDropdownDefault(WebDriver driver, String locator, String valueItem) {
		element = getElementByXpath(driver, locator);
		Select select = new Select(element);
		select.selectByVisibleText(valueItem);
	}

	public void selectMutipleItemDefault(WebDriver driver, String locator, String[] expectedItems) {
		element = getElementByXpath(driver, locator);
		Select select = new Select(element);

		List<WebElement> allItems = select.getOptions();
		for (WebElement Item : allItems) {
			for (String expectedItem : expectedItems) {
				if (Item.getText().equals(expectedItem)) {
					Item.click();
					break;
				}
			}
		}

	}

	public String getFirstSelectedTextInDropdownDefault(WebDriver driver, String locator) {
		WebElement element = getElementByXpath(driver, locator);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMutiple(WebDriver driver, String locator) {
		WebElement element = getElementByXpath(driver, locator);
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentItem, String childItem, String expectedItem) {
		getElementByXpath(driver, parentItem).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItem)));

		List<WebElement> allItems = findElementsByXpath(driver, childItem);

		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", item);
				explicitWait.until(ExpectedConditions.elementToBeClickable(item)).click();
				break;
			}
		}

	}

	public void selectMutipleItemCustomDropdown(WebDriver driver, String parentItem, String childItem,
			String[] expectedItems) {
		getElementByXpath(driver, parentItem).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItem)));

		List<WebElement> allItems = findElementsByXpath(driver, childItem);
		for (WebElement allItem : allItems) {
			for (String expectedItem : expectedItems) {
				if (allItem.getText().equals(expectedItem)) {
					allItem.click();
					break;
				}
			}
		}

	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(1000 * second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		WebElement element = getElementByXpath(driver, locator);
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = getElementByXpath(driver, locator);
		return element.getText();
	}

	public int contElementSize(WebDriver driver, String locator) {
		return findElementsByXpath(driver, locator).size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		WebElement element = getElementByXpath(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		WebElement element = getElementByXpath(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String locator) {
		return getElementByXpath(driver, locator).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElementByXpath(driver, locator).isSelected();
	}

	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElementByXpath(driver, locator).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElementByXpath(driver, locator));
	}

	public void switchFrame(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getElementByXpath(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getElementByXpath(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElementByXpath(driver, locator)).perform();
	}

	public void clickAndHoldToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.clickAndHold(getElementByXpath(driver, locator)).perform();
	}

	public void dragAndDrogElement(WebDriver driver, String source, String target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getElementByXpath(driver, source), getElementByXpath(driver, target)).perform();
	}

	public void senKeyBoarchToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElementByXpath(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String Javascript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(Javascript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location='" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElementByXpath(driver, locator);
		String orginalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],argument[2])", element, "style",
				"border: 2px solid red;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],argument[2])", element, "style", orginalStyle);

	}

	public void clickElementByJs(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click()", getElementByXpath(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("argument[0].scrollIntoView(true)", getElementByXpath(driver, locator));
	}

	public void senKeyToElementByJs(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("argument[0].setAttribute('value','" + value + "')",
				getElementByXpath(driver, locator));
	}

	public void removeAttributeInDom(WebDriver driver, String locator, String attribute) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("argument[0].removeAttribute('" + attribute + "')",
				getElementByXpath(driver, locator));
	}

	public String getHiddenText(WebDriver driver, String cssLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.querySelector(\"" + cssLocator + "\").textContent");
	}
	
	public void hiddenElementByJS(WebDriver driver, String locator) {
		//Object element= ((JavascriptExecutor) driver).executeScript("return document.querySelector(\""+cssLocator+"\")");
		WebElement element= getElementByXpath(driver, locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element,"style","display:none");
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElementByXpath(driver, locator);
		return (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth!=\"undefined\" && arguments[0].naturalWidth>0",
				element);
	}

	public boolean waitToJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitToElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public void waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private WebElement element;
}
