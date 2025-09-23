package pageObjects.requirementTab;

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

    @FindBy(xpath = "//input[@id='testCaseName']")
    WebElement textRequirementId;

    @FindBy(xpath = "//div[@class='testcase-prototype']")
    WebElement textRequirementDescriptionBeforeClick;

    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    WebElement textRequirementDescriptionAfterClick;

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

    //actions

    public void setRequirementId(String id){
        textRequirementId.sendKeys(id);
    }

    public void setDescription(String description) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the description (readonly)
        textRequirementDescriptionBeforeClick.click();

        // Wait until editable input/textarea is visible
        WebElement editableField = wait.until(ExpectedConditions.visibilityOf(textRequirementDescriptionAfterClick));

        // Send description
        editableField.sendKeys(description);
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

}
