package framework.pages.myhit;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class MyhitSearchResultPage extends Page {
	
	@FindBy(xpath = "//div[@id='film-list']//a[@title and text()]")
	private List<WebElement> moviesSearchResult;

	public MyhitSearchResultPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Opening movie by index: {index}")
	public MyhitMoviePage openMovieByIndex(int index) {
		if (!moviesSearchResult.isEmpty()) {
			if (moviesSearchResult.size() <= index) {
				throw new IllegalArgumentException("There is no movie in search list with index " + index);
			}
			moviesSearchResult.get(index).click();
			return LitsPageFactory.initElements(webDriver, MyhitMoviePage.class);
		} else throw new IllegalStateException("Search movie list is empty");
	}

	@Override
	public Function<WebDriver, Boolean> isPageLoaded() {
		return driver -> !moviesSearchResult.isEmpty();
	}

}
