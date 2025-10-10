package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.RequirementTabPage;
import pageObjects.requirementTab.IndividualModulePage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

import java.util.logging.Logger;

public class TC011 extends BaseClass {
    @Test (dataProvider = "tc011", dataProviderClass = RequirementDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void VerifySavebuttonfunctionalityintherequirements(
            String project,
            String epic,
            String rq,
            String pri,
            String pri1
    ) throws InterruptedException {
        logger.info("****** Starting the TC:11 Verify Save button functionality in the requirements  *************");
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

            req.setPriority(pri);
            logger.info("Priority changed"+pri);

            req.clickSave();
            logger.info("Clicked saved");

            if (req.isRequirementUpdatedSuccessfully()) {
                logger.info("Requirement updated successfully is visible.");
            } else {
                logger.error("Requirement update Unsuccessfully.");
                Assert.fail("Requirement update Unsuccessfully.");
            }

            req.clickCloseButton();
            logger.info("Close button clicked");

            req.clickRequirement(rq);
            req.setPriority(pri1);
            req.clickSave();



        }
        catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        }
        catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }
        logger.info("************ TC:11 Finished *************************");
    }
}
