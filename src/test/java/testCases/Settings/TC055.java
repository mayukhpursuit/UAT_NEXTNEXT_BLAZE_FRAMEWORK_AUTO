package testCases.Settings;

import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;

public class TC055 extends BaseClass {
    @Test
    public void verify_SelectAll_And_ClearAllButton_ClickableOn_TestRun()throws InterruptedException {
        logger.info("****** Starting Test Case: Verify Project Selection from Dropdown *****************");
        try {
            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());


            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickTestRuns();
            logger.info("Navigated to TestRun section");

            globalTab.clickonSelectAll();
            logger.info("Clicked on selectAll Button");

            globalTab.clickonClearAll();
            logger.info("Clicked on ClearAll Button");
            logger.info("Successfully Completed the testcase");


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
