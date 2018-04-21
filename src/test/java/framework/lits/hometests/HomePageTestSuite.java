package framework.lits.hometests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.lits.testcase.TestBaseLits;



public class HomePageTestSuite extends TestBaseLits {

	@Test
	// TS 2.1
	public void enterHomePageView() {
		Assert.assertTrue(homePage.isNewsButtonDisplayed(), "News button is not displayed");
	}

}
