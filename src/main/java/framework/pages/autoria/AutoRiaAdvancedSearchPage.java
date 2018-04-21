package framework.pages.autoria;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class AutoRiaAdvancedSearchPage extends Page {

	@FindBy(xpath = "//*[@id='brandAutoComplete']")
	private WebElement searchCarByBrandTextField;
	
	@FindBy(xpath = "//*[@id='brandContainer']//li[not(contains(@class, 'hide'))]/label")
	private List<WebElement> searchCarByBrandResultList;
	
	@FindBy(xpath = "//*[@id='modelContainer']//li[not(contains(@class, 'hide'))]/label")
	private List<WebElement> searchCarByModelResultList;
	
	@FindBy(xpath = ".//*[@id='results']//a[@href and contains(@class, 'button')]")
	private WebElement showResultsButton;

	public AutoRiaAdvancedSearchPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Search car by brand name: {carBrandName} and car model name: {carModelName}")
	public AutoRiaSearchResultsPage searchCarByBrandNameAndModelName(String carBrandName, String carModelName) {
		searchCarByBrandTextField.sendKeys(carBrandName);
		//getWebDriverWait(3).until(wait -> !searchCarByBrandResultList.isEmpty());
		if (searchCarByBrandResultList.isEmpty()) {
			throw new IllegalArgumentException(carBrandName + " is absent on auto ria");
		}
		searchCarByBrandResultList.get(0).click();
		//getWebDriverWait(3).until(wait -> !searchCarByModelResultList.isEmpty());
		if (searchCarByModelResultList.isEmpty()) {
			throw new IllegalArgumentException(carModelName + " is absent on auto ria");
		}
		
		searchCarByModelResultList.stream().filter(car -> car.getText().contains(carModelName)).findFirst().get().click();
		showResultsButton.click();
		
		return LitsPageFactory.initElements(webDriver, AutoRiaSearchResultsPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(searchCarByBrandTextField);
	}
}
