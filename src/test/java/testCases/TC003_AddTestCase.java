package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AddTestcasePage;
import pageObjects.AuthorTestCasePage;
import testBase.BaseClass;
import utils.DataProviders;

public class TC003_AddTestCase extends BaseClass {
    @Test(dataProvider="addTestCase",dataProviderClass = DataProviders.class)
    public void verifyTestCaseCreation(
            String epic,String feature,String requirementId,
            String testCaseName,String description,String priority,
            String QA
    ) throws InterruptedException {
        logger.info("****** Starting the Log in Test Case *****************");
        try {
            login();

            AuthorTestCasePage authorTestCasePage=new AuthorTestCasePage(getDriver());
            authorTestCasePage.clickAuthorTestcase();
            authorTestCasePage.selectEpic(epic);
            authorTestCasePage.selectFeature(feature);
            authorTestCasePage.clickRequirement(requirementId);

            authorTestCasePage.clickAddTestcase();

            AddTestcasePage addTestcasePage= new AddTestcasePage(getDriver());
            addTestcasePage.setTestCaseName(testCaseName);
            addTestcasePage.setDescription(description);
            addTestcasePage.selectPriority(priority);
            addTestcasePage.selectQaUser(QA);
            addTestcasePage.clickSave();
            String testCaseId=addTestcasePage.getTestcaseId(testCaseName);
            System.out.println(testCaseId);
            Assert.assertFalse(testCaseId.isEmpty());
        }
        catch (Exception | AssertionError e){
            e.printStackTrace();
            logger.error("Test case failed ...");
            throw e;
        }
        logger.info("************ Test Case Finished *************************");
    }

}
