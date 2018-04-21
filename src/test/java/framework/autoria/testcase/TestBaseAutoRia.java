package framework.autoria.testcase;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pages.LitsPageFactory;
import framework.pages.autoria.AutoRiaHomePage;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;

public class TestBaseAutoRia {
	
	private static final Logger LOG = LogFactory.getLogger(TestBaseAutoRia.class);

	protected WebDriver webDriver;
	
	protected AutoRiaHomePage autoRiaHomePage;

	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);
		
		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite5.url"));
		
		autoRiaHomePage = LitsPageFactory.initElements(webDriver, AutoRiaHomePage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}