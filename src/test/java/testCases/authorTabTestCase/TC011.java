package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC011 extends BaseClass {

    @Test(dataProvider = "tc011", dataProviderClass = AuthorTestCaseDataProvider.class)
    public void verifyClickFunctionalityOfFeaturesDropdown(
            String epicName,String feature
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {

            login();
            logger.info("Logged in successfully");
            logger.info("Navigated to Author Test Case tab");
            AuthorTestCasePage authorTestCasePage= new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickEpic();
            logger.info("Click on the Epic Drop Down");
            authorTestCasePage.selectEpic(epicName);
            logger.info("selected the epic from the dropdown");
            System.out.println(authorTestCasePage.getSelectedEpic());
            authorTestCasePage.clickFeature();
            logger.info("Sucessfully click the feature dropdown");
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
