package framework.bestbuy.searchtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.bestbuy.testcase.TestBaseBestBuy;

public class BestBuySearchTestSuite extends TestBaseBestBuy {

	@Test
	public void bestBuyTabletSearchTest() {
		int addToCartButtonsQuantity = bestBuyHelloPage
						.selectCountryByName("United States - English")
						.searchForItem("Samsung Tablet").getAddToCartItemsQunatity();
		
		Assert.assertTrue(addToCartButtonsQuantity > 10, "Samsung Tablets quantity is not > 10");
	}

}