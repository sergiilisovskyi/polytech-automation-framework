package framework.planetakino.buytickets;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.planetakino.PlanetaKinoPaymentPage;
import framework.pages.planetakino.PlanetaKinoCartPage;
import framework.pages.planetakino.PlanetaKinoLoginPopUp;
import framework.planetakino.testcase.TestBasePlanetaKino;

public class PlanetaKinoBuyTicketsTest extends TestBasePlanetaKino {

	@Test
	public void buyTicketsTest() {
		PlanetaKinoLoginPopUp planetaKinoLoginPopUp = planetaKinoHomePage
				.clickOnMovieByIndex(2)
				.selectFirstAvailableStreamTomorrow()
				.selectFirstAvailableSeat();
		
		PlanetaKinoCartPage planetaKinoCartPage = planetaKinoLoginPopUp.loginToPlanetaKino("", "");
		PlanetaKinoPaymentPage planetaKinoPaymentPage = planetaKinoCartPage.clickPayButton();
		
		Assert.assertTrue(planetaKinoPaymentPage.isPlatonPaymentSystemAvailable());
	}
	
}