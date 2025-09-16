package pageObjects.authoTestCaseTab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class IndividualTestCasePage extends BasePage {
    public IndividualTestCasePage(WebDriver driver){
        super(driver);
    }
    // Locators
    @FindBy(xpath = "//div[normalize-space()='CLOSE']")
    WebElement buttonClose;

    @FindBy(xpath = "//div[normalize-space()='Create Test Run']")
    WebElement buttonCreateTestRun;

    @FindBy(xpath = "//div[normalize-space()='SAVE']")
    WebElement buttonSave;

    @FindBy(xpath = "//input[@id='testCaseName']")
    WebElement headingTestCaseName;

    @FindBy(xpath = "//div[@class='test-plan-releases-prototype']")
    WebElement textDescriptionBeforeClick;

    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    WebElement textDescriptionAfterClick;

    @FindBy(xpath = "//textarea[@id='precondition']")
    WebElement textPrecondition;

    @FindBy(xpath = "//div[@id='priority']//select[@class='testcase-select value']")
    WebElement dropDownPriority;

    @FindBy(xpath = "//div[@id='priority']//select[@class='testcase-select value']/option")
    List<WebElement> OptionsDropDownPriority;

    @FindBy(xpath = "//div[@id='status']//select[@class='testcase-select value']")
    WebElement dropdownStatus;

    @FindBy(xpath = "//div[@id='status']//select[@class='testcase-select value']")
    List<WebElement> OptionsDropdownStatus;

    @FindBy(xpath = "//div[@id='type']//select[@class='testcase-select value']")
    WebElement dropdownType;

    @FindBy(xpath = "//div[@id='type']//select[@class='testcase-select value']/option")
    List<WebElement> OptionsDropdownType;

    @FindBy(xpath = "//div[@id='automation']//select[@class='testcase-select value']")
    WebElement dropdownAutomationProgress;

    @FindBy(xpath = "//div[@id='automation']//select[@class='testcase-select value']/option")
    WebElement OptionsDropdownAutomationProgress;

    @FindBy(xpath = "//div[@id='qa-user']//select[@class='testcase-select value']")
    WebElement dropDownQaUser;

    @FindBy(xpath = "//div[@id='qa-user']//select[@class='testcase-select value']/option")
    List<WebElement> OptionsDropDownQaUser;

    @FindBy(xpath = "//input[@id='hideTechnical']")
    WebElement CheckboxHideTechnical;

    @FindBy(xpath = "//button[@id='addcalledTestCase']")
    WebElement buttonAddCalledTestCase;

    @FindBy(xpath = "//button[@id='addRowIcon']")
    WebElement buttonAddTestStep;

    @FindBy(xpath = "//span[@class='step-number']")
    List<WebElement> allSteps;

    public WebElement labelStepNo(String s){
        return driver.findElement(By.xpath("//span[@class='step-number' and text()='"+s+"']"));
    }

    public WebElement textStepDescriptionBeforeClick(int stepNo){
        return driver.findElement(By.xpath("//span[@class='step-number' and text()='"+stepNo+"']/ancestor::div[@class='table-row']//div[@class='table-cell description']"));
    }

    public WebElement textStepDescriptionAfterClick(int stepNo){
        return driver.findElement(By.xpath("//span[@class='step-number' and text()='"+stepNo+"']/ancestor::div[@class='table-row']//div[@class='table-cell description']//div[@class='ql-editor ql-blank']"));
    }


    public WebElement textExpectedResultBeforeClick(int stepNo){
        return driver.findElement(By.xpath("//span[@class='step-number' and text()='"+stepNo+"']/ancestor::div[@class='table-row']//div[@class='table-cell result']"));
    }

    public WebElement textStepResultAfterClick(int stepNo){
        return driver.findElement(By.xpath("//span[@class='step-number' and text()='"+stepNo+"']/ancestor::div[@class='table-row']//div[@class='table-cell result']//div[@class='ql-editor ql-blank']"));
    }

    public WebElement buttonDeleteAction(int stepNo){
        return driver.findElement(By.xpath("//span[@class='step-number' and text()='"+stepNo+"']/ancestor::div[@class='table-row']//div[@class='table-cell action']//button"));
    }

    @FindBy(xpath = "(//i[@class='fa-solid fa-circle-plus'])[1]")
    WebElement buttonAddRow;

    //    Actions
    public void ClickCloseButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonClose)).click();
    }
    public boolean isModelDisplayed()
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOf(buttonClose)).isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void clickAddTestStep() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions a= new Actions(driver);
        a.moveToElement(buttonAddTestStep).perform();
        buttonAddTestStep.click();
    }
    public void clickAddRow() {
        buttonAddRow.click();
    }
    public String getStepCount(String s)
    {
        return labelStepNo(s).getText();
    }

    public void setStepDescription(String description, int step) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement beforeClick = wait.until(ExpectedConditions
                .elementToBeClickable(textStepDescriptionBeforeClick(step)));
        actions.moveToElement(beforeClick).perform();
        beforeClick.click();
        WebElement afterClick = wait.until(ExpectedConditions
                .elementToBeClickable(textStepDescriptionAfterClick(step)));
        Thread.sleep(1000);
        afterClick.clear();
        afterClick.sendKeys(description);
    }

    public void setStepExpectedResult(String expectedResult, int step) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement beforeClick = wait.until(ExpectedConditions
                .elementToBeClickable(textExpectedResultBeforeClick(step)));

        actions.moveToElement(beforeClick).perform();
        beforeClick.click();


        WebElement afterClick = wait.until(ExpectedConditions
                .elementToBeClickable(textStepResultAfterClick(step)));
        Thread.sleep(1000);
        afterClick.clear();
        afterClick.sendKeys(expectedResult);
    }

    public void clickDeleteButton(int stepCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement deleteButton = wait.until(ExpectedConditions
                .elementToBeClickable(buttonDeleteAction(stepCount)));
        actions.moveToElement(deleteButton).click().perform();
    }

    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement saveBtn = wait.until(ExpectedConditions
                .elementToBeClickable(buttonSave));
        actions.moveToElement(saveBtn).click().perform();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//div[@id='notification']"),
                "Test Case updated successfully."
        ));
    }


    public void addTestStepsFromExcelForNewTestCase(String description,String expectedResult) throws InterruptedException {
        String [] descriptionArray=description.split(",");
        String [] expectedResultArray=expectedResult.split(",");

        for (int i=0;i<=expectedResultArray.length-1;i++) {
            clickAddTestStep();
            setStepDescription(descriptionArray[i], i + 1);
            Thread.sleep(1000);
            setStepExpectedResult(expectedResultArray[i], i + 1);

        }
    }

}
