package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC039 extends BaseClass {
    @Test(dataProvider = "tc039", dataProviderClass = AuthorTestCaseDataProvider.class)
    public void verifyPaginationReset(
            String epicName,
            String featureName,
            String rq_id
    ) throws InterruptedException {
        logger.info("****** Starting TC039: Verify pagination resets properly ******");
        try {


            login();
            logger.info("Logged in successfully");

            AuthorTestCasePage authorTestCasePage = new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickAuthorTestcase();
            logger.info("Navigated to Author Test Case tab");

            authorTestCasePage.clickEpic();
            logger.info("Clicked on Epic Drop Down");
            authorTestCasePage.selectEpic(epicName);
            logger.info("Selected Epic: " + epicName);

            authorTestCasePage.selectFeature(featureName);
            logger.info("Selected Feature: " + featureName);

            authorTestCasePage.linkRequirement(rq_id);
            logger.info("Selected Requirement: " + rq_id);

            authorTestCasePage.clicklinktestcase();


        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }
        logger.info("************ TC039 Finished ************");
    }
}
