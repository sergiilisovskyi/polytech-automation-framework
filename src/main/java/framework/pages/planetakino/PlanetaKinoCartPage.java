package framework.pages.planetakino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class PlanetaKinoCartPage extends Page {

	@FindBy(xpath = "//div[contains(@class, 'ticket__element')]//button[contains(@class, 'add-to-cart')]")
	private WebElement payButton;
	
	public PlanetaKinoCartPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Click pay button")
	public PlanetaKinoPaymentPage clickPayButton() {
		//getWebDriverWait(10).until(ExpectedConditions.elementToBeClickable(payButton));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {}
		jsClickOnElement(payButton);
		return LitsPageFactory.initElements(webDriver, PlanetaKinoPaymentPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> payButton.isEnabled();
	}
	
}