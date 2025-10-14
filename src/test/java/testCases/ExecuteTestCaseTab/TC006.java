package testCases.ExecuteTestCaseTab;

import DataProviders.ExecuteTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.executeTestCaseTab.ExecuteLandingPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC006 extends BaseClass {
    @Test(dataProvider = "tc006", dataProviderClass = ExecuteTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void verifythesearchfeature(
            String projectName,
            String ReleaseName,
            String CycleName,
            String SuiteName

    ) throws InterruptedException {
        logger.info("****** Starting Test Case: verify the search feature *****************");
        try {
            login();
            logger.info("Logged in successfully");
            ExecuteLandingPage executeLandingPage =new ExecuteLandingPage(getDriver());
            executeLandingPage.clickExecuteTab();
            logger.info("Clicked on the execute test case tab ..");

            executeLandingPage.clickArrowRightPointingForExpandModule(projectName);
            logger.info("Clicked on Project:"+projectName);

            executeLandingPage.expandRelease(ReleaseName);
            logger.info("Clicked on Release:"+ReleaseName);

            executeLandingPage.expandSubTestCycle(CycleName);
            logger.info("Clicked on Cycle:"+CycleName);

            executeLandingPage.clickOnSuite(SuiteName);
            logger.info("Clicked on Suite:"+SuiteName);




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
