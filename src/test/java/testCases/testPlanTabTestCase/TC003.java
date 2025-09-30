package testCases.testPlanTabTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.testPlanTab.TestPlanLandingPage;
import testBase.BaseClass;
import java.util.List;
import java.util.Arrays;

public class TC003 extends BaseClass {

    @Test
    public void verifyListingOfAllConfiguredProjects() throws InterruptedException {
        logger.info("****** Starting Test Case: Verify Listing of All Configured Projects *****************");
        try {
            login();
            logger.info("Logged in successfully");

            TestPlanLandingPage testPlanPage = new TestPlanLandingPage(getDriver());
            testPlanPage.selectTestPlanTab();
            logger.info("Navigated to Test Plan tab");

            testPlanPage.expandSidebarIfCollapsed();
            logger.info("Sidebar expanded if it was collapsed");

            testPlanPage.expandProjectSTG("STG- PulseCodeOnAzureCloud");
            logger.info("Expanded the project dropdown");

            List<String> actualProjects = testPlanPage.getAllProjectNames();
            logger.info("Projects listed in dropdown: " + actualProjects);

            List<String> expectedProjects = Arrays.asList(
                    "SET- DRV",
                    "New Release 3-9-2025",
                    "New Release 3 September",
                    "Release 039",
                    "New Releasessss",
                    "New Release 11",
                    "Mayukh_Release",
                    "New Release 123",
                    "New Release 10-9-2025",
                    "New Release 10-9-2025",
                    "New Release 12-09-2025");

            Assert.assertEquals(actualProjects, expectedProjects,
                    "Project list in dropdown does not match expected configuration!");
            logger.info("Verified all configured projects are listed in expected order");

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
