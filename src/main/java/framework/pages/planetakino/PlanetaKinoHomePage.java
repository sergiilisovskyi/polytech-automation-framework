package framework.pages.planetakino;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class PlanetaKinoHomePage extends Page {

	@FindBy(xpath = "(//div[contains(@class, 'movies-list')])[1]//img")
	private List<WebElement> moviesList;
	
	public PlanetaKinoHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Click on movie by index: {movieIndex}")
	public PlanetaKinoMovieDetailsPage clickOnMovieByIndex(int movieIndex) {
		moviesList.get(movieIndex).click();
		return LitsPageFactory.initElements(webDriver, PlanetaKinoMovieDetailsPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !moviesList.isEmpty();
	}
	
}