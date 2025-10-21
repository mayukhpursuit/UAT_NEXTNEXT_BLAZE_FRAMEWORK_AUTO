package testCases.ExecuteTestCaseTab;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.executeTestCaseTab.ExecuteLandingPage;
import pageObjects.executeTestCaseTab.IndividualTestRun;
import testBase.BaseClass;
@Test
public class TC030 extends BaseClass {
    public void verifyHelpDropDown() throws InterruptedException {
        try {

            login();
            logger.info("Logged in successfully");

            ExecuteLandingPage executeLandingPage = new ExecuteLandingPage(getDriver());
            IndividualTestRun individualTestRun = new IndividualTestRun(getDriver());
            executeLandingPage.clickExecuteTab();
            logger.info("Clicked on the Execute Test Case tab");
            executeLandingPage.clickHelpBtn();
            logger.info("Clicked on the Help Btn");


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

