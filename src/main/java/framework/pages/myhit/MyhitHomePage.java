package framework.pages.myhit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class MyhitHomePage extends Page {

	@FindBy(xpath = "//input[@id='search-navbar-q']")
	private WebElement searchMovieTextField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchMovieButton;
	
	public MyhitHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Searching for movie: {movieText}")
	public MyhitSearchResultPage searchForMovie(String movieText) {
		searchMovieTextField.sendKeys(movieText);
		searchMovieButton.click();
		return LitsPageFactory.initElements(webDriver, MyhitSearchResultPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(searchMovieTextField);
	}
	
}
