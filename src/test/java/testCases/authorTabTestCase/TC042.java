package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC042 extends BaseClass {
    @Test(dataProvider = "tc042", dataProviderClass = AuthorTestCaseDataProvider.class)
    public void VerifyVisibilityOfAllFieldsInAddTestCase(String requirementId,String TestcaseId
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            AuthorTestCasePage authorTestCasePage = new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickAuthorTestcase();
            logger.info("Navigated to Author Test Case tab");
            authorTestCasePage.clickRequirement(requirementId);
            authorTestCasePage.clickActionIcon(TestcaseId);
            logger.info("Clicked unlink icon for test case TC-358");
            authorTestCasePage.confirmUnlink();
            logger.info("Clicked Yes to unlink the test case successfully");


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
