package testCases.Settings;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataProviders.SettingTestCaseDataProvider;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC057 extends BaseClass {

    @Test(dataProvider = "tc057", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserCanCreateCustomFieldInDefectTab(String customFieldName, String dataType)
            throws InterruptedException {
        logger.info(
                "****** Starting the TC057 : Verify that user is able to create a Custom Field inside Defect Tab ******");

        try {

            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTabPage = new GlobalTabPage(getDriver());
            OtherTabPage otherTabPage = new OtherTabPage(getDriver());

            globalTabPage.clickCurrentUserAndGoToSettings();
            logger.info("Navigated to Settings page");

            otherTabPage.clickDefect();
            logger.info("Navigated to Defect Tab");

            otherTabPage.clickOnAddCustomField();
            logger.info("Clicked on 'Add Custom Field' button");

            otherTabPage.createCustomEnterFieldName(customFieldName);
            logger.info("Entered custom field name: " + customFieldName);

            otherTabPage.createCustomSelectDataType(dataType);
            logger.info("Selected data type: " + dataType);

            otherTabPage.clickcreatefieldButton();
            logger.info("Clicked on 'Create Field' button");

            boolean isFieldCreated = otherTabPage.isCustomFieldPresent(customFieldName);
            Assert.assertTrue(isFieldCreated, "Custom field was not created successfully!");
            logger.info("Verified that custom field is created successfully: " + customFieldName);
        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }

        logger.info(
                "****** Finished TC057: Verify that user is able to create a Custom Field inside Defect Tab ******");
    }
}
