package pageObjects.executeTestCaseTab;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExecuteLandingPage extends BasePage {

    public ExecuteLandingPage(WebDriver driver) {
        super(driver);
    }

    // ================= LOCATORS =================

    // landing page
    @FindBy(id = "execute")
    WebElement tabexceute;

    @FindBy(xpath = "//div[@class='project ']")
    List<WebElement> allProjects;

    @FindBy(xpath = "//div[@class='project ']")
    WebElement labelProjectName;

    @FindBy(xpath = "//div[contains(@class,'project')]//i[contains(@class,'fa-caret-right') and contains(@class,'toggle-icon')]")
    List<WebElement> expandArrows;

    @FindBy(xpath = "//div[contains(@class,'project') or contains(@class,'releases')]")
    List<WebElement> allModulesAndReleases;

    // release page

    @FindBy(id = "assignToMe")
    WebElement assignToMeRadio;

    @FindBy(id = "viewAll")
    WebElement viewAllRadio;

    @FindBy(id = "statusDropdown")
    WebElement statusDropdown;

    @FindBy(id = "createTestRunButton")
    WebElement createTestRunButton;

    @FindBy(xpath = "//div[@class='wrapper']")
    List<WebElement> rqCountWrapper;

    @FindBy(xpath = "(//select[@class='text select-dropdown'])[2]")
    WebElement dropdownFeature;

    @FindBy(xpath = "//img[@alt='Last Page']")
    WebElement lastPageArrowBtn;

    @FindBy(xpath = "//img[@alt='Previous']")
    WebElement arrowBackwardPrevious;

    @FindBy(xpath = "//img[@alt='Next']")
    WebElement arrowForwardNextPagination;

    @FindBy(xpath = "//div[@class='pagination-item']")
    WebElement divRequirementPagination;

    @FindBy(xpath = "//a[contains(@class,'runButton')]")
    List<WebElement> testRunLinks;

    @FindBy(xpath = "//div[@class='testlistcell1']/a[contains(text(),'TR')]")
    List<WebElement> allTestRunIds;

    @FindBy(xpath = "//div[@class='testlistcell1']/a[contains(text(),'TC')]")
    List<WebElement> allTestCaseIds;

    @FindBy(xpath = "//button[@id='clearsearchButton']")
    WebElement buttonClear;

    public WebElement buttonActionPlay(String trId){
        return driver.findElement(By.xpath("//a[text()='"+trId+"']/ancestor::div[@class='requirement testlistframe-11']//button"));
    }


    // locators for create test run

    @FindBy(xpath = "//button[.//div[text()='SAVE']]")
    WebElement saveButtonInPopup;

    @FindBy(id = "closeModal")
    WebElement cancelButtonInPopup;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement searchfield;

    @FindBy(xpath = "//div[@class='test-execution-label-3']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='text-wrapper-9']")
    WebElement currentPageNumber;

    private WebElement suiteByName(String suiteName) {
        return driver.findElement(
                By.xpath("//div[contains(@class,'test-suite-row') and contains(normalize-space(.),'" + suiteName + "')]"));
    }



    @FindBy(xpath = "//div[@id='testRunsWithCaseDetailsTable']")
    WebElement tableTestRunsWithCaseDetails;

    // ================= ACTIONS =================

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions actions = new Actions(driver);

    // execute landing page

    public boolean isMentionedProjectNameVisible(String projectName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(labelProjectName));
        String name=labelProjectName.getText();
        return name.equals(projectName);
    }

    private WebElement arrowRightToExpand(String moduleName) {
        return driver.findElement(By.xpath("//div[text()='"+moduleName+"']/..//i[@class='fa-solid fa-caret-right toggle-icon']"));
    }

    private WebElement arrowDownToCollapse(String moduleName) {
        return driver.findElement(
                By.xpath("//span[normalize-space()='" + moduleName + "']/..//i[contains(@class,'fa-caret-down')]"));
    }

    private WebElement releaseByName(String releaseName) {
        return driver.findElement(
                By.xpath("//div[contains(@class,'releases') and contains(normalize-space(.),'" + releaseName + "')]"));
    }

    private WebElement testCycleByName(String testCycleName) {
        return driver.findElement(By.xpath(
                "//div[contains(@class,'test-cycle-row') and contains(normalize-space(.),'" + testCycleName + "')]"));
    }



    // after clicking on the click test run button

    private WebElement requirementById(String requirementId) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + requirementId + "')]"));
    }

    private WebElement testCaseCheckboxById(String testCaseId) {
        return driver.findElement(By.xpath("//div[contains(@class,'testlistrow1')]//a[normalize-space()='" + testCaseId
                + "']/ancestor::div[contains(@class,'testlistrow1')]//input[@type='checkbox']"));
    }

    // ================= METHODS =================

    public void clickOnSuite(String suiteName) {
        suiteByName(suiteName).click();
    }

    public void clickExecuteTab() {
        wait.until(ExpectedConditions.elementToBeClickable(tabexceute)).click();
    }

    public void clickArrowRightToExpandModule(String moduleName) {
        wait.until(ExpectedConditions.elementToBeClickable(arrowRightToExpand(moduleName))).click();
    }

    public void clickArrowDownToCollapseModule(String moduleName) {
        wait.until(ExpectedConditions.elementToBeClickable(arrowRightToExpand(moduleName))).click();
    }

    // ================= METHOD =================

    // Methods for landing execute test case page
    public void clickProjectByName(String projectName) {
        WebElement project = allProjects.stream()
                .filter(p -> p.getText().trim().contains(projectName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Project not found: " + projectName));
        actions.moveToElement(project).click().perform();
    }

    public void clickOnProject(){
        driver.findElement(By.xpath("//div[@class='project ']")).click();
    }

    // ================= METHODS =================

    // public void clickArrowRightPointingForExpandModule(String moduleName) {
    // WebElement arrow = expandArrows.stream()
    // .filter(e ->
    // e.findElement(By.xpath("./..")).getText().trim().contains(moduleName))
    // .findFirst()
    // .orElseThrow(() -> new NoSuchElementException("Arrow for module not found: "
    // + moduleName));
    // actions.moveToElement(arrow).click().perform();
    // }

    public void clickArrowRightPointingForExpandModule(String moduleName) throws InterruptedException {
        arrowRightToExpand(moduleName).click();
        Thread.sleep(1500);
    }

    public WebElement selectedModuleOrReleaseName(String name) {
        By locator = By.xpath(
                "//div[(contains(@class,'project') or contains(@class,'releases')) and contains(normalize-space(.),'"
                        + name + "')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickRelease(String releaseName) {
        wait.until(ExpectedConditions.elementToBeClickable(releaseByName(releaseName))).click();
    }

    public void expandRelease(String releaseName) {
        WebElement release = wait.until(ExpectedConditions.elementToBeClickable(releaseByName(releaseName)));
        actions.moveToElement(release).click().perform();
    }

    public boolean isReleaseVisible(String releaseName) {
        return wait.until(ExpectedConditions.visibilityOf(releaseByName(releaseName))).isDisplayed();
    }

    public void expandSubTestCycle(String testCycleName) {
        WebElement cycle = wait.until(ExpectedConditions.elementToBeClickable(testCycleByName(testCycleName)));
        actions.moveToElement(cycle).click().perform();
    }

    public boolean isSubTestCycleVisible(String testCycleName) {
        return wait.until(ExpectedConditions.visibilityOf(testCycleByName(testCycleName))).isDisplayed();
    }

    private WebElement TestsuiteByName(String suiteName) {
        return driver.findElement(
                By.xpath("//div[contains(@class,'test-suite-row') and contains(normalize-space(.),'" + suiteName + "')]"));
    }

    public boolean isSuitVisible(String testsuitName)
    {
        return wait.until(ExpectedConditions.visibilityOf(TestsuiteByName(testsuitName))).isDisplayed();
    }

    // methods for individual release page
    public void selectAssignToMe() {
        wait.until(ExpectedConditions.elementToBeClickable(assignToMeRadio)).click();
    }

    public void selectViewAll() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllRadio)).click();
    }

    public boolean isAssignToMeSelected() {
        return assignToMeRadio.isSelected();
    }

    public boolean isViewAllSelected() {
        return viewAllRadio.isSelected();
    }

    public void selectStatus(String status) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)));
        select.selectByVisibleText(status);
    }

    public String getSelectedStatus() {
        return new Select(statusDropdown).getFirstSelectedOption().getText();
    }

    public void clickCreateTestRunButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createTestRunButton)).click();
    }

    public void selectTestCaseCheckbox(String testCaseId) {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(testCaseCheckboxById(testCaseId)));
        if (!checkbox.isSelected())
            checkbox.click();
    }

    public boolean isTestCaseCheckboxSelected(String testCaseId) {
        return testCaseCheckboxById(testCaseId).isSelected();
    }

    public void clickTestRunById(String testRunId) throws InterruptedException {
        Thread.sleep(1500);
        WebElement testRun = testRunLinks.stream()
                .filter(e -> e.getText().trim().equals(testRunId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Test Run ID not found: " + testRunId));
        actions.moveToElement(testRun).click().perform();
    }

    public WebElement getTestRunById(String testRunId) {
        return testRunLinks.stream()
                .filter(e -> e.getText().trim().equals(testRunId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Test Run ID not found: " + testRunId));
    }

    // methods for pop after clicking the click test run button
    public void clickRequirementById(String requirementId) {
        wait.until(ExpectedConditions.elementToBeClickable(requirementById(requirementId))).click();
    }

    public void clickSaveInPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonInPopup)).click();
    }

    public void clickCancelInPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButtonInPopup)).click();
    }

    public boolean checkIfNextButtonIsClickable() {
        return "pointer"
                .equals(wait.until(ExpectedConditions.visibilityOf(arrowForwardNextPagination)).getCssValue("cursor"));
    }

    public void clickNextArrow() {
        actions.moveToElement(arrowForwardNextPagination).click().perform();
    }

    public void clickPreviousArrow() {
        if (checkIfPreviousButtonIsClickable()) {
            actions.moveToElement(arrowBackwardPrevious).click().perform();
        }
    }

    public boolean checkIfPreviousButtonIsClickable() {
        return "pointer"
                .equals(wait.until(ExpectedConditions.visibilityOf(arrowBackwardPrevious)).getCssValue("cursor"));
    }

    public void selectFeature(String featureName) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(dropdownFeature)));
        select.selectByVisibleText(featureName);
    }

    public int getCountRQInFeature() {
        return rqCountWrapper.size();
    }

    public String showPaginationOfRequirement() {
        return wait.until(ExpectedConditions.visibilityOf(divRequirementPagination)).getText();
    }

    public void searchTestCase(String testCaseID) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchfield));
        wait.until(ExpectedConditions.elementToBeClickable(searchfield));
        searchfield.clear();
        searchfield.sendKeys(testCaseID);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getTestRunIdCount(){
        By assignedToMe = By.xpath("//label[normalize-space()='Assigned to me']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Try waiting for visibility
            wait.until(ExpectedConditions.visibilityOfElementLocated(assignedToMe));
            return allTestRunIds.size();

        } catch (Exception e) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(assignedToMe));
            return allTestRunIds.size();
        }
    }

    public void clickOnClearButton(){
        By assignedToMe = By.xpath("//label[normalize-space()='Assigned to me']");
        Actions a= new Actions(driver);
        a.moveToElement(buttonClear).perform();
        buttonClear.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignedToMe));
    }
    public String [] getAllTestRunIds(){
        List<String> a= new ArrayList<>();
        for (WebElement element : allTestRunIds){
            a.add(element.getText());
        }
        return a.toArray(new String[0]);
    }

    public boolean getVisibilityOfTestRunsWithCaseDetailsTable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(tableTestRunsWithCaseDetails));
        return tableTestRunsWithCaseDetails.isDisplayed();
    }

    public void clickPlayActionById(String tcIO) throws InterruptedException {
        Thread.sleep(2000);
        new Actions(driver).moveToElement(buttonActionPlay(tcIO)).perform();
        buttonActionPlay(tcIO).click();
    }

    public String getCurrentPageNumber() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(currentPageNumber));
        return currentPageNumber.getText().trim();
    }

}
