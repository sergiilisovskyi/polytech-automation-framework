package framework.pages.autoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Function;

import framework.pages.Page;
import io.qameta.allure.Step;

public class AutoRiaSearchResultsPage extends Page {
	
	@FindBy(xpath = ".//*[@id='searchResults']//*[contains(@class,'ticket-item')]")
	private List<WebElement> carsSearchResultList;

	public AutoRiaSearchResultsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Advanced search button click")
	public int getSearchItemPriceByIndex(int searchResultIndex) {
		//int price = 0;
		String text = carsSearchResultList
			.get(searchResultIndex)
			.findElement(By.xpath("(//span[@data-currency])[1] | (//span[contains(@class, 'green')])[1]")).getText();
		text = text.replaceAll(" ", "").replaceAll("грн", "");
		return Integer.valueOf(text);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> !carsSearchResultList.isEmpty();
	}
}
