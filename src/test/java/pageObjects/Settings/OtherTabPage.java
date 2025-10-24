package pageObjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class OtherTabPage extends BasePage {

    public OtherTabPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ----------------------------- Diff Tab locators ---------------------------------------------
    @FindBy(xpath = "//div[@class='releases active']")
    WebElement globalFieldSetting;

    @FindBy(xpath = "//div[@class='releases '][normalize-space()='Module']")
    WebElement module;

    @FindBy(xpath = "//div[normalize-space()='Requirement']")
    WebElement requirement;

    @FindBy(xpath = "//div[contains(@class,'releases')][normalize-space()='Test Case']")
    WebElement testCase;

    @FindBy(xpath = "//div[contains(@class,'releases')][normalize-space()='Test Step']")
    WebElement testStep;

    @FindBy(xpath = "//div[contains(@class,'releases')][normalize-space()='Test Cycle']")
    WebElement testCycle;

    @FindBy(xpath = "//div[contains(@class,'releases')][normalize-space()='Test Suite']")
    WebElement testSuite;

    @FindBy(xpath = "//div[contains(@class,'releases')][normalize-space()='Test Runs']")
    WebElement testRuns;

    @FindBy(xpath = "//div[normalize-space()='Defect']")
    WebElement defect;

    // ----------------------------- Diff Tab actions ---------------------------------------------
    public void clickGlobalFieldSetting() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(globalFieldSetting)).click();
    }

    public void clickModule() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(module)).click();
    }

    public void clickRequirement() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(requirement)).click();
    }

    public void clickTestCase() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(testCase)).click();
    }

    public void clickTestStep() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(testStep)).click();
    }

    public void clickTestCycle() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(testCycle)).click();
    }

    public void clickTestSuite() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(testSuite)).click();
    }

    public void clickTestRuns() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(testRuns)).click();
    }

    public void clickDefect() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(defect)).click();
    }

    // ----------------------------- Common tab locators ------------------------------------------
    @FindBy(xpath = "//button[@id='createRequirementButton']")
    WebElement addCustomField;

    @FindBy(xpath = "//div[@class='bulk-actions-container']//button[1]")
    WebElement saveChangesButton;

    @FindBy(xpath = "//span[normalize-space()='SELECT ALL']")
    WebElement selectAllButton;

    @FindBy(xpath = "//span[normalize-space()='CLEAR ALL']")
    WebElement clearAllButton;

    @FindBy(xpath = "//span[normalize-space()='RESET']")
    WebElement resetButton;

    @FindBy(xpath = "//button[normalize-space()='ADD DEFAULT VALUE']")
    WebElement editDefaultValueButton;

    @FindBy(xpath = "//button[normalize-space()='CLOSE']")
    WebElement editCloseButton;

    @FindBy(xpath = "//span[normalize-space()='SAVE CHANGES']")
    WebElement editSaveChangesButton;

    @FindBy(xpath = "//input[@placeholder='Enter default value']")
    WebElement editFillDefaultValue;

    @FindBy(xpath = "//div[@title='Remove default value']//i[@class='fa-solid fa-trash']")
    WebElement editDefaultDeleteIcon;

    // ----------------------------- Common tab actions -------------------------------------------
    public void clickOnSaveChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(saveChangesButton)).click();
    }

    public WebElement checkboxForRow(String rowName) {
        return driver.findElement(By.xpath(
                "//p[normalize-space()='" + rowName + "']/../../..//input[@type='checkbox']"
        ));
    }

    public WebElement editButtonForRow(String rowName) {
        return driver.findElement(By.xpath(
                "//p[normalize-space()='" + rowName + "']/../../..//i[@class='fa-solid fa-pencil']"
        ));
    }

    public WebElement deleteButtonForRow(String rowName) {
        return driver.findElement(By.xpath(
                "//p[normalize-space()='" + rowName + "']/../../..//i[@class='fa-solid fa-trash']"
        ));
    }

    public void clickOnAddGlobalField() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addCustomField)).click();
    }

    public void clickOnSelectAll() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectAllButton)).click();
    }

    public void clickOnClearAll() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(clearAllButton)).click();
    }

    public void clickOnReset() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(resetButton)).click();
    }

    public void clickOnCheckbox(String rowName) {
        WebElement checkbox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkboxForRow(rowName)));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickOnEdit(String rowName) {
        WebElement editBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(editButtonForRow(rowName)));
        editBtn.click();
    }

    public void clickOnDelete(String rowName) {
        WebElement deleteBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(deleteButtonForRow(rowName)));
        deleteBtn.click();
    }

    public void clickDefaultAddValue() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(editDefaultValueButton)).click();
    }

    public void clickDefaultCloseButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(editCloseButton)).click();
    }

    public void clickDefaultSaveChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(editSaveChangesButton)).click();
    }

    public void enterDefaultValue(String value) {
        WebElement input = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(editFillDefaultValue));
        input.clear();
        input.sendKeys(value);
    }

    public void clickDefaultDeleteIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(editDefaultDeleteIcon)).click();
    }

    // ----------------------------- Add Custom Field locators ------------------------------------
    @FindBy(xpath = "//input[@placeholder='Enter field name (e.g., Priority, Category)']")
    WebElement createCustomFieldName;

    @FindBy(xpath = "//span[normalize-space()='CREATE FIELD']")
    WebElement createCustomFieldButton;

    @FindBy(xpath = "//button[normalize-space()='CANCEL']")
    WebElement createCustomCancelButton;

    @FindBy(xpath = "//select[@class='assignToDropdown testcase-text-wrapper-15 testcase-select']")
    WebElement createCustomDataTypeDropdown;

    // ----------------------------- Add Custom Field actions -------------------------------------
    public void createCustomEnterFieldName(String fieldName) {
        WebElement input = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(createCustomFieldName));
        input.clear();
        input.sendKeys(fieldName);
    }

    public void createCustomSelectDataType(String value) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createCustomDataTypeDropdown));
        Select dropdown = new Select(createCustomDataTypeDropdown);
        dropdown.selectByVisibleText(value);
    }

    public void createCustomClickFieldButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createCustomFieldButton)).click();
    }

    public void createCustomClickCancelButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createCustomCancelButton)).click();
    }
}
