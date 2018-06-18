package framework.pages.rozetka;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.PolytechPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class RozetkaSearchResultsPage extends Page {
	
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'sort-view-link')]")
	private WebElement filterLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='block_with_search' or @id='catalog_goods_block']"
			+ "//a[contains(@onclick,'goodsTitleClick')]")
	private List<WebElement> searchResultItemsList;

	public RozetkaSearchResultsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Open product by index: {index}")
	public RozetkaItemPage openProduct(int index) {
		if (!searchResultItemsList.isEmpty()) {
			if (searchResultItemsList.size() <= index) {
				throw new IllegalArgumentException("Invalid index was passed");
			}
			
			searchResultItemsList.get(index).click();
			
			return PolytechPageFactory.initElements(webDriver, RozetkaItemPage.class);
		} else throw new IllegalStateException("Search result is empty");
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(filterLabel);
	}
}
