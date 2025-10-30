package testCases.Settings;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProviders.SettingTestCaseDataProvider;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC033 extends BaseClass {

    @Test(dataProvider = "tc033", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserCanCreateCustomFieldInTestSteps(String fieldName, String dataType)
            throws InterruptedException {

        logger.info(
                "****** Starting TC033 : Verify that user is able to create a Custom Field inside Test Steps Tab ******");

        try {

            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTabPage = new GlobalTabPage(getDriver());
            globalTabPage.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            OtherTabPage otherTabPage = new OtherTabPage(getDriver());
            otherTabPage.clickTestStep();
            logger.info("Clicked on Test Steps tab from the left panel");

            boolean isPageDisplayed = otherTabPage.isTestStepsPageDisplayed();
            Assert.assertTrue(isPageDisplayed, "Test Steps page did not open correctly — expected element not found.");
            logger.info("Test Steps page opened successfully");

            otherTabPage.clickOnAddCustomField();
            logger.info("Clicked on Add Custom Field button");

            otherTabPage.createCustomEnterFieldName(fieldName);
            logger.info("Entered Custom Field Name: " + fieldName);

            otherTabPage.createCustomSelectDataType(dataType);
            logger.info("Selected Field Data Type: " + dataType);

            otherTabPage.clickcreatefieldButton();
            logger.info("Clicked on Create Field button");

            boolean isFieldPresent = otherTabPage.isCustomFieldPresent(fieldName);
            Assert.assertTrue(isFieldPresent, "Custom Field not found after creation — creation may have failed.");
            logger.info("Custom Field created successfully and displayed in the list/grid under Test Steps tab.");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }

        logger.info("************ Test Case TC033 Finished *************************");
    }
}
