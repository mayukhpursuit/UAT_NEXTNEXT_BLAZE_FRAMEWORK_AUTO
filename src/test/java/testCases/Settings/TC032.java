package testCases.Settings;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC032 extends BaseClass {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserCanAccessSettingsAndOpenTestStepsTab() throws InterruptedException {

        logger.info("****** Starting TC032 : Verify that user can access Settings and open Test Steps tab ******");

        try {

            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickTestStep();
            logger.info("Clicked on Test Steps tab from the left panel");

            boolean isTestStepPageVisible = otherTab.isTestStepsPageDisplayed();

            Assert.assertTrue(isTestStepPageVisible,
                    "Test Steps page did not open correctly — expected element not found.");

            logger.info("User successfully navigated to the Test Steps page");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }

        logger.info("************ Test Case TC032 Finished *************************");
    }
}
