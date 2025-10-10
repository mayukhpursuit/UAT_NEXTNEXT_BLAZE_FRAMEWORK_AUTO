package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC013 extends BaseClass {
    @Test(dataProvider = "tc011", dataProviderClass = AuthorTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void verifySelectedFeatureDisplayedFields(
            String epicName , String feature
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
            Assert.assertEquals(authorTestCasePage.getSelectedEpic(),epicName);
            System.out.println(authorTestCasePage.getSelectedEpic());
            logger.info("Verified the desired epic selected successfully");
            authorTestCasePage.selectFeature(feature);
            logger.info("selected the feature from the dropdown");
            Assert.assertEquals(authorTestCasePage.getSelectedFeature(),feature);
            System.out.println(authorTestCasePage.getSelectedFeature());
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