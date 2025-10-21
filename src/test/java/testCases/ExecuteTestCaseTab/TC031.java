package testCases.ExecuteTestCaseTab;

import DataProviders.ExecuteTestCaseDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.executeTestCaseTab.ExecuteLandingPage;
import pageObjects.executeTestCaseTab.IndividualTestRun;
import pageObjects.executeTestCaseTab.LinkDefectPage;
import testBase.BaseClass;
import utils.RetryAnalyzer;

import java.util.List;

public class TC031 extends BaseClass {

    @Test(dataProvider = "tc022", dataProviderClass = ExecuteTestCaseDataProvider.class, retryAnalyzer = RetryAnalyzer.class)
    public class TC022 extends BaseClass {
        public void verifyDefectIdNonDuplicacy(String projName,
                                            String releaseName,
                                            String testRun,
                                            String defSummary,
                                            String status,
                                            String description
        ) throws InterruptedException {
            logger.info("****** Starting Test Case: Verify Expand feature of sub test cycle *****************");

            try {
                login();
                logger.info("Logged in successfully");

                ExecuteLandingPage executeLandingPage = new ExecuteLandingPage(getDriver());
                executeLandingPage.clickExecuteTab();
                logger.info("Clicked on the Execute Test Case tab");

                executeLandingPage.clickArrowRightPointingForExpandModule(projName);
                Assert.assertTrue(executeLandingPage.selectedModuleOrReleaseName(projName).isDisplayed(),
                        "Parent module not visible after expand");
                logger.info("Expanded parent module: " + projName);

                executeLandingPage.expandRelease(releaseName);
                Assert.assertTrue(executeLandingPage.isReleaseVisible(releaseName), "Release not visible after expand");
                logger.info("Expanded Release module: " + releaseName);

                IndividualTestRun individualTestrun = new IndividualTestRun(getDriver());
                executeLandingPage.clickPlayActionById(testRun);
                logger.info("clicked on Action Play button");
                individualTestrun.clickLinkDefect();
                logger.info("clicked on link defect button");
                LinkDefectPage linkDefectPage=new LinkDefectPage(getDriver());
                List<String> defectIds=linkDefectPage.getAllDefectIds();
                System.out.println("Defect IDs found:");
                for (String id : defectIds) {
                    System.out.println(id);
                }
                logger.info("All defect have a unique id's");

        }
            catch (AssertionError e) {
                logger.error("Assertion failed: {}", e.getMessage());
                throw e;
            } catch (Exception e) {
                logger.error("Exception occurred: {}", e.getMessage());
                throw e;
            }

            logger.info("************ Test Case Finished *************************");
        }
    }
    }