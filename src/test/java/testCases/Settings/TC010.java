package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC010 extends BaseClass {
    @Test(dataProvider = "TC009", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void Verify_that_user_is_able_to_create_a_Custom_Field_inside_Module_Tab(
            String fieldName,
            String value
    ) throws InterruptedException {

        logger.info("****** Starting the TC010: Verify that user is able to create a Custom Field inside Module Tab *****************");

        try {
            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickModule();
            logger.info("Navigated to Module tab");


            otherTab.clickOnEdit(fieldName);
            logger.info("clicked on edit row:"+fieldName);

            otherTab.clickDefaultAddValue() ;
            logger.info("clicked on adddefaultvalue");

            otherTab.enterDefaultValue(value);
            logger.info("entered default value"+value);

            otherTab.clickOnSaveChanges();
            logger.info("clicked on save changes");


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
