package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import pageObjects.authoTestCaseTab.IndividualTestCasePage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

import java.util.prefs.BackingStoreException;

public class TC062 extends BaseClass {
    @Test(dataProvider = "tc040",dataProviderClass = AuthorTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void VerifyAddTestStepButton(
            String requirementId,String TestcaseId
    )throws InterruptedException {
        logger.info("************ Starting the Test Case ****************");
        try
        {
            login();
            logger.info("Logged in successfully");
            AuthorTestCasePage authorTestCasePage = new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickAuthorTestcase();
            authorTestCasePage.clickRequirement(requirementId);
            authorTestCasePage.linkTestCaseIdFromId(TestcaseId).click();
            Thread.sleep(5000);
            IndividualTestCasePage individualTestCasePage = new IndividualTestCasePage(getDriver());

            individualTestCasePage.clickAddTestStep();
          logger.info("Add Test Step Button works ");
        }
        catch (AssertionError e)
        {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        }
        catch (Exception e)
        {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}

