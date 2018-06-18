package framework.pages.bestbuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Function;

import framework.pages.PolytechPageFactory;
import framework.pages.Page;

public class BestBuyHelloPage extends Page {
	
	@FindBy(xpath = "//select[@name='select_locale']")
	private WebElement selectCountry;
	
	@FindBy(xpath = "//img[@alt='Go']")
	private WebElement goButton;

	public BestBuyHelloPage(WebDriver webDriver) {
		super(webDriver);
	}

	public BestBuyHomePage selectCountryByName(String countryName) {
		Select countrySelectDropDown = new Select(selectCountry);
		countrySelectDropDown.selectByVisibleText(countryName);
		goButton.click();
		
		return PolytechPageFactory.initElements(webDriver, BestBuyHomePage.class);
	}
	
	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(selectCountry);
	}

}