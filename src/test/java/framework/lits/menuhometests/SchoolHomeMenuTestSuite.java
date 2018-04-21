package framework.lits.menuhometests;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.lits.testcase.TestBaseLits;
import framework.pages.lits.schoolcourses.JavaCoursePage;

public class SchoolHomeMenuTestSuite extends TestBaseLits {

	@Test
	public void checkManualQAPageHeaderTest() {
		JavaCoursePage manualQATestingPage = homePage.openCourse("Code School", "Java Professional",
				JavaCoursePage.class);
		
		Assert.assertFalse(manualQATestingPage.isHeaderCorrect(), 
				"Manual QA Testing Course page was not opened");
	}

}