package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TC003 extends BaseClass {
    @Test(dataProvider = "tc003", dataProviderClass = AuthorTestCaseDataProvider.class)
    public void verifyAllAvailableEpicsDisplayed(
            String projectName
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");
            RequirementTabPage requirementTabPage= new RequirementTabPage(getDriver());
            AuthorTestCasePage authorTestCasePage= new AuthorTestCasePage(getDriver());
            requirementTabPage.clickRequirementTab();
            logger.info("Navigated to Requirement page");
            requirementTabPage.clickArrowRightPointingForExpandModule(projectName);
            logger.info("Navigated to the project");
            int expectedEpic=requirementTabPage.getAllModulesOnly();
            authorTestCasePage.clickAuthorTestcase();

            authorTestCasePage.clickEpic();
            logger.info("Clicked Epic successfully");

            Assert.assertEquals(authorTestCasePage.getCountInEpic()-1,expectedEpic,"Count mismatched ..");
            logger.info("Verified the containing Epics");
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
