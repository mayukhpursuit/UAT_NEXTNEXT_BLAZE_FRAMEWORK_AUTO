package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC007 extends BaseClass {
    @Test(dataProvider = "tc007", dataProviderClass = AuthorTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void verifyAllAvailableEpicsDisplayed(
            String epicName,String defaultEpic
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");
            AuthorTestCasePage authorTestCasePage= new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickEpic();
            logger.info("Click on the Epic Drop Down");
            authorTestCasePage.selectEpic(epicName);
            logger.info("selected the epic from the dropdown");
            getDriver().navigate().refresh();
            Assert.assertEquals(authorTestCasePage.getSelectedEpic(),defaultEpic);
            System.out.println(authorTestCasePage.getSelectedEpic());
            logger.info("Verification done...");
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
