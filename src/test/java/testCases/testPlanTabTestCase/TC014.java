package testCases.testPlanTabTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.testPlanTab.TestPlanLandingPage;
import testBase.BaseClass;

public class TC014 extends BaseClass {

    @Test(dataProvider = "tc014", dataProviderClass = DataProviders.TestPlanDataProvider.class)
    public void Verifysuccessmessageonaddingrelease(
            String projectName,
            String releaseName,
            String status,
            String Note
    ) throws InterruptedException {
        logger.info("****** TC014: Verify success message on adding release *****************");

        try {
            login();
            logger.info("Logged in successfully");
            TestPlanLandingPage testPlanPage = new TestPlanLandingPage(getDriver());
            testPlanPage.selectTestPlanTab();
            logger.info("Navigated to Test Plan tab");

            testPlanPage.clickOnTheProjectName();
            logger.info("Selected project: " + projectName);

            testPlanPage.clickNewRelease();
            logger.info("Clicked on new release icon");

            testPlanPage.enterReleaseName(releaseName);
            testPlanPage.selectReleaseStatus(status);
            testPlanPage.enterReleaseNotes(Note);

            logger.info("Entered all release details");

            testPlanPage.clickSaveRelease();
            logger.info("Clicked Save button");


            Assert.assertTrue(testPlanPage.isReleaseCreatedSuccessfully(),
                    "Release creation success message not displayed!");
            logger.info("Release created successfully notification displayed");

            logger.info("************ Test Case Finished Successfully *************************");

            testPlanPage.expandRelease(releaseName);
            testPlanPage.clickDelete();
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }
    }
}
