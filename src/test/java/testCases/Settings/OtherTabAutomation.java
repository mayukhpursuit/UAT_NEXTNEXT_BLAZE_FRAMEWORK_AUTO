package testCases.Settings;

import DataProviders.SettingTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class OtherTabAutomation extends BaseClass {

    public OtherTabAutomation() {
        super();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    // @Test(dataProvider = "Demo1", dataProviderClass = SettingTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void runOtherTabAutomation() throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");

            GlobalTabPage globalTabPage = new GlobalTabPage(getDriver());
            globalTabPage.clickCurrentUserAndGoToSettings();

            OtherTabPage otherTabPage = new OtherTabPage(getDriver());
            otherTabPage.clickModule();
            logger.info("clicked on Modules");

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
