package testCases.Demo;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import pageObjects.requirementTab.AddRequirementPage;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

public class AddRequirement extends BaseClass {
    @Test
    public void verifyRequirementFlow() throws InterruptedException {
        logger.info("****** Starting the Filter Requirement Test Case *****************");
        try {
            login();
            RequirementTabPage requirementTabPage= new RequirementTabPage(getDriver());
            requirementTabPage.clickRequirementTab();
            requirementTabPage.clickOnTheProjectName();
            requirementTabPage.clickNewModule();
            requirementTabPage.setModuleName("Epic Mayukhjit");
            requirementTabPage.saveModule();
            requirementTabPage.clickNewModule();
            requirementTabPage.setModuleName("Feature Mohit");
            requirementTabPage.saveModule();
            IndividualModulePage individualModulePage= new IndividualModulePage(getDriver());
            individualModulePage.clickAddRequirement();
            AddRequirementPage addRequirementPage = new AddRequirementPage(getDriver());
            addRequirementPage.setRequirementId("RQ-114");
            addRequirementPage.setDescription("Hello new requirement");
            addRequirementPage.clickSave();

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
