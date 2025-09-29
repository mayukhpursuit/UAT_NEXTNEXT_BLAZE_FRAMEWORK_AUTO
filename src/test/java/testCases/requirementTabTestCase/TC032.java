package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.AddRequirementPage;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

public class TC032 extends BaseClass {
    @Test(dataProvider = "tc036", dataProviderClass = RequirementDataProvider.class)
    public void verifyRequirementEntriesUpdate(String project, String epic) throws InterruptedException {
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
            requirementTabPage.clickDeleteModule();
            logger.info("Clicked on Delete icon for epic: " + epic);
            String expectedDeleteMessage = "Deleting a module will also delete its associated requirements and test cases. Are you sure you want to delete?";
            String actualDeleteMessage = requirementTabPage.getDeleteModuleAlertMessage();
            logger.info("Actual delete message: " + actualDeleteMessage);
            Assert.assertEquals(actualDeleteMessage, expectedDeleteMessage);

            requirementTabPage.clickNoInDeleteNotification();
            logger.info("Clicked No button in delete notification.");




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
