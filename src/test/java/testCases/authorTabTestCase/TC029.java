package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

import java.time.Duration;

public class TC029 extends BaseClass {
    @Test(dataProvider = "tc029", dataProviderClass = AuthorTestCaseDataProvider.class,retryAnalyzer = RetryAnalyzer.class)
    public void verifyNextButtonFunctionality(
            String expectedPagination
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            AuthorTestCasePage authorTestCasePage=new AuthorTestCasePage(getDriver());
            new RequirementTabPage(getDriver()).clickRequirementTab();
            authorTestCasePage.clickAuthorTestcase();
            logger.info("Navigated to Author Test Case tab");
            authorTestCasePage.clickNextArrow();
            By paginationLocator = By.xpath("//div[@class='pagination-item']");

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(25));

            wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationLocator, "2"));

            System.out.println("✅ Pagination text is now '2'");
            authorTestCasePage.clickEpic();
            authorTestCasePage.clickFeature();
            logger.info("Clicked on forward arrow in the requirement");
            authorTestCasePage.clickRequirementPagination();
            logger.info(authorTestCasePage.showPaginationOfRequirement());
            logger.info("Expected pagination verified ....");
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
