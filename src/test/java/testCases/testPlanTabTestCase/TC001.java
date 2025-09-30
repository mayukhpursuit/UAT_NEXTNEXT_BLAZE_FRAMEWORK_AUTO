package testCases.testPlanTabTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.testPlanTab.TestPlanLandingPage;
import testBase.BaseClass;

public class TC001 extends BaseClass {
    @Test
    public void verifyProjectDropdownVisibility() throws InterruptedException {
        logger.info("****** Starting Test Case: Verify Project Dropdown Visibility *****************");
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

            String transform = getDriver().findElement(org.openqa.selenium.By.xpath(
                    "//div[contains(@class,'project') and contains(.,'STG- PulseCodeOnAzureCloud')]//i[contains(@class,'toggle-icon')]"))
                    .getAttribute("style");

            Assert.assertTrue(transform.contains("90deg"), "Project dropdown is not expanded/visible!");
            logger.info("Project dropdown is visible and expanded successfully");

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
