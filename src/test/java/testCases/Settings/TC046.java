package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC046 extends BaseClass {
    @Test(dataProvider = "tc040", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void Verify_that_user_is_able_to_add_a_Default_Field_Value_in_the_Release_Tab(
            String fieldName1, String fieldType, String fieldName2,
            String value, String fieldName3
    ) throws InterruptedException {

        logger.info("****** Starting the TC016: Verify that user is able to add a Default Field Value in the Release Tab. *****************");

        try {
            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickTestSuite();
            logger.info("Navigated to release tab");

            otherTab.clickOnAddCustomField();
            logger.info("Clicked on Add Custom Field button");

            otherTab.createCustomEnterFieldName(fieldName1);
            logger.info("Entered Custom Field Name: " + fieldName1);

            otherTab.createCustomSelectDataType(fieldType);
            logger.info("Selected Custom Field Type: " + fieldType);

            otherTab.clickcreatefieldButton();
            logger.info("clicked on create field button#");


            otherTab.clickOnEdit(fieldName2);
            logger.info("clicked on edit row:"+fieldName2);

            otherTab.clickDefaultAddValue() ;
            logger.info("clicked on adddefaultvalue");

            otherTab.enterDefaultValue(value);
            logger.info("entered default value"+value);

            otherTab.clickDefaultSaveChanges();
            logger.info("clicked on save changes");

            otherTab.clickOnDelete(fieldName3);
            logger.info("Clicked Delete icon for the field: " + fieldName3);

            otherTab.clickOnDeleteRowConfirmation();
            logger.info("clicked on yes confirmation");


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
