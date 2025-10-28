package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC006 extends BaseClass {
    @Test(dataProvider = "tc006", dataProviderClass = SettingTestCaseDataProvider.class)
    public void verifyProjectSelectionFromDropdown(String fieldName,
                                                   String textBox,
                                                   String objType1,String objType2,String rowName) throws InterruptedException {
        logger.info("****** Starting Test Case: Verify Project Selection from Dropdown *****************");
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
            logger.info("Selected Data Type as Text Box");

            globalTab.clickObjectTypeCheckbox(objType1);
            logger.info("Selected Object Type: Test Case");

            globalTab.clickObjectTypeCheckbox(objType2);
            logger.info("Selected Object Type: Requirement");

            globalTab.clickSaveButton();
            logger.info("Clicked on Save button to add global field");

            logger.info("***** Completed TC_VerifyAddGlobalField *****");
            globalTab.clickonCheckbox(rowName);
            logger.info("Clicked on checkbox for row: " + rowName);




        } catch (AssertionError e) {
            logger.error("Assertion failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage());
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}
