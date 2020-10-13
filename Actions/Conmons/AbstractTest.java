package Conmons;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	//private String source_folder = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		
		if (browserName.equalsIgnoreCase("chrome_ui")) {
			//System.setProperty("webdriver.chrome.driver", source_folder + "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox_ui")) {
			//System.setProperty("webdriver.geckodriver.driver", source_folder + "\\browserDriver\\geckodriver.exe");
			
			WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge_ui")) {
			//System.setProperty("webdriver.edge.driver", source_folder + "\\browserDriver\\msedgedriver.exe");
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("chrome_headless")) {
			//System.setProperty("webdriver.chrome.driver", source_folder + "\\browserDriver\\chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size:1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else if (browserName.equalsIgnoreCase("firefox_headless")) {
			//System.setProperty("webdriver.geckodriver.driver", source_folder + "\\browserDriver\\geckodriver.exe");
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			firefoxOption.setHeadless(true);
			firefoxOption.addArguments("headless");
			firefoxOption.addArguments("window-size:1920x1080");
			driver = new FirefoxDriver(firefoxOption);
		} else if(browserName.equalsIgnoreCase("Coc_Coc")) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions chromeOpt = new ChromeOptions();
//			chromeOpt.setBinary("");
		} else if(browserName.equalsIgnoreCase("Safari")) {
			//driver=new SafariDriver();
		
		}else {
			throw new RuntimeException("Vui long nhap dung ten trinh duyet");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
