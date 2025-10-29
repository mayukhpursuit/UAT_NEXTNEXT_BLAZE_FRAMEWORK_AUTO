package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;

public class TC029 extends BaseClass {
    @Test(dataProvider = "tc029", dataProviderClass = SettingTestCaseDataProvider.class)
    public void Verify_that_user_is_able_to_create_a_Custom_Field_inside_Module_Tab(
            String fieldName1,
            String fieldType,String fieldName2
    ) throws InterruptedException {

        logger.info("****** Starting the TC009: Verify that user is able to create a Custom Field inside Module Tab *****************");

        try {
            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickTestCase();
            logger.info("Navigated to Module tab");

            otherTab.clickOnAddCustomField();
            logger.info("Clicked on Add Custom Field button");

            otherTab.createCustomEnterFieldName(fieldName1);
            logger.info("Entered Custom Field Name: " + fieldName1);

            otherTab.createCustomSelectDataType(fieldType);
            logger.info("Selected Custom Field Type: " + fieldType);

            otherTab.clickcreatefieldButton();
            logger.info("clicked on create field button#");

            otherTab.clickOnDelete(fieldName2);
            logger.info("Clicked Delete icon for the field: " + fieldName2);


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
