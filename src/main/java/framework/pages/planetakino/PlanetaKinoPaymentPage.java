package framework.pages.planetakino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Function;

import framework.pages.Page;
import io.qameta.allure.Step;

public class PlanetaKinoPaymentPage extends Page {

	@FindBy(xpath = "//*[@id='platon-frame']")
	private WebElement platonFrame;
	
	public PlanetaKinoPaymentPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Check whether platon payment system is available")
	public boolean isPlatonPaymentSystemAvailable() {
		return platonFrame.isDisplayed();
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> platonFrame.isEnabled();
	}
	
}