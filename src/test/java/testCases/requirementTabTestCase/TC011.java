package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.testng.annotations.Test;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

import java.util.logging.Logger;

public class TC011 extends BaseClass {
    @Test (dataProvider = "tc011", dataProviderClass = RequirementDataProvider.class)
    public void VerifySavebuttonfunctionalityintherequirements(
            String project,
            String epic
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
