package framework.myhit.actortest;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.myhit.testcase.TestBaseMyHit;
import framework.pages.myhit.MyhitActorPage;
import framework.pages.myhit.MyhitDirectorPage;
import framework.pages.myhit.MyhitSearchResultPage;

public class MyHitActorTest extends TestBaseMyHit {

	@Test
	public void checkActorNameTest() {
		MyhitActorPage myhitActorPage = myhitHomePage
				.searchForMovie("Terminator")
				.openMovieByIndex(0)
				.clickActorByIndex(0);
		
		Assert.assertTrue(myhitActorPage.getActorsHeader().contains("Arnold Schwarzenegger"));
	}
	
	@Test
	public void checkDirectorMoviesQuantityTest() {
		MyhitSearchResultPage myhitSearchResultPage = myhitHomePage.searchForMovie("Terminator");
		
		MyhitDirectorPage myhitDirectorPage = myhitSearchResultPage
				.openMovieByIndex(1).clickOnDirector();
		
		Assert.assertTrue(myhitDirectorPage.getDirectorMoviesQuantity() > 10, "Directors movies quantity is incorrect");
	}
}