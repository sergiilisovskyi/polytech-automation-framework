package framework.rozetka.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.rozetka.RozetkaCartPage;
import framework.rozetka.testcase.TestBaseRozetka;

public class RozetkaSearchTestSuite extends TestBaseRozetka {

	@Test
	public void sasmusngSearchTest() {
		RozetkaCartPage rozetkaCartPage = rozetkaHomePage
				.searchProduct("Samsung Galaxy")
				.openProduct(0)
				.buyProduct();
		
		Assert.assertTrue(rozetkaCartPage.getTotalPrice() > 15000);
	}

}
