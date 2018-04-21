package framework.pages.myhit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;
import io.qameta.allure.Step;

public class MyhitDirectorPage extends Page {
	
	@FindBy(xpath = "//ul[contains(@class,'list-unstyled')]//*[contains(@href,'filmography')]")
	private WebElement moviesQuantity;

	public MyhitDirectorPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Check directors movies quantity")
	public int getDirectorMoviesQuantity() {
		return Integer.parseInt(moviesQuantity.getText());
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(moviesQuantity);
	}
	
}
