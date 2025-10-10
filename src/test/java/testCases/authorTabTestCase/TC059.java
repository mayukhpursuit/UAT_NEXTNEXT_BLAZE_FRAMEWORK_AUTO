package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AddTestcasePage;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import pageObjects.authoTestCaseTab.IndividualTestCasePage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC059 extends BaseClass {
    @Test(dataProvider = "tc059", dataProviderClass = AuthorTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)

    public void verifyClickFunctionalityOfAddCalledTestCaseBtn(String rqName, String tcId) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Login successful.");

            logger.info("Navigating to 'Author Test Case' tab.");
            AuthorTestCasePage authorTestCasePage = new AuthorTestCasePage(getDriver());
            IndividualTestCasePage individualTestCasePage = new IndividualTestCasePage(getDriver());
            logger.info("Searching for Requirement: " + rqName);
            authorTestCasePage.searchRq(rqName);
            logger.info("Requirement '" + rqName + "' found. Clicking on it.");
            authorTestCasePage.clickRequirement(rqName);
            Thread.sleep(5000);
            authorTestCasePage.clickTestCasesId(tcId);
            logger.info("Clicked on Test Case ID: " + tcId);
            logger.info("Clicking on 'Add Called Test Case' button.");
            if(individualTestCasePage.clickAddCalledTestcaseBtn()){
                logger.info("Add Called Test Case' button clicked successfully.");
            } else {
                logger.warn("Failed to click 'Add Called Test Case' button.");
            }
        } catch (Exception e) {
            logger.error("Exception occurred during test execution: " + e.getMessage(), e);
            throw e;
        }
        logger.info("************ Test Case Execution Completed ************");

    }
}
