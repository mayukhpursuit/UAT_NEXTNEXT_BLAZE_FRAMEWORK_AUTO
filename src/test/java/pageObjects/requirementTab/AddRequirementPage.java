package pageObjects.requirementTab;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class AddRequirementPage extends BasePage {
    public AddRequirementPage(WebDriver driver){
        super(driver);
    }
    //locators

    @FindBy(xpath = "//div[@class='testcase-text-3']")
    WebElement getTextRequirementId;

    @FindBy(xpath = "//input[@id='testCaseName']")
    WebElement textRequirementId;

    @FindBy(xpath = "//div[@class='testcase-prototype']")
    WebElement textRequirementDescriptionBeforeClick;

    @FindBy(xpath = "//div[@class='rte-editor ql-container ql-snow']/div[@contenteditable='true']")
    WebElement textRequirementDescriptionAfterClick;

    @FindBy(xpath = "//div[@class='ql-editor']")
    WebElement textRequirementDescriptionAfterClickWhenItIsNotBlank;

    @FindBy(xpath = "//button[@id='saveButton']")
    WebElement buttonSave;

    @FindBy(xpath = "//button[@id='createRequirementButton']")
    WebElement addRequirementBtn;

    @FindBy(xpath = "//select[option[contains(text(), 'Select Priority')]]")
    WebElement dropDownPriority;

    @FindBy(xpath = "//select[option[contains(text(), 'Select Status')]]")
    WebElement dropDownStatus;

    @FindBy(xpath = "//select[option[contains(text(), 'Select Type')]]")
    WebElement dropDownType;

    @FindBy(xpath = "//button[@id='closeButton']")
    WebElement buttonClose;

    @FindBy(xpath = "//img[@id='rotatable-image']")
    WebElement requirementExpandCollapseArrow;

    @FindBy(xpath = "//div[contains(text(),'Requirement updated successfully.')]")
    WebElement requirementUpdatedSuccessMessage;

    @FindBy(id = "notification")
    WebElement errorNotification;

    //actions

    public void setRequirementId(String id){
        textRequirementId.sendKeys(id);
    }

    public void setDescription(String description) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(textRequirementDescriptionBeforeClick));
        textRequirementDescriptionBeforeClick.click();
//        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(textRequirementDescriptionAfterClick));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", textRequirementDescriptionAfterClick);
        textRequirementDescriptionAfterClick.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textRequirementDescriptionAfterClick.sendKeys(Keys.BACK_SPACE);
        textRequirementDescriptionAfterClick.clear();
        textRequirementDescriptionAfterClick.sendKeys(description);
    }
    public void clickAddRequirementBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addRequirementBtn.click();
    }
    public void selectPriority(String priority){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownPriority));
        Select s= new Select(dropDownPriority);
        s.selectByVisibleText(priority);
    }
    public void selectStatus(String status){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownStatus));
        Select s= new Select(dropDownStatus);
        s.selectByVisibleText(status);
    }
    public void selectType(String type){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownType));
        Select s= new Select(dropDownType);
        s.selectByVisibleText(type);
    }

    public void clickSave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave));
        buttonSave.click();
    }
    public void clickClose(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonClose));
        buttonClose.click();
    }
    public void requirementDetailsVisibility(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(requirementExpandCollapseArrow));
        requirementExpandCollapseArrow.click();
    }
    public String getRequirementIdName(){
        return getTextRequirementId.getText();
    }

    public boolean isModulePageReopened() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(addRequirementBtn));
            return addRequirementBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public String getRequirementUpdatedSuccessMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(requirementUpdatedSuccessMessage));
        return requirementUpdatedSuccessMessage.getText();
    }



    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorNotification));
        return errorNotification.getText().trim();
    }

    public String getRequirementDescription(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editableField = wait.until(ExpectedConditions.visibilityOf(textRequirementDescriptionBeforeClick));
        return editableField.getText();
    }

    public void clickOnRequirementIdLabel(){
        textRequirementId.click();
    }

}
