package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.AddRequirementPage;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC004 extends BaseClass {
    @Test(dataProvider = "tc004", dataProviderClass = RequirementDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void verifyUpdateDescription
            (String reqId,String description) throws InterruptedException {
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
            logger.info("Clicked on the Requirement ID from the requirements list");
            individualModulePage.clickRequirement(reqId);
            logger.info("Successfully navigated inside the selected Requirement");
            AddRequirementPage addRequirementPage = new AddRequirementPage(getDriver());
            addRequirementPage.setDescription(description);
            logger.info("Entered description for the requirement");

            addRequirementPage.clickSave();
            logger.info("Clicked on Save button");

            String actualSuccessMsg = addRequirementPage.getRequirementUpdatedSuccessMessage();
            String expectedSuccessMsg = "Requirement updated successfully.";

            logger.info("Validating success message...");
            logger.info("Expected: " + expectedSuccessMsg);
            logger.info("Actual: " + actualSuccessMsg);
            Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Validation message did not match!");
            logger.info("Verified warning notification successfully");


        } catch (Exception e) {
            logger.error("Exception occurred during test execution: " + e.getMessage(), e);
            throw e;
        }
        logger.info("************ Test Case Execution Completed ************");

    }
}
