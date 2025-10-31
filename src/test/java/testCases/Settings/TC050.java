package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC050 extends BaseClass {

    @Test(dataProvider = "tc050", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserCanAccessSettingsAndNavigateToTestRunsTab(String expectedTabName)
            throws InterruptedException {

        logger.info("****** Starting TC050: Verify user can access Settings and navigate to Test Runs tab ******");

        try {

            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickGlobalFieldSetting();
            logger.info("Navigated to Global Field Settings section");

            otherTab.clickTestRuns();
            logger.info("Clicked on Test Runs tab in left panel.");

            boolean isTestRunsVisible = otherTab.isTestRunsTabVisible(expectedTabName);
            Assert.assertTrue(isTestRunsVisible, "Test Runs tab did not open successfully.");
            logger.info("User successfully navigated to the Test Runs tab.");

            logger.info("****** TC050 PASSED: User can access Settings and navigate to Test Runs tab ******");
        } catch (AssertionError e) {
            logger.error("Assertion failed in TC050: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred in TC050: " + e.getMessage(), e);
            throw e;
        }

        logger.info("************ TC050 Finished *************************");
    }
}
