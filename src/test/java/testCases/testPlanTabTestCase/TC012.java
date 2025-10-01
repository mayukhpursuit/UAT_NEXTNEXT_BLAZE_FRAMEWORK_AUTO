package testCases.testPlanTabTestCase;

import DataProviders.TestPlanDataProvider;
import org.testng.annotations.Test;
import pageObjects.testPlanTab.TestPlanLandingPage;
import testBase.BaseClass;

public class TC012 extends BaseClass {
    @Test(dataProvider = "tc011", dataProviderClass = TestPlanDataProvider.class)
    public void verifySuitSelectionOpensItsDetailPannel(
            String projectName,
            String release,
            String testCycle,
            String testSuit
    )
            throws InterruptedException {
        logger.info(
                "****** Starting Test Case: Verify Release List Updates Based on Project Selection *****************");
        try {
            login();
            logger.info("Logged in successfully");

            TestPlanLandingPage testPlanPage = new TestPlanLandingPage(getDriver());

            testPlanPage.selectTestPlanTab();
            logger.info("Navigated to Test Plan tab");

            testPlanPage.expandSidebarIfCollapsed();
            logger.info("Sidebar expanded if it was collapsed");

            testPlanPage.expandProjectSTG(projectName);
            logger.info("Expanded STG Project");


            testPlanPage.clickOnReleaseOrTestCycleOrTestSuite(release);
            logger.info("Clicked on the release ");

            testPlanPage.expandRelease(release);

            testPlanPage.clickOnReleaseOrTestCycleOrTestSuite(testCycle);
            logger.info("Clicked on the Test Cycle");

            testPlanPage.expandTestCycle(testCycle);

            testPlanPage.clickOnReleaseOrTestCycleOrTestSuite(testSuit);
            logger.info("Clicked on the Test Suit");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }

        logger.info("************ Test Case Finished *************************");
    }
}

