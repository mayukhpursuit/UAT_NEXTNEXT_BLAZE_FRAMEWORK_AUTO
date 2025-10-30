package testCases.Settings;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Settings.GlobalTabPage;
import pageObjects.Settings.OtherTabPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

public class TC042 extends BaseClass {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserCanToggleShowInGridCheckboxForCustomField() throws InterruptedException {

        logger.info(
                "****** Starting TC042 : Verify that user is able to click on the checkbox of available custom field ******");

        try {

            login();
            logger.info("Logged in successfully");

            GlobalTabPage globalTab = new GlobalTabPage(getDriver());
            OtherTabPage otherTab = new OtherTabPage(getDriver());

            globalTab.clickCurrentUserAndGoToSettings();
            logger.info("Clicked on Settings option from user dropdown");

            otherTab.clickGlobalFieldSetting();
            logger.info("Navigated to Global Field Settings section");

            String firstFieldName = globalTab.getFirstCustomFieldName();
            Assert.assertNotNull(firstFieldName, "No custom fields found to test checkbox interaction.");
            logger.info("Found a custom field: " + firstFieldName);

            boolean initialState = globalTab.isShowInGridCheckboxSelected(firstFieldName);
            logger.info("'Show in Grid' checkbox for '" + firstFieldName + "' is initially: "
                    + (initialState ? "Selected" : "Not Selected"));

            boolean toggleResult = globalTab.toggleShowInGridCheckbox(firstFieldName);
            Assert.assertTrue(toggleResult, "Checkbox state did not change after click.");
            logger.info("Toggled 'Show in Grid' checkbox successfully for field: " + firstFieldName);

            boolean isVisibleInGrid = globalTab.isFieldVisibleInGrid(firstFieldName);
            logger.info("Field visibility icon check: "
                    + (isVisibleInGrid ? "Active (eye icon)" : "Inactive (eye-slash icon)"));

            boolean currentCheckboxState = globalTab.isShowInGridCheckboxSelected(firstFieldName);
            Assert.assertEquals(isVisibleInGrid, currentCheckboxState,
                    "Field visibility icon state does not match the checkbox selection.");

            logger.info("Successfully verified that toggling 'Show in Grid' checkbox activates/deactivates the field.");

        } catch (AssertionError e) {
            logger.error("Assertion failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            throw e;
        }

        logger.info("************ Test Case TC042 Finished *************************");
    }
}
