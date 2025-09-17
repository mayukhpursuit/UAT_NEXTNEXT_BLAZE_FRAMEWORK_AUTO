package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AddTestcasePage;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC041 extends BaseClass {
    @Test(dataProvider = "tc051", dataProviderClass = AuthorTestCaseDataProvider.class)

    public void verifyUpdatedCountoftestcase(String rqName, String tcName, String description, String priority, String type, String qaUser, String preCondition) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Login successful.");

            logger.info("Navigating to 'Author Test Case' tab.");
            AuthorTestCasePage authorTestCasePage = new AuthorTestCasePage(getDriver());
            AddTestcasePage addTestcasePage = new AddTestcasePage(getDriver());

            authorTestCasePage.searchRq(rqName);
            logger.info("Requirement '" + rqName + "' searched and selected.");

            authorTestCasePage.clickRequirement(rqName);
            logger.info("Requirement '" + rqName + "' clicked.");

            String totalCountBeforeAddTestcase = authorTestCasePage.totalNoOfTestcasesInsideRq();
            Thread.sleep(4000);
            logger.info("Total test cases before addition: " + totalCountBeforeAddTestcase);

            authorTestCasePage.clickAddTestcase();
            logger.info("Clicked 'Add Test Case' button.");

            addTestcasePage.setTestCaseName(tcName);
            logger.info("Test case name set to: " + tcName);

            addTestcasePage.setDescription(description);
            logger.info("Test case description set.");

            addTestcasePage.selectPriority(priority);
            logger.info("Priority set to: " + priority);

            addTestcasePage.selectType(type);
            logger.info("Type set to: " + type);

            addTestcasePage.selectQaUser(qaUser);
            logger.info("QA user assigned: " + qaUser);

            addTestcasePage.setPrecondition(preCondition);
            logger.info("Precondition set.");

            addTestcasePage.clickSave();
            logger.info("New test case saved successfully.");

            Thread.sleep(3000);

            String totalCountAfterAddNewTestcase = authorTestCasePage.totalNoOfTestcasesInsideRq();
            logger.info("Total test cases after addition: " + totalCountAfterAddNewTestcase);

            int before = authorTestCasePage.extractNumber(totalCountBeforeAddTestcase);
            int after = authorTestCasePage.extractNumber(totalCountAfterAddNewTestcase);

            Assert.assertEquals(after, before + 1, "Test case count did not increase after adding a new test case.");
        } catch (Exception e) {
            logger.error("An exception occurred: " + e.getMessage(), e);
            throw e;
        }

        logger.info("************ Test Case Execution Completed ************");

    }
}