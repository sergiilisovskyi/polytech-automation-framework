package framework.pages.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class RozetkaHomePage extends Page {
	
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'exponea-close-cross')]")
	private WebElement closeAddvertPopUpButton;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@class,'rz-header-search-input-text')]")
	private WebElement searchTextField;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'js-rz-search-button')]")
	private WebElement searchButton;

	public RozetkaHomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Search for product: {productName}")
	public RozetkaSearchResultsPage searchProduct(String productName) {
		searchTextField.sendKeys(productName);
		searchButton.click();
		
		return LitsPageFactory.initElements(webDriver, RozetkaSearchResultsPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		if (isElementPresent(10, closeAddvertPopUpButton)) {
			jsClickOnElement(closeAddvertPopUpButton);
		}
		
		return ExpectedConditions.visibilityOf(searchTextField);
	}
}
