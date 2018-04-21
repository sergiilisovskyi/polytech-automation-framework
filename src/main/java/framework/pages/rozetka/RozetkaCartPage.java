package framework.pages.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;
import io.qameta.allure.Step;

public class RozetkaCartPage extends Page {
	
	@FindBy(how = How.XPATH, using = "//span[@name='cost']")
	private WebElement totalCostLabel;

	public RozetkaCartPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Getting total price")
	public int getTotalPrice() {
		return Integer.valueOf(totalCostLabel.getText().replaceAll(" ", ""));
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(totalCostLabel);
	}
}
