package framework.bestbuy.testcase;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pages.PolytechPageFactory;
import framework.pages.bestbuy.BestBuyHelloPage;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;

public class TestBaseBestBuy {
	
	private static final Logger LOG = LogFactory.getLogger(TestBaseBestBuy.class);

	private WebDriver webDriver;
	
	protected BestBuyHelloPage bestBuyHelloPage;

	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);

		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite4.url"));
		bestBuyHelloPage = PolytechPageFactory.initElements(webDriver, BestBuyHelloPage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}