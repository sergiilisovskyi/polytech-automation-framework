package framework.pages.polytech.schoolcourses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;

import framework.pages.Page;
import io.qameta.allure.Step;

public class JavaCoursePage extends Page {
	
	@FindBy(how = How.XPATH, using = "//h1[contains(@class,'page_title')]")
	private WebElement header;

	public JavaCoursePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@Step("Checking whether Web UI page header is correct")
	public boolean isHeaderCorrect() {
		return header.getText().contains("Java Professional");
	}

	@Override
	public Function<WebDriver, ?> isPageLoaded() {
		return ExpectedConditions.visibilityOf(header);
	}
}
