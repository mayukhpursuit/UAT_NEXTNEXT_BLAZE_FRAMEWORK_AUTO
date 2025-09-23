package testCases.testPlanTabTestCase;

import org.testng.annotations.Test;
import pageObjects.testPlanTab.TestPlanPage;
import testBase.BaseClass;

public class TC001 extends BaseClass {

    @Test
    public void verifyTestPlanMenuButtons() throws InterruptedException {
        logger.info("****** Starting the Test Case: Verify TestPlan Menu Buttons *****************");
        try {

            login();
            logger.info("Logged in successfully");

            TestPlanPage testPlanPage = new TestPlanPage(getDriver());

            testPlanPage.selectTestPlanTab();
            logger.info("Selected Test Plan tab");

            testPlanPage.expandSidebarIfCollapsed();
            logger.info("Expanded sidebar if it was collapsed");

            testPlanPage.expandProjectSTG();
            logger.info("Expanded project STG- PulseCodeOnAzureCloud");

            testPlanPage.expandRelease("New Release 3-9-2025");
            logger.info("Expanded Release - New Release 3-9-2025");

            testPlanPage.clickNewRelease();
            logger.info("Clicked on New Release button");

            testPlanPage.clickNewTestCycle();
            logger.info("Clicked on New TestCycle button");

            testPlanPage.clickNewTestSuite();
            logger.info("Clicked on New TestSuite button");

            testPlanPage.clickDelete();
            logger.info("Clicked on Delete button");

            testPlanPage.toggleHamburgerMenu();
            logger.info("Toggled Hamburger Menu");

        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage(), e);
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}
