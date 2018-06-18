package framework.planetakino.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pages.PolytechPageFactory;
import framework.pages.planetakino.PlanetaKinoHomePage;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;

public class TestBasePlanetaKino {
	
	private static final Logger LOG = LogFactory.getLogger(TestBasePlanetaKino.class);

	protected WebDriver webDriver;
	
	protected PlanetaKinoHomePage planetaKinoHomePage;

	@BeforeMethod
	public void setup() {
		String browserName = System.getProperty("browser");
		webDriver = WebDriverFactory.getInstance(browserName);
		
		LOG.info("Navigating to test url");
		webDriver.get(PropertyLoader.loadProperty("testsite6.url"));
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		planetaKinoHomePage = PolytechPageFactory.initElements(webDriver, PlanetaKinoHomePage.class);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			LOG.info("Killing web driver");
			WebDriverFactory.killDriverInstance();
		}
	}

}