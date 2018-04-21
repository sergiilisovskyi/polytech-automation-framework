package framework.pages.myhit;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class MyhitMoviePage extends Page {
	
	@FindBy(xpath = "(//div[contains(@class,'row metrika')]/following-sibling::h3)[1]")
	private WebElement actorsLabel;
	
	@FindBy(xpath = "//*[@itemprop='director']/preceding-sibling::a")
	private WebElement directorLink;
	
	@FindBy(xpath = "//a/img[@title and @alt]")
	private List<WebElement> actorsList;

	public MyhitMoviePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Clicking on actor by index: {index}")
	public MyhitActorPage clickActorByIndex(int index) {
		scrollToElement(actorsLabel);
		
		if (!actorsList.isEmpty()) {
			if (actorsList.size() <= index) {
				throw new IllegalArgumentException("There is no actor in actors list with index " + index);
			}
			actorsList.get(index).click();
			
			return LitsPageFactory.initElements(webDriver, MyhitActorPage.class);
		} else throw new IllegalStateException("Actors list is empty");
	}

	@Step("Click on director")
	public MyhitDirectorPage clickOnDirector() {
		directorLink.click();
		return LitsPageFactory.initElements(webDriver, MyhitDirectorPage.class);
	}
	
	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(actorsLabel);
	}
	

}
