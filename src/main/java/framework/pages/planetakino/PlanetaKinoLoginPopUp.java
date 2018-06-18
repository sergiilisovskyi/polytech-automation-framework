package framework.pages.planetakino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.PolytechPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class PlanetaKinoLoginPopUp extends Page {

	@FindBy(xpath = "//input[@id='login']")
	private WebElement phoneTextField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinButton;
	
	public PlanetaKinoLoginPopUp(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Login to Planeta Kino with credentials: {login} / ******")
	public PlanetaKinoCartPage loginToPlanetaKino(String login, String password) {
		phoneTextField.clear();
		phoneTextField.sendKeys(login);
		passwordTextField.sendKeys(password);
		signinButton.click();
		
		return PolytechPageFactory.initElements(webDriver, PlanetaKinoCartPage.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(phoneTextField);
	}
	
}