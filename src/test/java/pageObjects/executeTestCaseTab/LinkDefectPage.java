package pageObjects.executeTestCaseTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class LinkDefectPage extends BasePage {

    //Constructor

    private WebDriver driver;
    private WebDriverWait wait;

    public LinkDefectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30-second timeout
    }

    // locators
    @FindBy(xpath = "//input[@placeholder='Enter Defect ID/Summary']")
    WebElement inputSearchDefect;

    @FindBy(xpath = "//div[contains(@class, 'search')]")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@name='defectOption']")
    WebElement checkBoxOnlyForSearchedDefect;

    @FindBy(xpath = "//div[normalize-space(text()) = 'CANCEL']")
    WebElement cancelBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'LINK']")
    WebElement linkBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'NEW']")
    WebElement newBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'CLOSE']")
    WebElement closeBtn;

// locators for creating a new bug

    @FindBy(xpath = "//textarea[@id='DefSummary']")
    WebElement summaryInput;

    @FindBy(xpath = "//select[@id='SeverityDropdown']")
    WebElement dropdownSeverity;

    @FindBy(xpath = "//select[@id='FixedReleaseBuildDropdown']")
    WebElement dropdownFixedReleaseBuild;

    @FindBy(xpath = "//select[@id='ReasonDropdown']")
    WebElement dropdownReason;

    @FindBy(xpath = "//select[@id='CategoryDropdown']")
    WebElement dropdownCategory;

    @FindBy(xpath = "//select[@id='TypeDropdown']")
    WebElement dropdownType;

    @FindBy(xpath = "//select[@id='TargetReleaseBuildDropdown']")
    WebElement dropdownTargetReleaseBuild;

    @FindBy(xpath = "//select[@id='StatusDropdown']")
    WebElement dropdownStatus;

    @FindBy(xpath = "//select[@id='PriorityDropdown']")
    WebElement dropdownPriority;

    @FindBy(xpath = "//button[@id='browse-button']")
    WebElement browseFileBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'SAVE']")
    WebElement saveBtn;

    @FindBy(xpath = "//span[@id='affected_release_display']")
    WebElement getAffectedReleaseName;

    @FindBy(xpath = "//span[contains(text(), 'Default Module')]")
    WebElement getModuleName;

    @FindBy(xpath = "//textarea[@class='defect-text-wrapper-5']")
    WebElement descriptionInputArea;


    // Actions
    public void enterDefectSearch(String defectIdOrSummary) {
        wait.until(ExpectedConditions.visibilityOf(inputSearchDefect)).sendKeys(defectIdOrSummary);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    public void checkDefectCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxOnlyForSearchedDefect)).click();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
    }

    public void clickLink() {
        wait.until(ExpectedConditions.elementToBeClickable(linkBtn)).click();
    }

    public void clickNew() {
        wait.until(ExpectedConditions.elementToBeClickable(newBtn)).click();
    }

    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }

    public void enterSummary(String summary) {
        wait.until(ExpectedConditions.visibilityOf(summaryInput)).sendKeys(summary);
    }

    public void selectSeverity(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownSeverity));
        new Select(dropdownSeverity).selectByVisibleText(value);
    }

    public void selectFixedReleaseBuild(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownFixedReleaseBuild));
        new Select(dropdownFixedReleaseBuild).selectByVisibleText(value);
    }

    public void selectReason(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownReason));
        new Select(dropdownReason).selectByVisibleText(value);
    }

    public void selectCategory(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownCategory));
        new Select(dropdownCategory).selectByVisibleText(value);
    }

    public void selectType(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownType));
        new Select(dropdownType).selectByVisibleText(value);
    }

    public void selectTargetReleaseBuild(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownTargetReleaseBuild));
        new Select(dropdownTargetReleaseBuild).selectByVisibleText(value);
    }

    public void selectStatus(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownStatus));
        new Select(dropdownStatus).selectByVisibleText(value);
    }

    public void selectPriority(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownPriority));
        new Select(dropdownPriority).selectByVisibleText(value);
    }

    public void uploadFile(String filePath) {
        wait.until(ExpectedConditions.elementToBeClickable(browseFileBtn)).sendKeys(filePath);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    public String getAffectedReleaseName() {
        return wait.until(ExpectedConditions.visibilityOf(getAffectedReleaseName)).getText();
    }

    public String getModuleName() {
        return wait.until(ExpectedConditions.visibilityOf(getModuleName)).getText();
    }

    public void enterDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionInputArea)).sendKeys(description);
    }

}
