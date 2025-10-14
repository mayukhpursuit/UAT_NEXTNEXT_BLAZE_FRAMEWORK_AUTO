package pageObjects.executeTestCaseTab;

import org.openqa.selenium.*;
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
    @FindBy(xpath = "//span[@id='execute']")
    WebElement tabRequirements;

    @FindBy(xpath = "//button[.//div[text()='SAVE']]")
    private WebElement saveButtonInPopup;

    @FindBy(id = "closeModal")
    private WebElement cancelButtonInPopup;

    @FindBy(id = "assignToMe")
    private WebElement assignToMeRadio;

    @FindBy(id = "viewAll")
    private WebElement viewAllRadio;

    @FindBy(id = "statusDropdown")
    private WebElement statusDropdown;

    @FindBy(id = "createTestRunButton")
    private WebElement createTestRunButton;

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

    // ================= METHODS =================

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    private void safeClick(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            String style = element.getAttribute("style");
            if (style != null && style.contains("opacity: 0.5")) {
                System.out.println("[WARN] Element appears disabled (opacity 0.5). Waiting for activation...");
                Thread.sleep(1000);
            }
            try {
                element.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("[WARN] Click intercepted — retrying with JavaScript...");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }

        } catch (Exception e) {
            System.out.println("[ERROR] safeClick failed for element: " + element + " due to: " + e.getMessage());
        }
    }

    public void waitForPopupToClose() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".popup-defect-modal-frame-7")));
            System.out.println("Popup closed, proceeding.");
        } catch (TimeoutException e) {
            System.out.println("Popup still visible after wait, proceeding anyway.");
        }
    }

    public void clickExecuteTab() throws InterruptedException {
        Thread.sleep(1500);
        tabRequirements.click();
        Thread.sleep(1500);
    }

    private WebElement arrowRightToExpand(String moduleName) {
        String xpath = "//div[contains(@class,'project')][contains(normalize-space(.),'"
                + moduleName + "')]//i[contains(@class,'fa-caret-right') and contains(@class,'toggle-icon')]";
        return driver.findElement(By.xpath(xpath));
    }

    private WebElement arrowDownToCollapse(String moduleName) {
        return driver.findElement(
                By.xpath("//span[normalize-space()='" + moduleName + "']/..//i[contains(@class,'fa-caret-down')]"));
    }

    public void clickArrowRightPointingForExpandModule(String moduleName) {
        arrowRightToExpand(moduleName).click();
    }

    public void clickArrowDownPointingForCollapseModule(String moduleName) {
        arrowDownToCollapse(moduleName).click();
    }

    public void clickRelease(String releaseName) {
        By releaseLocator = By
                .xpath("//div[contains(@class,'releases') and contains(normalize-space(.),'" + releaseName + "')]");
        WebElement release = wait.until(ExpectedConditions.elementToBeClickable(releaseLocator));
        release.click();
    }

    public WebElement selectedModuleOrReleaseName(String name) {
        By locator = By.xpath(
                "//div[(contains(@class,'project') or contains(@class,'releases')) and contains(normalize-space(.),'"
                        + name + "')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

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

    public String getAssignToMeLabel() {
        return driver.findElement(By.xpath("//label[@for='assignToMe']")).getText();
    }

    public String getViewAllLabel() {
        return driver.findElement(By.xpath("//label[@for='viewAll']")).getText();
    }

    public void selectStatus(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown));
        Select select = new Select(statusDropdown);
        select.selectByVisibleText(status);
    }

    public String getSelectedStatus() {
        Select select = new Select(statusDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public void clickCreateTestRunButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createTestRunButton)).click();
    }

    public boolean isCreateTestRunButtonDisplayed() {
        return createTestRunButton.isDisplayed();
    }

    public void clickRequirementById(String requirementId) {
        By requirementLocator = By.xpath("//div[contains(text(),'" + requirementId + "')]");
        WebElement requirement = wait.until(ExpectedConditions.elementToBeClickable(requirementLocator));
        requirement.click();
    }

    public WebElement getRequirementById(String requirementId) {
        By requirementLocator = By
                .xpath("//div[contains(@class,'tree-view-table-row')]//div[contains(text(),'" + requirementId + "')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(requirementLocator));
    }

    public void selectTestCaseCheckbox(String testCaseId) {
        By rowLocator = By.xpath("//div[contains(@class,'testlistrow1')]//a[normalize-space()='" + testCaseId
                + "']/ancestor::div[contains(@class,'testlistrow1')]");
        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));
        WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isTestCaseCheckboxSelected(String testCaseId) {
        By rowLocator = By.xpath("//div[contains(@class,'testlistrow1')]//a[normalize-space()='" + testCaseId
                + "']/ancestor::div[contains(@class,'testlistrow1')]");
        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));
        WebElement checkbox = row.findElement(By.xpath(".//input[@type='checkbox']"));
        return checkbox.isSelected();
    }

    public void clickSaveInPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonInPopup)).click();
    }

    public void clickCancelInPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButtonInPopup)).click();
    }

    public boolean isSaveButtonDisplayed() {
        return saveButtonInPopup.isDisplayed();
    }

    public boolean isCancelButtonDisplayed() {
        return cancelButtonInPopup.isDisplayed();
    }

    public boolean checkIfNextButtonIsClickable() {
        try {
            wait.until(ExpectedConditions.visibilityOf(arrowForwardNextPagination));
            return "pointer".equals(arrowForwardNextPagination.getCssValue("cursor"));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean checkIfPreviousButtonIsClickable() {
        try {
            wait.until(ExpectedConditions.visibilityOf(arrowBackwardPrevious));
            return "pointer".equals(arrowBackwardPrevious.getCssValue("cursor"));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickNextArrow() {
        safeClick(arrowForwardNextPagination, 10);
    }

    public void clickLastPageArrowBtn() {
        safeClick(lastPageArrowBtn, 10);
    }

    public void clickPreviousArrow() {
        if (checkIfPreviousButtonIsClickable()) {
            wait.until(ExpectedConditions.elementToBeClickable(arrowBackwardPrevious)).click();
        }
    }

    public int getCountRQInFeature() throws InterruptedException {
        Thread.sleep(2000);
        return rqCountWrapper.size();
    }

    public String showPaginationOfRequirement() {
        return wait.until(ExpectedConditions.visibilityOf(divRequirementPagination)).getText();
    }

    public boolean getFeatureVisibility() {
        return dropdownFeature.isDisplayed();
    }

    public void selectFeature(String featureName) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownFeature));
        new Select(dropdownFeature).selectByVisibleText(featureName);
    }

    @FindBy(xpath = "//a[contains(@class,'runButton')]")
    private List<WebElement> testRunLinks;

    public void clickTestRunById(String testRunId) {

        WebElement testRunElement = testRunLinks.stream().filter(e -> e.getText().trim().equals(testRunId)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Test Run ID not found: " + testRunId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", testRunElement);
        try {
            testRunElement.click();
        } catch (ElementClickInterceptedException e) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", testRunElement);
        }
    }

    public WebElement getTestRunById(String testRunId) {
        return testRunLinks.stream().filter(e -> e.getText().trim().equals(testRunId)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Test Run ID not found: " + testRunId));
    }

}
