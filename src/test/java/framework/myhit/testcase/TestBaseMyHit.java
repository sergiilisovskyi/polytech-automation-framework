package framework.myhit.testcase;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pages.PolytechPageFactory;
import framework.pages.myhit.MyhitHomePage;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;

public class TestBaseMyHit {
	
	private static final Logger LOG = LogFactory.getLogger(TestBaseMyHit.class);

	protected WebDriver webDriver;
	
	protected MyhitHomePage myhitHomePage;

	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);
		
		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite2.url"));
		
		myhitHomePage = PolytechPageFactory.initElements(webDriver, MyhitHomePage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}