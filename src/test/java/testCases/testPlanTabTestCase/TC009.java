package testCases.testPlanTabTestCase;

import DataProviders.TestPlanDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.testPlanTab.IndividualTestCyclePage;
import pageObjects.testPlanTab.TestPlanLandingPage;
import testBase.BaseClass;

import java.util.Random;

public class TC009 extends BaseClass {
    @Test(dataProvider = "tc008", dataProviderClass = TestPlanDataProvider.class)
    public void verifyDeletionOfCycle(
            String projectName,
            String releaseName,
            String testCycleName,
            String testDescription
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

            testPlanPage.clickOnReleaseOrTestCycleOrTestSuite(releaseName);
            logger.info("Clicked on the module ");

            testPlanPage.clickNewTestCycle();
            logger.info("Clicked on the new testCycle");

            IndividualTestCyclePage individualTestCyclePage=new IndividualTestCyclePage(getDriver());
            individualTestCyclePage.setTestCycleName(testCycleName+String.valueOf((100 + new Random().nextInt(900))));
            logger.info("added the test cycle name");

            individualTestCyclePage.setDescription(testDescription);
            logger.info("added the description for cycle");

            Assert.assertEquals(individualTestCyclePage.getTargetRelease(),releaseName);
            logger.info("verified the targeted release ");

            individualTestCyclePage.clickSave();
            logger.info("Clicked on the save button");

            testPlanPage.clickOnReleaseOrTestCycleOrTestSuite(testCycleName+"1");
            logger.info("navigated to the created cycle");

            testPlanPage.clickDelete();
            logger.info("Clicked on the delete button");

            testPlanPage.clickOnConfirmDeleteYes(testCycleName+"1");
            logger.info("Deleted the module successfully");



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
