package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AddTestcasePage;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC066 extends BaseClass {
    @Test(dataProvider = "tc066", dataProviderClass = AuthorTestCaseDataProvider.class)

    public void addNewTestcaseWithoutTcName(String rqName) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");

            logger.info("Navigated to Author Test Case tab");
            AuthorTestCasePage authorTestCasePage = new AuthorTestCasePage(getDriver());
            AddTestcasePage addTestcasePage = new AddTestcasePage(getDriver());

            authorTestCasePage.searchRq(rqName);
            logger.info("Successfully searched with RQ ID: " + rqName);

            authorTestCasePage.clickRequirement(rqName);
            logger.info("Clicked on the selected RQ");

            authorTestCasePage.clickAddTestcase();
            logger.info("Clicked 'Add Test Case' button");

            logger.info("Attempting to save without entering test case name");
            addTestcasePage.clickSave();
            logger.info("Clicked the save button");

            String actualWarning = addTestcasePage.getTcNameRequiredWarningMessage();
            String expectedWarning = "Error: Name is required.";

            logger.info("Validating warning message...");
            logger.info("Expected: " + expectedWarning);
            logger.info("Actual: " + actualWarning);

            Assert.assertEquals(actualWarning, expectedWarning, "Validation message did not match!");
            logger.info("Verified warning notification successfully");

        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage(), e);
            throw e;
        }

        logger.info("************ Test Case Finished *************************");


    }
}
