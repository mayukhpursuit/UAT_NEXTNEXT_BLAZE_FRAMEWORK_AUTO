package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AddTestcasePage;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC053 extends BaseClass {
    @Test(dataProvider = "tc053", dataProviderClass = AuthorTestCaseDataProvider.class)
    public void VerifyTheDropDownsInLeftPane(String epic,
                                   String feature,
                                   String requirementId,
                                   String expectedPagination
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            AuthorTestCasePage authorTestCasePage=new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickAuthorTestcase();
            logger.info("clicked on the author test case tab");
            authorTestCasePage.selectEpic(epic);
            logger.info("selected the epic");
            authorTestCasePage.selectFeature(feature);
            logger.info("selected the feature");
            authorTestCasePage.clickRequirement(requirementId);
            logger.info("Clicked the requirement from the grid");
            authorTestCasePage.clickNextArrow();
            logger.info("Clicked the next arrow");
            Assert.assertEquals(authorTestCasePage.showPaginationOfRequirement(),expectedPagination);
            logger.info("Verified successfully");
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
