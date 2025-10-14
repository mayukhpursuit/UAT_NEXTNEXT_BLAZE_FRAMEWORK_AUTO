package pageObjects.executeTestCaseTab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class IndividualTestRun extends BasePage {
    public IndividualTestRun(WebDriver driver){
        super(driver);
    }

    // Locators

    @FindBy(xpath = "//div[@class='test-run-text-3']")
    WebElement labelTestRunId;

    @FindBy(xpath = "//div[@class='test-run-name']")
    WebElement headingTestRunName;

    @FindBy (xpath = "//div[@class='test-run-form-text-field']//select[@class='test-run-text select-dropdown']")
    WebElement dropdownStatus;

    @FindBy(xpath = "//button[@id='submitButton']")
    WebElement buttonSave;

    @FindBy(xpath = "//button[@id='newLogButton']")
    WebElement buttonCreateTestLog;

    @FindBy(xpath = "//button[@id='closeButton']")
    WebElement buttonClose;

    @FindBy(xpath = "//div[@id='notification']")
    WebElement notificationAfterEdit;

    @FindBy(xpath = "//button[@id='linkDefectBtn']")
    WebElement buttonLinkDefect;

    @FindBy(xpath = "//button[@id='linkAttachmentBtn']")
    WebElement buttonLinkAttachment;

    @FindBy(xpath = "//div[normalize-space()='Test Logs']")
    WebElement tabTestLogs;

    @FindBy(xpath = "//div[normalize-space()='Execution History']")
    WebElement tabExecutionHistory;

    @FindBy(xpath = "//input[@id='viewAll']")
    WebElement radioShowAllSteps;

    @FindBy(xpath = "//input[@id='businessStep']")
    WebElement radioShowBusinessSteps;

    @FindBy(xpath = "//div[@class='test-run-form-text-field-2']//select[@class='test-run-text select-dropdown']")
    WebElement dropdownOverallStatusBesidesUpdate;

    @FindBy(xpath = "//button[@id='selectedStepsButton']")
    WebElement buttonUpdate;

    @FindBy(xpath = "//input[@id='masterCheckbox']")
    WebElement checkBoxSelectAllSteps;

    public WebElement checkboxForSteps(int stepNo){
        return driver.findElement(By.xpath("//div[normalize-space()='"+stepNo+"']/../div[@class='table-row-cell checkbox-cell']"));
    }

    public WebElement uatCategoryForSteps(int stepNo){
        return driver.findElement(By.xpath("//div[normalize-space()='"+stepNo+"']/../div[@class='table-row-cell uat-category']"));
    }

    public WebElement descriptionForSteps(int stepNo){
        return driver.findElement(By.xpath("//div[normalize-space()='"+stepNo+"']/../div[@class='table-row-cell name']"));
    }

    public WebElement expectedResultForSteps(int stepNo){
        return driver.findElement(By.xpath("//div[normalize-space()='"+stepNo+"']/../div[@class='table-row-cell expected-result']"));
    }

    public WebElement actualResultForSteps(int stepNo){
        return driver.findElement(By.xpath("//div[normalize-space()='"+stepNo+"']/..//textarea[@class='non-expandable-textarea']"));
    }

    public WebElement statusForSteps(int stepNo){
        return driver.findElement(By.xpath("//div[normalize-space()='"+stepNo+"']/..//select[@class='test-run-text select-dropdown']"));
    }





    //Actions



    Actions a= new Actions(driver);
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));

    public String getTestRunName(){
        return labelTestRunId.getText();
    }

    public void clickSaveButton(){
        a.moveToElement(buttonSave).perform();
        buttonSave.click();
        wait.until(ExpectedConditions.visibilityOf(notificationAfterEdit));
    }

    public void clickCloseButton(){
        a.moveToElement(buttonClose).perform();
        buttonClose.click();
    }

    public void clickCreateTestLog(){
        a.moveToElement(buttonCreateTestLog).perform();
        buttonCreateTestLog.click();
    }

    public void selectStatus(String statusTxt){
        Select s= new Select(dropdownStatus);
        dropdownStatus.click();
        s.selectByVisibleText(statusTxt);
    }

    public void clickLinkDefect(){
        a.moveToElement(buttonLinkDefect).perform();
        buttonLinkDefect.click();
    }

    public void clickLinkAttachment(){
        a.moveToElement(buttonLinkAttachment).perform();
        buttonLinkAttachment.click();
    }

    public void clickTabTestLogs(){
        a.moveToElement(tabTestLogs).perform();
        tabTestLogs.click();
    }

    public void clickTabExecutionHistory(){
        a.moveToElement(tabExecutionHistory).perform();
        tabExecutionHistory.click();
    }

    public void selectDropdownStatusBesidesUpdate(String statusText){
        Select s= new Select(dropdownOverallStatusBesidesUpdate);
        dropdownOverallStatusBesidesUpdate.click();
        s.selectByVisibleText(statusText);
    }

    public void clickUpdate(){
        a.moveToElement(buttonUpdate).perform();
        buttonClose.click();
    }

    public void clickShowAllStepsRadio(){
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='viewAll']"))
        );

        checkbox.click();

    }

    public void clickShowOnlyBusinessStepsRadio(){
        radioShowBusinessSteps.click();
    }

    public void selectCheckAllStepsCheckbox(){
        checkBoxSelectAllSteps.click();
    }

    public void clickCheckboxOfTheStep(int stepNo){
        checkboxForSteps(stepNo).click();
    }

    public void EnterActualResultOfTheStep(int stepNo,String actualResultText){
        a.moveToElement(actualResultForSteps(stepNo)).perform();
        actualResultForSteps(stepNo).click();
        actualResultForSteps(stepNo).sendKeys(actualResultText);
    }

    public void SelectStatusOfTheStep(int stepNo,String stepText){
        a.moveToElement(statusForSteps(stepNo)).perform();
        statusForSteps(stepNo).click();
        Select s= new Select(statusForSteps(stepNo));
        s.selectByVisibleText(stepText);
    }

}
