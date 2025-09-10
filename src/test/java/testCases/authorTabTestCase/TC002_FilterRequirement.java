package testCases.authorTabTestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AuthorTestCasePage;
import testBase.BaseClass;
import utils.DataProviders;

public class TC002_FilterRequirement extends BaseClass {

    @Test(dataProvider = "filterRequirement",dataProviderClass = DataProviders.class)
    public void verifyRequirementHeading(String epic,String feature,String requirementId,
                                         String expectedHeader) throws InterruptedException {
        logger.info("****** Starting the Filter Requirement Test Case *****************");
        try {
            login();
            AuthorTestCasePage authorTestCasePage=new AuthorTestCasePage(getDriver());
            authorTestCasePage.selectEpic(epic);
            logger.info("Selected the epic");
            authorTestCasePage.selectFeature(feature);
            logger.info("Selected the Feature");
            authorTestCasePage.clickRequirement(requirementId);
            logger.info("selected the Desired Requirement");
            String requirementHeader= authorTestCasePage.showRequirementHeader();
            Assert.assertEquals(requirementHeader,expectedHeader);
            logger.info("Verification Successful");
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
