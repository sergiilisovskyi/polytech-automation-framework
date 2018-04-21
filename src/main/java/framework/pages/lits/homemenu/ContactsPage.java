package framework.pages.lits.homemenu;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;

import com.google.common.base.Function;

import framework.pages.Page;
import framework.utility.LogFactory;
import io.qameta.allure.Step;

public class ContactsPage extends Page {
	
	private static final Logger LOG = LogFactory.getLogger(ContactsPage.class);
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'cities_tabs')]//a")
	private List<WebElement> contactsCitiesList;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'sort_menu_item_dropdown_button_padding')])[1]")
	private WebElement telephoneNumberCode;

	public ContactsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Checking whether telephone number code is displayed")
	public boolean isTelephoneNumberCodeDisplayed() {
		return telephoneNumberCode.isDisplayed();
	}
	
	@Step("Checking contacts list qunatity is correct")
	public boolean isContactsListQuanityCorrect() {
		LOG.info("Checking contacts quantity is correct");
		return contactsCitiesList.size() == 6;
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(telephoneNumberCode);
	}

}
