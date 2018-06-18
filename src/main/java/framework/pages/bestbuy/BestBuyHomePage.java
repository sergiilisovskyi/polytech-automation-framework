package framework.pages.bestbuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.PolytechPageFactory;
import framework.pages.Page;

public class BestBuyHomePage extends Page {
	
	@FindBy(xpath = "//div[contains(@class,'email-submission-modal')]//*[@aria-label='Close']")
	private WebElement emailSubmissionButton;
	
	@FindBy(xpath = "//input[@id='gh-search-input']")
	private WebElement searchInputTextField;
	
	@FindBy(xpath = "//*[@title='Search']")
	private WebElement searchButton;

	public BestBuyHomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public BestBuySearchResultsPage searchForItem(String itemName) {
		searchInputTextField.sendKeys(itemName);
		searchButton.click();
		return PolytechPageFactory.initElements(webDriver, BestBuySearchResultsPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		if (isElementPresent(7, emailSubmissionButton)) {
			emailSubmissionButton.click();
		}
		
		return ExpectedConditions.visibilityOf(searchInputTextField);
	}

}