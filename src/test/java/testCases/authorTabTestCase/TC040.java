package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import pageObjects.authoTestCaseTab.IndividualTestCasePage;
import testBase.BaseClass;

public class TC040 extends BaseClass {
    @Test(dataProvider = "tc040",dataProviderClass = AuthorTestCaseDataProvider.class)
    public void VerifyCloseInTestcases(
            String requirementId,String TestcaseId
            )throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            AuthorTestCasePage authorTestCasePage = new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickAuthorTestcase();
            authorTestCasePage.clickRequirement(requirementId);

            authorTestCasePage.linkTestCaseIdFromId(TestcaseId).click();
            IndividualTestCasePage individualTestCasePage = new IndividualTestCasePage(getDriver());
            individualTestCasePage.ClickCloseButton();
            logger.info("Model closed");

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