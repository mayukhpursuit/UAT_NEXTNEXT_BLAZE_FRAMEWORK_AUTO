package testCases.testPlanTabTestCase;

import DataProviders.RequirementDataProvider;
import DataProviders.TestPlanDataProvider;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC001 extends BaseClass {
    @Test(dataProvider = "tc001", dataProviderClass = TestPlanDataProvider.class)
    public void verifyEpicVisibility(
    ) throws InterruptedException {
        logger.info("****** Starting the Test Case *****************");
        try {
            login();
            logger.info("Logged in successfully");

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
