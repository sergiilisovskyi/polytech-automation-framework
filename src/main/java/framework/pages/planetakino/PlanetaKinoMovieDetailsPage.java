package framework.pages.planetakino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class PlanetaKinoMovieDetailsPage extends Page {

	@FindBy(xpath = "//a[@id='tomorrow']")
	private WebElement tomorrowButton;
	
	@FindBy(xpath = "(//div[contains(@class, 'p-tomorrow')]//div[contains(@class, 'showtimes-line-hours-wrapper')]/a)[1]")
	private WebElement firstAvailableStreamTomorrow;
	
	public PlanetaKinoMovieDetailsPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Select first availables tream tomorrow")
	public PlanetaKinoSeatSelectionPage selectFirstAvailableStreamTomorrow() {
		tomorrowButton.click();
		firstAvailableStreamTomorrow.click();
		return LitsPageFactory.initElements(webDriver, PlanetaKinoSeatSelectionPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(tomorrowButton);
	}
	
}