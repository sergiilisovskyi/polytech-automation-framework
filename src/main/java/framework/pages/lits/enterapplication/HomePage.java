package framework.pages.lits.enterapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.google.common.base.Function;

import framework.pages.LitsPageFactory;
import framework.pages.Page;
import framework.pages.lits.homemenu.ContactsPage;
import framework.utility.LogFactory;
import io.qameta.allure.Step;

public class HomePage extends Page {
	
	private static final Logger LOG = LogFactory.getLogger(HomePage.class);

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'became_student_button') and contains(@class,'row')]")
	private WebElement newsButton;

	@FindBy(how = How.XPATH, using = "//div[@id='became_student']//a[contains(@class,'became_student_button')]")
	private WebElement becomeStudentButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'hide_mobile')]//a[contains(@href,'/cities')]")
	private WebElement contactsMenuButton;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(@class,'dropdownMenu_right_button')])[1]")
	private WebElement coursesMenuButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='menu_schools']")
	private WebElement schools;
	
	@FindBy(how = How.XPATH, using = "//div[@id='menu_courses']")
	private WebElement courses;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Checking news button is displayed")
	public boolean isNewsButtonDisplayed() {
		LOG.info("Checking news button is displayed");
		return newsButton.isDisplayed();
	}

	@Step("Clicking on become student button")
	public BecomeStudentPage clickOnBecomeStudent() {
		jsClickOnElement(becomeStudentButton);
		return LitsPageFactory.initElements(webDriver, BecomeStudentPage.class);
	}
	
	@Step("Openinig contacts menu")
	public ContactsPage openContactsMenu() {
		jsClickOnElement(contactsMenuButton);
		return LitsPageFactory.initElements(webDriver, ContactsPage.class);
	}
	
	@Step("Openinig schoolname by name: {schoolName} and course name by name: {expectedPageClazz}")
	public <T extends Page> T openCourse(String schoolName, String course, Class<T> expectedPageClazz) {
		coursesMenuButton.click();
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.visibilityOf(schools));
		schools.findElement(By.xpath(".//ul//a[contains(text(),'" + schoolName + "')]")).click();
		wait.until(ExpectedConditions.visibilityOf(courses));
		courses.findElement(By.xpath(".//ul//a[contains(text(),'" + course + "')]")).click();
		
		return LitsPageFactory.initElements(webDriver, expectedPageClazz);
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(newsButton);
	}

}