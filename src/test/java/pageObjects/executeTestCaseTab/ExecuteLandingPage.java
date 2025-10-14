package pageObjects.executeTestCaseTab;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
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


    // locators for create test run

    @FindBy(xpath = "//button[.//div[text()='SAVE']]")
    WebElement saveButtonInPopup;

    @FindBy(id = "closeModal")
    WebElement cancelButtonInPopup;

    // ================= ACTIONS =================

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions actions = new Actions(driver);

    // execute landing page

    private WebElement arrowRightToExpand(String moduleName) {
        return driver.findElement(By.xpath("//div[contains(@class,'project')][contains(normalize-space(.),'"
                + moduleName + "')]//i[contains(@class,'fa-caret-right') and contains(@class,'toggle-icon')]"));
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

    public void clickExecuteTab() {
        wait.until(ExpectedConditions.elementToBeClickable(tabexceute)).click();
    }

    public void clickArrowRightToExpandModule(String moduleName) {
        wait.until(ExpectedConditions.elementToBeClickable(arrowRightToExpand(moduleName))).click();
    }

    public void clickArrowDownToCollapseModule(String moduleName) {
        wait.until(ExpectedConditions.elementToBeClickable(arrowDownToCollapse(moduleName))).click();
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

    public void clickArrowRightPointingForExpandModule(String moduleName) {
        arrowRightToExpand(moduleName).click();
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

    public void clickTestRunById(String testRunId) {
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

}
