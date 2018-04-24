package framework.pages.planetakino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;

public class PlanetaKinoSeatSelectionPage extends Page {

	@FindBy(xpath = "//*[contains(@class, 'hall-scheme__hall')]")
	private WebElement hall;
	
	@FindBy(xpath = "(//*[contains(@class, 'hall-scheme__hall')]//div[contains(@class, 'hall__seat') and not(contains(@class, 'sold')) and not(contains(@class, 'taken'))])[1]")
	private WebElement firstAvailableSeat;
	
	@FindBy(xpath = "(//button[contains(@class, 'add-to-cart')])[last()]")
	private WebElement addToCartButton;
	
	public PlanetaKinoSeatSelectionPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Select first availables tream tomorrow")
	public PlanetaKinoLoginPopUp selectFirstAvailableSeat() {
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		jsClickOnElement(firstAvailableSeat);
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		getWebDriverWait(5).until(wait -> addToCartButton.isEnabled());
		jsClickOnElement(addToCartButton);
		
		return LitsPageFactory.initElements(webDriver, PlanetaKinoLoginPopUp.class);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return wait -> hall.isEnabled();
	}
	
}