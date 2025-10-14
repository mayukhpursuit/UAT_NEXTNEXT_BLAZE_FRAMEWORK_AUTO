package testCases.ExecuteTestCaseTab;

import DataProviders.ExecuteTestCaseDataProvider;
import DataProviders.TestPlanDataProvider;
import org.apache.commons.codec.binary.Base16;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.executeTestCaseTab.ExecuteLandingPage;
import pageObjects.testPlanTab.TestPlanLandingPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC001 extends BaseClass {
    @Test(dataProvider = "tc001", dataProviderClass = ExecuteTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void verifyProjectSelectionFromDropdown(String projectName,
                                                   String releaseName) throws InterruptedException {
        logger.info("****** Starting Test Case: Verify Project Selection from Dropdown *****************");
        try {
            login();
            logger.info("Logged in successfully");
            ExecuteLandingPage executeLandingPage =new ExecuteLandingPage(getDriver());
            executeLandingPage.clickExecuteTab();
            logger.info("Clicked on the execute test case tab ..");


        } catch (AssertionError e) {
            logger.error("Assertion failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage());
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}
