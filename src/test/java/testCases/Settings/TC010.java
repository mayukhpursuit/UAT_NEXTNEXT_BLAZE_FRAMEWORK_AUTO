
package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC010 extends BaseClass
{
    @Test(dataProvider = "tc010", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserIsAbleToCreateADefaultValue(
            String fieldName,
            String value
    ) throws InterruptedException
    {

        logger.info("****** Starting the TC010***************");

        try {
            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickModule();
                    logger.info("Navigated to Module tab");

            Thread.sleep(3000);
            otherTab.clickEdit(fieldName);
            logger.info("clicked on edit row:"+fieldName);

            otherTab.clickDefaultAddValue() ;
            logger.info("clicked on adddefaultvalue");

            otherTab.enterDefaultValue(value);
            logger.info("entered default value"+value);

            otherTab.clickDefaultSaveChanges();
            logger.info("clicked on save changes");

            logger.info("Now delete the added default field value");

            otherTab.clickEdit(fieldName);
            logger.info("Clicked on edit field");

            otherTab.clickDefaultDeleteIcon();
            logger.info("Click on delete button");

            otherTab.clickYesDefaultValueDelete();
            logger.info("Successfully deleted the Default value after adding it");

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
