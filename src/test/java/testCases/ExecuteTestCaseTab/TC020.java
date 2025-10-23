package testCases.ExecuteTestCaseTab;

import DataProviders.ExecuteTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.executeTestCaseTab.ExecuteLandingPage;
import pageObjects.executeTestCaseTab.IndividualTestRun;
import pageObjects.executeTestCaseTab.LinkDefectPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

import java.util.logging.Logger;

public class TC020 extends BaseClass {
    @Test(dataProvider = "tc020", dataProviderClass = ExecuteTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public void Verify_that_Create_Test_Log_button_is_working_properly(
            String projectName,
            String ReleaseName,
            String CycleName,
            String SuiteName,
            String TR,
            String defid
    ) throws InterruptedException {

        logger.info("****** Starting Test Case 048: Verify that Create Test Log button is working properly *****************");

        try {
            login();
            logger.info("Logged in successfully");

            ExecuteLandingPage executeLandingPage = new ExecuteLandingPage(getDriver());
            executeLandingPage.clickExecuteTab();
            logger.info("Clicked on the Execute Test Case tab");

            executeLandingPage.clickArrowRightPointingForExpandModule(projectName);
            logger.info("Expanded Project: " + projectName);

            executeLandingPage.expandRelease(ReleaseName);
            logger.info("Expanded Release: " + ReleaseName);

            executeLandingPage.expandSubTestCycle(CycleName);
            logger.info("Expanded Cycle: " + CycleName);

            Thread.sleep(3000);
            executeLandingPage.clickOnSuite(SuiteName);
            logger.info("Clicked on Suite: " + SuiteName);
            Thread.sleep(3000);

            executeLandingPage.clickTestRunById(TR);
            logger.info("Clicked on Test Run ID: " + TR);

            IndividualTestRun individualTestrun = new IndividualTestRun(getDriver());
            Thread.sleep(3000);


            boolean defectPresent = individualTestrun.isDefectPresent();
            if (defectPresent) {
                logger.info("Defect is present");
            } else {
                logger.error("Defect is NOT present under the defect category.");
            }

            Assert.assertTrue(defectPresent, "Defect is not displayed under the defect category.");

            LinkDefectPage linkDefectPage= new LinkDefectPage(getDriver());

            linkDefectPage.clickDefectById(defid);
            logger.info("clicked on defect id"+defid);

        } catch (AssertionError e) {
            logger.error("Assertion failed: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage());
            throw e;
        }

        logger.info("************ Test Case Finished *************************");
    }
}

