package framework.pages.myhit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;
import io.qameta.allure.Step;

public class MyhitActorPage extends Page {
	
	//TODO remove @itemprop
	@FindBy(xpath = "//h1/following-sibling::h4[not(@itemprop)]")
	private WebElement actorHeader;

	public MyhitActorPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Get actors header")
	public String getActorsHeader() {
		return actorHeader.getText();
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(actorHeader);
	}
	
}
