package framework.lits.menuhometests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.lits.testcase.TestBaseLits;
import framework.pages.polytech.homemenu.ContactsPage;

public class ContactHomeMenuTestSuite extends TestBaseLits {

	@Test
	public void checkCitiesListTest() {
		ContactsPage contactsPage = homePage.openContactsMenu();
		
		Assert.assertTrue(contactsPage.isContactsListQuanityCorrect(), "Contacts cities list size is incorrect");
		Assert.assertTrue(contactsPage.isTelephoneNumberCodeDisplayed(), "Telephone is not displayed");
	}

}