package pageObjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class GlobalTabPage extends BasePage {
    public GlobalTabPage(WebDriver driver) {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//img[@id='chevron-logout']")
    WebElement dropdowncurrentuser;

    @FindBy(xpath = "//a[normalize-space()='Settings']")
    WebElement setting;


    @FindBy(xpath = "//div[@class='global-fields-add-label']")
    WebElement AddGlobalFieldButton;

    @FindBy(xpath = "//div[@class='bulk-actions-container']//button[1]")
    WebElement SaveChangesButton;

    @FindBy(xpath = "//span[normalize-space()='SELECT ALL']")
    WebElement SelectAllButton;

    @FindBy(xpath = "//span[normalize-space()='CLEAR ALL']")
    WebElement ClearAllButton;

    @FindBy(xpath = "//span[normalize-space()='RESET']")
    WebElement ResetButton;

    public WebElement CheckboxForRow(String rowName) {
        return driver.findElement(By.xpath(
                "//p[normalize-space()='+rowName+']/../../..//input[@type='checkbox']"
        ));
    }


    public WebElement SettingsButtonForRow(String rowName) {
        return driver.findElement(By.xpath(
                "//p[normalize-space()='\"+rowName+\"']/../../..//i[@class='fa-solid fa-cog']"
        ));
    }



    public WebElement EditButtonForRow(String rowName) {
        String xpath = "//p[normalize-space()='" + rowName + "']/../../..//i[@class='fa-solid fa-pencil']";
        return driver.findElement(By.xpath(xpath));
    }


    public WebElement DeleteButtonForRow(String rowName) {
        String xpath = "//p[normalize-space()='" + rowName + "']/../../..//i[@class='fa-solid fa-trash']";
        return driver.findElement(By.xpath(xpath));
    }


    //Actions

    public void clickCurrentUserAndGoToSettings() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropdowncurrentuser)).click();
        wait.until(ExpectedConditions.elementToBeClickable(setting)).click();
    }

    public void clickonAddGlobalField() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(AddGlobalFieldButton))
                .click();
    }

    public void clickonSaveChanges() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(SaveChangesButton))
                .click();
    }

    public void clickonSelectAll() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(SelectAllButton))
                .click();
    }

    public void clickonClearAll() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(ClearAllButton))
                .click();
    }

    public void clickonReset() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(ResetButton))
                .click();
    }

    public void clickonCheckbox(String rowName) {
        WebElement checkbox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CheckboxForRow(rowName)));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickonSettings(String rowName) {
        WebElement settingsBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(SettingsButtonForRow(rowName)));
        settingsBtn.click();
    }

    public void clickonEdit(String rowName) {
        WebElement editBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(EditButtonForRow(rowName)));
        editBtn.click();
    }

    public void clickonDelete(String rowName) {
        WebElement deleteBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(DeleteButtonForRow(rowName)));
        deleteBtn.click();
    }
//**********************************************************************************************************************************//

                                    // create global field//
    //Locator
    @FindBy(xpath = "//tbody//tr//td//input[@type='text']")
    WebElement FieldName;

    @FindBy(xpath = "//select[@class='global-fields-select']")
    WebElement DataType;

    @FindBy(xpath = "//div[@class='global-fields-object-types-checkboxes']")
    WebElement ObjectTypes;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='SAVE']")
    WebElement Savebutton;


    @FindBy(xpath = "//form[@id='createGlobalFieldForm']//button[@type='button'][normalize-space()='CLOSE']")
    WebElement CloseButton;



    //Action

    public void EnterFieldName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FieldName));

        FieldName.clear();
        FieldName.sendKeys(name);
    }

    public void SelectDataType(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(DataType));
        Select dropdown = new Select(DataType);
        dropdown.selectByVisibleText(value);
    }

    public void clickObjectTypeCheckbox(String checkboxLabel) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ObjectTypes));
        String xpath = ".//label[contains(normalize-space(.),'" + checkboxLabel + "')]//input[@type='checkbox']";
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                ObjectTypes.findElement(By.xpath(xpath))
        ));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }



    public void clickSaveButton() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Thread.sleep(3000);
        Savebutton.click();
    }




    public void clickCloseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CloseButton));
        CloseButton.click();
    }

//*****************************************************************************************************************************
                        //Manage Object Types - Description(Settings)

    //Locator
    @FindBy(xpath = "//button[@type='button'][normalize-space()='Add']")
    WebElement AddButton;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='Remove']")
    WebElement RemoveButton;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='CLOSE']")
    WebElement closeButton;


    //Action

    public void clickAddButtonForObjectType(String objectType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "///table//tr[td[normalize-space()='"+objectType+"']]//button[normalize-space()='Add']";
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        addButton.click();
    }

    public void clickRemoveButtonForObjectType(String objectType) {
        WebElement removeButton = driver.findElement(By.xpath(
                "//table//tr[td[normalize-space()='"+objectType+"']]//button[normalize-space()='CLOSE']"
        ));
        removeButton.click();
    }

//    public void clickActionForObjectType(String objectType, String actionType) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        String xpath = "//table//tr[td[normalize-space()='" + objectType + "']]//button[normalize-space()='" + actionType + "']";
//
//        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//        button.click();
//    }

    public void ClickCloseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
    }

    //************************************************************************************************************************************************
                                      //Add Field
    //Locator
    @FindBy(xpath = "//button[normalize-space()='ADD FIELD VALUE']")
    WebElement addFieldButton;

    @FindBy(xpath = "//form[@id='editGlobalFieldForm']//button[@type='button'][normalize-space()='SAVE']")
    WebElement addFieldSaveButton;

    @FindBy(xpath = "//form[@id='editGlobalFieldForm']//button[@type='button'][normalize-space()='CLOSE']")
    WebElement addFieldCloseButton;

    @FindBy(xpath = "//td[@class='global-fields-manage-cell']//input[@type='text']")
    WebElement addFieldValueInput;

    @FindBy(xpath = "//div[@class='global-fields-manage-cell-action']//i[@class='fa-solid fa-trash']")
    WebElement deleteIcon;

    //Action

    public void clickAddFieldButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addFieldButton)).click();
    }

    public void enterFieldValue(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.visibilityOf(addFieldValueInput));
        input.clear();
        input.sendKeys(value);
    }

    public void clickonSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addFieldSaveButton)).click();
    }

    public void clickonCloseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addFieldCloseButton)).click();
    }

    public void clickonDeleteIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
    }


}

