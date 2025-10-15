package testCases.ExecuteTestCaseTab;

import DataProviders.ExecuteTestCaseDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.executeTestCaseTab.ExecuteLandingPage;
import pageObjects.executeTestCaseTab.IndividualTestRun;
import pageObjects.executeTestCaseTab.LinkDefectPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC021 extends BaseClass {
    @Test(dataProvider = "tc021", dataProviderClass = ExecuteTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void verifyUnlinkDefectButton(
            String projName,
            String releaseName,
            String testRun,
            String defectID
    ) throws InterruptedException
    {
        logger.info("****** Starting Test Case: Verify Expand feature of sub test cycle *****************");

        try {
            login();
            logger.info("Logged in successfully");

            ExecuteLandingPage executeLandingPage = new ExecuteLandingPage(getDriver());
            executeLandingPage.clickExecuteTab();
            logger.info("Clicked on the Execute Test Case tab");

            executeLandingPage.clickArrowRightPointingForExpandModule(projName);
            Assert.assertTrue(executeLandingPage.selectedModuleOrReleaseName(projName).isDisplayed(),
                    "Parent module not visible after expand");
            logger.info("Expanded parent module: " + projName);

            executeLandingPage.expandRelease(releaseName);
            Assert.assertTrue(executeLandingPage.isReleaseVisible(releaseName), "Release not visible after expand");
            logger.info("Expanded Release module: " + releaseName);

            IndividualTestRun individualTestrun = new IndividualTestRun(getDriver());
            executeLandingPage.clickPlayActionById(testRun);
            logger.info("clicked on Action Play button");
            individualTestrun.clickLinkDefect();
            logger.info("Clicked on link defect ");

            LinkDefectPage linkDefectPage= new LinkDefectPage(getDriver());
            linkDefectPage.clickSearchButton();
            linkDefectPage.enterDefectSearch(defectID);
            linkDefectPage.clickSearchButton();
            WebElement element1= getDriver().findElement(By.xpath("(//input[@value='317'])[1]"));
            element1.click();
            linkDefectPage.clickLink();
            individualTestrun.clickSaveButton();
            individualTestrun.clickLinkDefect();
            WebElement element2= getDriver().findElement(By.xpath("(//img[@title='Unlink Defect'])[2]"));
            element2.click();
            getDriver().findElement(By.xpath("(//div[@class='test-execution-label-3'])[1]")).click();
            individualTestrun.clickSaveButton();
            linkDefectPage.clickClose();
            individualTestrun.clickCloseButton();
        }
        catch (AssertionError e)
        {
            logger.error("Assertion failed: {}", e.getMessage());
            throw e;
        }
        catch (Exception e)
        {
            logger.error("Exception occurred: {}", e.getMessage());
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}
