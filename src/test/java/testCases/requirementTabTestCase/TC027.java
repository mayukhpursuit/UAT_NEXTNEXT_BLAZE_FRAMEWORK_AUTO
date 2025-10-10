package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.AddRequirementPage;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC027 extends BaseClass {
    @Test(dataProvider = "tc027", dataProviderClass = RequirementDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
public void verifyRequirementEntriesUpdate(String project,
                                           String epic, String description, String priority, String status, String type
) throws InterruptedException {
    logger.info("****** Starting the Test Case *****************");
    try {
        logger.info("************ Test Case Started *************************");

        login();
        logger.info("Logged in successfully");

        RequirementTabPage requirementTabPage = new RequirementTabPage(getDriver());
        logger.info("Initialized RequirementTabPage");

        IndividualModulePage individualModulePage = new IndividualModulePage(getDriver());
        logger.info("Initialized IndividualModulePage");

        AddRequirementPage addRequirementPage = new AddRequirementPage(getDriver());
        logger.info("Initialized AddRequirementPage");

        requirementTabPage.clickRequirementTab();
        logger.info("Clicked on Requirement Tab");

        Thread.sleep(6000);

        requirementTabPage.clickArrowRightPointingForExpandModule(project);
        logger.info("Selected project"+project);

        requirementTabPage.clickOnModule(epic);
        logger.info("Selected epic"+epic);

        int countBefore = individualModulePage.getRequirementCountFromFooter();
        logger.info("Requirement count before adding: " + countBefore);

        individualModulePage.clickAddRequirement();
        logger.info("Clicked on Add Requirement");


        Thread.sleep(2000);

        addRequirementPage.setDescription(description);
        logger.info("Set Description");

        addRequirementPage.selectPriority(priority);
        logger.info("Selected Priority: " + priority);

        Thread.sleep(3000);

        addRequirementPage.selectStatus(status);
        logger.info("Selected Status: " + status);

        Thread.sleep(2000);

        addRequirementPage.selectType(type);
        logger.info("Selected Type: " + type);

        addRequirementPage.clickSave();
        logger.info("Clicked Save button");
        logger.info("Requirement successfully added");

        Thread.sleep(4000);
        addRequirementPage.clickClose();
        logger.info("Clicked on Close button");

        Thread.sleep(4000);
        int countAfter = individualModulePage.getRequirementCountFromFooter();
        logger.info("Requirement count after attempting to add without name: " + countAfter);

        Assert.assertEquals(countAfter, countBefore,
                "Requirement without name should not be saved in the table");
        logger.info("Verified requirement without name is not saved, count remained same");




    } catch (AssertionError e) {
        logger.error("❌ Assertion failed: " + e.getMessage(), e);
        throw e;
    } catch (Exception e) {
        logger.error("❌ Exception occurred: " + e.getMessage(), e);
        throw e;
    }

    logger.info("************ Test Case Finished *************************");

}
}
