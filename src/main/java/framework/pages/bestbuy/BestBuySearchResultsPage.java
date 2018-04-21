package framework.pages.bestbuy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;

public class BestBuySearchResultsPage extends Page {
	
	@FindBy(xpath = "//button[@id='survey_invite_no']")
	private WebElement noPopUpAnswer;
	
	@FindBy(xpath = "//*[@id='activeTab']")
	private WebElement allProductsTab;
	
	@FindBy(xpath = "//*[text()='Add to Cart']")
	private List<WebElement> addToCartButtons;

	public BestBuySearchResultsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public int getAddToCartItemsQunatity() {
		return addToCartButtons.size();
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		if (isElementPresent(10, noPopUpAnswer)) {
			noPopUpAnswer.click();
		}
		
		return ExpectedConditions.visibilityOf(allProductsTab);
	}

}