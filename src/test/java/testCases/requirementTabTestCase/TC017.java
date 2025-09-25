package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

import java.time.Duration;

public class TC017 extends BaseClass {
    @Test(dataProvider = "tc017", dataProviderClass = RequirementDataProvider.class)
    public void verifynoLinkedRequirementMessage(
            String project,
            String epic,
            String feature
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            RequirementTabPage requirementTabPage= new RequirementTabPage(getDriver());
            requirementTabPage.clickRequirementTab();
            logger.info("Navigated to Requirement page");
            requirementTabPage.clickArrowRightPointingForExpandModule(project);
            logger.info("Navigate to the project");
            requirementTabPage.clickArrowRightPointingForExpandModule(epic);
            logger.info("Navigated to Module");
            requirementTabPage.clickOnModule(feature);
            logger.info("clicked on specific module");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            IndividualModulePage indivisualModulePage = new IndividualModulePage(getDriver());
            Assert.assertTrue(indivisualModulePage.noLinkedRequirementVisibility(),"Unable to find the message ");
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

