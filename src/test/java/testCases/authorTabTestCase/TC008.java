package testCases.authorTabTestCase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

import java.util.List;

public class TC008 extends BaseClass {
    @Test
    public void verifyEpicSelectionAfterRefresh() throws InterruptedException {
        logger.info("****** Starting the Log in Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");
            AuthorTestCasePage authorTestCasePage= new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickEpic();
            logger.info("Click on the Epic Drop Down");
            List<WebElement> epics= authorTestCasePage.getAllEpics();
            boolean b=false;
            for (int i=0;i<=epics.size()-1;i++){
                if (epics.get(i).getText().contains(" ") || epics.get(i).getText().contains("_") || epics.get(i).getText().contains(".")){
                    b=true;
                    System.out.println(epics.get(i).getText());
                }
            }
            Assert.assertTrue(b,"Elements with ' ' , . , ");
            logger.info("Verified successfully that elements with space or special character is present");
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
