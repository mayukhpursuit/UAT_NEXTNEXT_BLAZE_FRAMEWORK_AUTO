package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC028 extends BaseClass {
    @Test(dataProvider = "tc028", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void VerifythatuserisabletoaddaDefaultFieldValueintheTestCaseTab(
            String fieldrow,
            String fieldName
    ) throws InterruptedException
    {

        logger.info("****** Starting the TC028:Verify that user is able to add a Default Field Value in the Test Case Tab.***************");

        try {
            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            Thread.sleep(3000);

            otherTab.clickTestCase();
            logger.info("Navigated to Test cases tab");


            otherTab.clickOnEdit(fieldrow);
            logger.info("Clicked on edit field button:"+fieldrow);

            otherTab.clickDefaultAddValue();
            logger.info("Click on add default value");

            otherTab.enterDefaultValue(fieldName);
            logger.info("Entered defualt value: " + fieldName);

            otherTab.clickDefaultSaveChanges();
            logger.info("clicked on default save changes button");

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
