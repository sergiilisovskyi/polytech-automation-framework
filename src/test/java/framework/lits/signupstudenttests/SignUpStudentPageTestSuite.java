package framework.lits.signupstudenttests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.lits.testcase.TestBaseLits;
import framework.pages.polytech.enterapplication.BecomeStudentPage;
import framework.pages.polytech.homemenu.ContactsPage;

public class SignUpStudentPageTestSuite extends TestBaseLits {

	@Test
	public void enterSignUpStudentPageView() {
		BecomeStudentPage becomeStudentPage = homePage.clickOnBecomeStudent();
		becomeStudentPage.clickOnSubmit();
		
		Assert.assertTrue(becomeStudentPage.isErrorOnSubmitIsDisplayed());
		
		ContactsPage contactsPage = homePage.openContactsMenu();
		Assert.assertTrue(contactsPage.isTelephoneNumberCodeDisplayed(), 
				"Telephone not displayed");
	}

	
	@Test
	public void closeSignUpStudentPageView() {
		BecomeStudentPage becomeStudentPage = homePage.clickOnBecomeStudent();
		becomeStudentPage.closeSignUpPage();
		
		Assert.assertTrue(becomeStudentPage.isSignUpBlockIsNotDisplayed(),
				"Become student not displayed");
	}

}
