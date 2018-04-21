package framework.lits.testcase;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pages.LitsPageFactory;
import framework.pages.lits.enterapplication.HomePage;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;



/*
 * Base class for all the test classes
 * 
 * @author Taras Lytvyn
 */

public class TestBaseLits {
	
	private static final Logger LOG = LogFactory.getLogger(TestBaseLits.class);

	private WebDriver webDriver;
	
	protected HomePage homePage;

	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);

		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite1.url"));
		homePage = LitsPageFactory.initElements(webDriver, HomePage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}