package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.AddRequirementPage;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

public class TC037 extends BaseClass {
    @Test(dataProvider = "tc037", dataProviderClass = RequirementDataProvider.class)

    public void verifyCLoseButtonOnTheAlertWhenEmptyModuleName(String mainProject, String module, String newmodulename
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            logger.info("************ Test Case Started *************************");

            login();
            logger.info("Logged in successfully");

            RequirementTabPage requirementTabPage = new RequirementTabPage(getDriver());
            IndividualModulePage individualModulePage = new IndividualModulePage(getDriver());
            AddRequirementPage addRequirementPage = new AddRequirementPage(getDriver());

            requirementTabPage.clickRequirementTab();
            logger.info("Clicked on the 'Requirement' tab");

            Thread.sleep(6000);

            requirementTabPage.clickArrowRightPointingForExpandModule(mainProject);
            logger.info("Expanded the main project: " + mainProject);

            Thread.sleep(9000);
            requirementTabPage.clickOnModule(module);
            logger.info("Clicked on the module: " + module);

            Thread.sleep(5000);

            requirementTabPage.setModuleName(newmodulename);
            logger.info("Entered module name: " + newmodulename);

            individualModulePage.clickSave();
            logger.info("Clicked the 'Save' button");
            Thread.sleep(4000);

            individualModulePage.clickCloseBtnOfALertModuleName();
            logger.info("Successfully Click the close button");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage(), e);
            throw e;

        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage(), e);
            throw e;
        }

        logger.info("************ Test Case Finished *************************");

    }
}
