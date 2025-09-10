package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC001 extends BaseClass {
    @Test(dataProvider = "tc001", dataProviderClass = AuthorTestCaseDataProvider.class)
    public void verifyLogin() throws InterruptedException {
        logger.info("****** Starting the Log in Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");
            AuthorTestCasePage authorTestCasePage= new AuthorTestCasePage(getDriver());
            Assert.assertEquals(authorTestCasePage.getEpicLabelName(),"Epic");
            logger.info("label name displayed as epic");
            Assert.assertTrue(authorTestCasePage.getVisibilityOfEpic(),"Epic is not Visible");
            logger.info("Located the Epic dropdown on the left section");
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
