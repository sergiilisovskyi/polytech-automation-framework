package framework.autoria.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.autoria.testcase.TestBaseAutoRia;
import framework.pages.autoria.AutoRiaSearchResultsPage;

public class AutoRiaSearchTestSuite extends TestBaseAutoRia {

	@Test
	public void autoRiaSearchTest() throws InterruptedException {
		AutoRiaSearchResultsPage autoRiaSearchResultsPage = autoRiaHomePage
				.clickAdvancedSearch()
				.searchCarByBrandNameAndModelName("Bentley", "Continental");
				
		Assert.assertTrue(autoRiaSearchResultsPage.getSearchItemPriceByIndex(1) > 50000);
	}

}