package testCases.requirementTabTestCase;

import DataProviders.RequirementDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.AddRequirementPage;
import pageObjects.requirementTab.IndividualModulePage;
import pageObjects.requirementTab.RequirementTabPage;
import testBase.BaseClass;

import java.time.Duration;

public class TC010 extends BaseClass {
    @Test(dataProvider = "tc010", dataProviderClass = RequirementDataProvider.class)
    public void verifyFieldDetails(
            String project,
            String epic,
            String feature,
            String id
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
            AddRequirementPage addRequirementPage=new AddRequirementPage(getDriver());
            addRequirementPage.clickAddRequirementBtn();
            logger.info("Add a requirement");
            addRequirementPage.setRequirementId(id);
            IndividualModulePage modulePage=new IndividualModulePage(getDriver());
            WebDriverWait wait =new WebDriverWait(getDriver(),Duration.ofSeconds(10));
            logger.info("Verify all the fields");
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(modulePage.PriorityField())).isDisplayed());
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(modulePage.TypeField())).isDisplayed());
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(modulePage.StatusField())).isDisplayed());
            logger.info("Fields have been verified");
            addRequirementPage.clickSave();
            logger.info("click on save btn" );
            WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='notification']")));
            logger.info("Success msg appears");
            addRequirementPage.clickClose();
            logger.info("Fields have been verified and the requirement has been save successfully");
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
