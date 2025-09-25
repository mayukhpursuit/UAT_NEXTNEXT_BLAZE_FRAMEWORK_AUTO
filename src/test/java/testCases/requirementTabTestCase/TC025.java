package testCases.requirementTabTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.requirementTab.RequirementTabPage;
import pageObjects.requirementTab.AddRequirementPage;
import testBase.BaseClass;

import java.util.List;

public class TC025 extends BaseClass {

    @Test(dataProvider = "tc025", dataProviderClass = DataProviders.RequirementDataProvider.class, description = "Verify linked requirement count increases and decreases")
    public void verifyLinkedRequirementCountIncreasesAndDecreases(String projectName, String moduleName)
            throws InterruptedException {
        logger.info(
                "************ Starting Test Case: Verify linked requirement count increases and decreases *****************");

        try {

            login();
            logger.info("Logged in successfully");

            RequirementTabPage requirementTabPage = new RequirementTabPage(getDriver());
            AddRequirementPage addRequirementPage = new AddRequirementPage(getDriver());

            requirementTabPage.clickRequirementTab();
            logger.info("Clicked on Requirements tab");

            requirementTabPage.clickArrowRightPointingForExpandModule(projectName);
            logger.info("Expanded project: " + projectName);

            requirementTabPage.clickOnModule(moduleName);
            logger.info("Opened module: " + moduleName);

            List<String> beforeList = requirementTabPage.getRequirementIDs();
            int beforeCount = beforeList.size();
            logger.info("Initial requirement count: " + beforeCount);

            addRequirementPage.clickAddRequirementBtn();
            String newRequirementName = "Test_Sohail";
            addRequirementPage.setRequirementId(newRequirementName);
            addRequirementPage.clickSave();

            Thread.sleep(2000);
            addRequirementPage.clickClose();
            Thread.sleep(2000);

            List<String> afterAddList = requirementTabPage.getRequirementIDs();
            int afterAddCount = afterAddList.size();
            logger.info("Requirement count after adding: " + afterAddCount);

            Assert.assertEquals(afterAddCount, beforeCount + 1, "Requirement count did not increase after adding");

            String newRequirementId = afterAddList.get(afterAddList.size() - 1);
            logger.info("Newly linked requirement ID: " + newRequirementId);

            requirementTabPage.unlinkRequirementById(newRequirementId, afterAddCount);
            logger.info("Unlinked requirement: " + newRequirementId);

            List<String> afterRemoveList = requirementTabPage.getRequirementIDs();
            int afterRemoveCount = afterRemoveList.size();
            logger.info("Requirement count after unlink: " + afterRemoveCount);

            Assert.assertEquals(afterRemoveCount, beforeCount, "Requirement count did not decrease after unlinking");

            logger.info("Verified requirement count increases by 1 after link and decreases by 1 after unlink");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }

        logger.info("************ Test Case Finished *************************");
    }
}
