package framework.pages.autoria;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class AutoRiaHomePage extends Page {
	
	@FindBy(xpath = "//a[contains(@class, 'close unlink')]")
	private WebElement closeAddvertPopUpButton;

	@FindBy(xpath = "//a[contains(@href,'advanced-search')]")
	private WebElement advancedSearchButton;

	public AutoRiaHomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Advanced search button click")
	public AutoRiaAdvancedSearchPage clickAdvancedSearch() {
		advancedSearchButton.click();
		return LitsPageFactory.initElements(webDriver, AutoRiaAdvancedSearchPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		if (isElementPresent(10, closeAddvertPopUpButton)) {
			jsClickOnElement(closeAddvertPopUpButton);
		}
		
		return ExpectedConditions.visibilityOf(advancedSearchButton);
	}
}
