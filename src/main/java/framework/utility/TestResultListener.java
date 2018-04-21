package framework.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import framework.webdriver.WebDriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestResultListener extends TestListenerAdapter {

	private static final Logger LOG = LogFactory.getLogger(TestResultListener.class);

	/**
	 * Prints the test results to report.
	 * 
	 * @param result
	 *            the result
	 */
	private void printTestResults(ITestResult result) {
		if (result.getParameters().length != 0) {
			String params = null;
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ",";
			}
			LOG.info("Output params: " + params);
		}

		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
			break;
		}

		LOG.info("Test status is: " + status);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		printTestResults(arg0);
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		printTestResults(arg0);
		LOG.info("Taking screenshot for failed test");
		testScreenshotOnFinish();
	}

	@Step("Screenshot on failed test")
	public void testScreenshotOnFinish() {
		Allure.addAttachment("Screenshot on failure", "image/png", getScreenshotByteIS(WebDriverFactory.getSetDriver()), "png");
	}
	
	private static InputStream getScreenshotByteIS(WebDriver driver) {
		Screenshot screenImage = new AShot()
						  .shootingStrategy(ShootingStrategies.viewportPasting(150))
						  .takeScreenshot(driver);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
        		ImageIO.write(screenImage.getImage(), "png", baos);
        } catch (IOException e) {
             e.printStackTrace();
        }
           
        return new ByteArrayInputStream(new ByteArrayOutputStream().toByteArray());
    }

}
