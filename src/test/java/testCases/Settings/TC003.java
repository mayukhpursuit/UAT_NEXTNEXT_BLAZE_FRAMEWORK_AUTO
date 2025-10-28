package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;
import org.testng.Assert;

public class TC003 extends BaseClass {

    @Test(dataProvider = "TC003", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyAddDefaultFieldValueInGlobalSettings(String fieldName,
            String textBox,
            String objType1,
            String objType2,
            String defaultFieldValue,
            String expectedMessage)
            throws InterruptedException {

        logger.info(
                "****** Starting the TC003 : Verify that user is able to add a Default Field Value in the Global Field Setting. ******");

        try {

            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickGlobalFieldSetting();
            logger.info("Navigated to Global Field Settings section");

            globalTab.clickonAddGlobalField();
            logger.info("Clicked on Add Global Field button");

            globalTab.EnterFieldName(fieldName);
            logger.info("Entered Field Name: " + fieldName);

            globalTab.SelectDataType(textBox);
            logger.info("Selected Data Type as: " + textBox);

            globalTab.clickObjectTypeCheckbox(objType1);
            logger.info("Selected Object Type: " + objType1);

            globalTab.clickObjectTypeCheckbox(objType2);
            logger.info("Selected Object Type: " + objType2);

            globalTab.clickSaveButton();
            logger.info("Clicked on Save button to add global field");

            globalTab.clickonEdit(fieldName);
            logger.info("Clicked on Edit icon for field: " + fieldName);

            globalTab.clickAddFieldButton();
            logger.info("Clicked on Add Field Value button");

            globalTab.enterFieldValue(defaultFieldValue);
            logger.info("Entered Default Field Value: " + defaultFieldValue);

            globalTab.clickonSaveButton();
            logger.info("Clicked on Save button to save Default Field Value");

            Assert.assertTrue(globalTab.verifySuccessNotification(expectedMessage),
                    "Default Field Value not added successfully");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }

        logger.info("************ Test Case TC003 Finished Successfully *************************");
    }
}
