package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.RequirementTabPage;
import pageObjects.requirementTab.IndividualModulePage;
import testBase.BaseClass;

import java.util.logging.Logger;

public class TC012 extends BaseClass {
    @Test (dataProvider = "tc011", dataProviderClass = RequirementDataProvider.class)
    public void verifytheclosebuttonfunctionalityintherequirements (
            String project,
            String epic,
            String rq
    ) throws InterruptedException {
        logger.info("****** Starting the TC:12 verify the close button functionality in the requirements   *************");
        try {
            login();
            logger.info("Logged in successfully");

            RequirementTabPage reqPage = new RequirementTabPage(getDriver());
            reqPage.clickRequirementTab();
            logger.info("clicked on requirement tab");

            reqPage.clickArrowRightPointingForExpandModule(project);
            logger.info("Selected project"+project);

            reqPage.clickOnModule(epic);
            logger.info("Selected epic"+epic);

            IndividualModulePage req = new IndividualModulePage(getDriver());
            req.clickRequirement(rq);
            logger.info("Selected Requirement"+rq);

            req.clickCloseButton();
            logger.info("Close button clicked");


        }
        catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        }
        catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }
        logger.info("************ TC:12 Finished *************************");
    }
}
