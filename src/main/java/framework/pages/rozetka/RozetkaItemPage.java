package framework.pages.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.PolytechPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class RozetkaItemPage extends Page {
	
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'detail-buy-btn-container')]//button")
	private WebElement buyButton;

	public RozetkaItemPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Buy a product")
	public RozetkaCartPage buyProduct() {
		buyButton.click();

		return PolytechPageFactory.initElements(webDriver, RozetkaCartPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(buyButton);
	}
}
