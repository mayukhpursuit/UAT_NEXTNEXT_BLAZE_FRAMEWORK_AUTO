package testCases.Settings;


import DataProviders.AuthorTestCaseDataProvider;
import DataProviders.SettingTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class Demo extends BaseClass {
    //@Test(dataProvider = "Demo", dataProviderClass = SettingTestCaseDataProvider.class)
    @Test(dataProvider = "Demo", dataProviderClass = SettingTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void DemoGlobalSetting(
            String fieldvalue,
            String Datatype,
            String checkboxLabel1,
            String checkboxLabel2,
            String editrow,
            String editvalue,
            String deleterow
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");
            GlobalTabPage globalTabPage= new GlobalTabPage(getDriver());
            globalTabPage.clickCurrentUserAndGoToSettings();

            OtherTabPage otherTabPage= new OtherTabPage(getDriver());
            otherTabPage.clickGlobalFieldSetting();
            logger.info("clicked on global field settings");

           globalTabPage.clickonClearAll();
           logger.info("clicked on clear All button");

           globalTabPage.clickonSelectAll();
            logger.info("clicked on Select All button");

            globalTabPage.clickonAddGlobalField();
            logger.info("clicked on Add global Field button");

            globalTabPage.EnterFieldName(fieldvalue);
            logger.info("Filled the field value"+fieldvalue);

            globalTabPage.SelectDataType(Datatype);
            logger.info("select data type"+Datatype);

           globalTabPage.clickObjectTypeCheckbox(checkboxLabel1);
            logger.info("select data type"+checkboxLabel1);

            globalTabPage.clickObjectTypeCheckbox(checkboxLabel2);
            logger.info("select data type"+checkboxLabel2);

//            globalTabPage.clickonSaveButton();
//            logger.info("clicked on Save button");

            globalTabPage.clickCloseButton();
          logger.info("clicked on close button");

          globalTabPage.clickonEdit(editrow);
            logger.info("clicked on edit:"+editrow);

            globalTabPage.clickAddFieldButton();
            logger.info("clicked on addfieldbutton");

            globalTabPage.enterFieldValue(editvalue);
            logger.info("entered Default Field Value:"+editvalue);

            globalTabPage.clickonDeleteIcon();
            logger.info("Clicked on delete icon");

            globalTabPage.clickonCloseButton();
            logger.info("Clicked on close button");

            globalTabPage.clickonDelete(deleterow);
            logger.info("clicked on delete icon of row:"+deleterow);


        }
        catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        }
        catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}

