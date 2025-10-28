package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;
import org.testng.Assert;

public class TC004 extends BaseClass {

    @Test(dataProvider = "tc004", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyAccessAndConfigureFieldSettings(String fieldName, String expectedPageTitle)
            throws InterruptedException {

        logger.info(
                "****** Starting the TC004 : Verify that user can access and configure field settings using the Settings button ******");

        try {

            login();
            logger.info("User logged in successfully with valid credentials");

            logger.info(
                    "Dashboard loaded successfully with navigation options visible (Author TestCases, Execute Test Case, Requirement, Test Plan, Settings)");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on dropdown at the top-right corner and selected 'Settings' option");

            otherTab.clickGlobalFieldSetting();
            logger.info("Navigated to 'Global Field Settings' page successfully");

            globalTab.clickonSettings(fieldName);
            logger.info("Clicked on the Settings (gear) icon for the global custom field: " + fieldName);

            boolean pageLoaded = globalTab.verifyManageObjectTypesDashboard(expectedPageTitle);
            Assert.assertTrue(pageLoaded, "Manage Object Types - Description dashboard did not load as expected");
            logger.info("Verified that 'Manage Object Types - Description' dashboard loaded successfully");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred during TC004 execution: " + e.getMessage());
            throw e;
        }

        logger.info("************ Test Case TC004 Finished Successfully *************************");
    }

}
