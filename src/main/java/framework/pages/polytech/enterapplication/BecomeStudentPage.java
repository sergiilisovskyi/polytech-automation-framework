package framework.pages.polytech.enterapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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

public class BecomeStudentPage extends Page {
	
	private static final Logger LOG = LogFactory.getLogger(BecomeStudentPage.class);

	@FindBy(how = How.XPATH, using = "//form[@id='became_student_form']")
	private WebElement signUpForm;

	public BecomeStudentPage(WebDriver webDriver) {
		super(webDriver);
	}

	@Step("Click on submit button")
	public void clickOnSubmit() {
		jsClickOnElement(signUpForm.findElement(By.xpath(".//button[@id='became_student_form_submit']")));
	}
	
	@Step("Check whether error is displayed on submit")
	public boolean isErrorOnSubmitIsDisplayed() {
		LOG.info("Checking whether error is displayed");
		try {
			getWebDriverWait(5).until(ExpectedConditions.visibilityOf(signUpForm.
					findElement(By.xpath(".//div[contains(@class,'error-summary')]"))));
			return true;
		} catch (TimeoutException e) {
			LOG.error("Timeout exception was cought");
			return false;
		}
	}

	@Step("Closing sign up pop page")
	public void closeSignUpPage() {
		LOG.info("Closing sig up page");
		jsClickOnElement(signUpForm.findElement(By.xpath(".//i[contains(@class,' close_form')]")));
		
		LOG.info("Waiting for sign up to disappear");
		getWebDriverWait(10).until(ExpectedConditions.attributeContains(signUpForm, "style", "none"));
	}
	
	@Step("Checking become student pop up is not displayed")
	public boolean isSignUpBlockIsNotDisplayed() {
		System.out.println(signUpForm.getAttribute("style"));
		return signUpForm.getAttribute("style").contains("display: none");
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(signUpForm);
	}

}
