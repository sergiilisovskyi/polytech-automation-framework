package framework.rozetka.testcase;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pages.PolytechPageFactory;
import framework.pages.rozetka.RozetkaHomePage;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;

public class TestBaseRozetka {
	
	private static final Logger LOG = LogFactory.getLogger(TestBaseRozetka.class);

	protected WebDriver webDriver;
	
	protected RozetkaHomePage rozetkaHomePage;

	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);
		
		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite3.url"));
		
		rozetkaHomePage = PolytechPageFactory.initElements(webDriver, RozetkaHomePage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}