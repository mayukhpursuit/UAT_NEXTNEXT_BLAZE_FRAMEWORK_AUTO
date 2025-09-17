package testCases.authorTabTestCase;

import DataProviders.AuthorTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.authoTestCaseTab.AuthorTestCasePage;
import testBase.BaseClass;

public class TC036 extends BaseClass {
    @Test(dataProvider="AddTest",dataProviderClass = AuthorTestCaseDataProvider.class)
    public void verifyAddTestcaseDisplayedNextWindow(
            String epic,String feature,String requirementId,
            String testCaseName,String description,String priority,
            String QA
    ) throws InterruptedException {
        logger.info("****** Starting the Log in Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");
            AuthorTestCasePage authorTestCasePage=new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickAuthorTestcase();
            logger.info("Clicked the Author test case");
            authorTestCasePage.selectEpic(epic);
            logger.info("Selected the epic");
            authorTestCasePage.selectFeature(feature);
            logger.info("Selected the feature");
            authorTestCasePage.clickRequirement(requirementId);
            logger.info("Clicked on requirement id "+requirementId);
            authorTestCasePage.clickAddTestcase();
            logger.info("Clicked Add test case ..");
            Assert.assertTrue(authorTestCasePage.isCreateTextHeadingVisible());
            logger.info("Verified Successfully");

        }
        catch (Exception | AssertionError e){
            e.printStackTrace();
            logger.error("Test case failed ...");
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }
}
