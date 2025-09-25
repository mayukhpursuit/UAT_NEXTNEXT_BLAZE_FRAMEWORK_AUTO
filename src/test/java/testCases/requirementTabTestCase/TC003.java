package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.AddRequirementPage;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

public class TC003 extends BaseClass {
    @Test
    public void verifyLinkedRequirementTable() throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Login successful.");
            logger.info("Navigated to Requirements tab");
            RequirementTabPage requirementsPage = new RequirementTabPage(getDriver());
            requirementsPage.clickRequirementTab();

            logger.info("Clicked on the Project from left panel to open the module");
            requirementsPage.clickOnTheProjectName();
            IndividualModulePage individualModulePage = new IndividualModulePage(getDriver());

            Assert.assertTrue(individualModulePage.isLinkedRequirementTableVisible(), "Linked Test Case table not visible");
            logger.info("Verified linked test case table is displayed");




        } catch (Exception e) {
            logger.error("Exception occurred during test execution: " + e.getMessage(), e);
            throw e;
        }
        logger.info("************ Test Case Execution Completed ************");

    }
}
