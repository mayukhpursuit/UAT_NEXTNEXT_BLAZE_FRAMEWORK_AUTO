package pageObjects.testPlanTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageObjects.BasePage;

public class IndividualTestSuitePage extends BasePage {
    public IndividualTestSuitePage(WebDriver driver){
        super(driver);
    }

    // locators
    @FindBy(xpath = "//div[@class='test-plan-test-suites-text-3']")
    private WebElement testSuiteIdText;

    @FindBy(xpath = "//input[@class='test-plan-test-suites-supporting-text']")
    private WebElement testSuiteNameInput;

    @FindBy(id = "submitButton")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='test-plan-test-suites-prototype']//em[contains(text(),'Click to add description')]")
    private WebElement descriptionEditor;

    @FindBy(xpath = "(//input[@type='date'])[1]")
    private WebElement plannedStartDateInput;

    @FindBy(xpath = "(//input[@type='date'])[2]")
    private WebElement plannedEndDateInput;

    @FindBy(id = "testcase-select")
    private WebElement targetReleaseInput;

    @FindBy(xpath = "(//select[@class='test-execution-text'])[1]")
    private WebElement environmentDropdown;

    @FindBy(xpath = "(//select[@class='test-execution-text'])[2]")
    private WebElement executionTypeDropdown;

    @FindBy(xpath = "(//select[@class='test-execution-text'])[3]")
    private WebElement testDataSourceDropdown;

    // actions
    public String getTestSuiteId() {
        return testSuiteIdText.getText();
    }

    public void enterTestSuiteName(String name) {
        testSuiteNameInput.clear();
        testSuiteNameInput.sendKeys(name);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void enterDescription(String desc) {
        descriptionEditor.click();
        descriptionEditor.clear();
        descriptionEditor.sendKeys(desc);
    }

    public void setPlannedStartDate(String date) {
        plannedStartDateInput.sendKeys(date);
    }

    public void setPlannedEndDate(String date) {
        plannedEndDateInput.sendKeys(date);
    }

    public String getTargetRelease() {
        return targetReleaseInput.getAttribute("value");
    }

    public void selectEnvironment(String env) {
        Select select = new Select(environmentDropdown);
        select.selectByVisibleText(env);
    }

    public void selectExecutionType(String type) {
        Select select = new Select(executionTypeDropdown);
        select.selectByVisibleText(type);
    }

    public void selectTestDataSource(String source) {
        Select select = new Select(testDataSourceDropdown);
        select.selectByVisibleText(source);
    }
}
