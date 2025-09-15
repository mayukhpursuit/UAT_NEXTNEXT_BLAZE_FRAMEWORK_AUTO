package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC012 extends BaseClass {
    @Test(dataProvider = "tc011", dataProviderClass = AuthorTestCaseDataProvider.class)
    public void verifyClickFunctionOfFeaturesDropdown(
            String epicName,String feature
    ) throws InterruptedException {
        logger.info("****** Starting the Log in Test Case *****************");
        try {

            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");
            AuthorTestCasePage authorTestCasePage= new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickEpic();
            logger.info("Click on the Epic Drop Down");
            authorTestCasePage.selectEpic(epicName);
            logger.info("selected the epic from the dropdown");
            //  getDriver().navigate().refresh();
            System.out.println(authorTestCasePage.getSelectedEpic());
            //  authorTestCasePage.clickFeature();
            logger.info("selected the feature from the dropdown");
            authorTestCasePage.getAllFeatures();
            logger.info("Verification done...");
        }
        catch (AssertionError e) {
            logger.error("Assertion failed: {}", e.getMessage());
            throw e;
        }
        catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage());
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}