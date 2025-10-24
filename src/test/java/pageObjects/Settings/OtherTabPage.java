package pageObjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import javax.swing.*;
import java.time.Duration;

public class OtherTabPage extends BasePage
{
    public OtherTabPage(WebDriver driver)
    {
        super(driver);
    }
    //Locators

    @FindBy(xpath = "(//img[@class='fields-img-2'])[1]")
    WebElement buttonAddCustomField;

    @FindBy(xpath = "(//button[@class='fields-button-secondary'])[1]")
    WebElement buttonSaveChanges;

    @FindBy(xpath = "(//button[@class='fields-button-secondary'])[2]")
    WebElement buttonSelectAll;

    @FindBy(xpath = "(//button[@class='fields-button-secondary'])[3]")
    WebElement buttonClearAll;

    @FindBy(xpath = "(//button[@class='fields-button-secondary'])[4]")
    WebElement buttonReset;

    public WebElement showInGridCheckbox(String rowName) {
        String xpath = "//p[normalize-space()='" + rowName + "']/../../..//input[@type='checkbox']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement editFieldButtonInsideAction(String rowName) {
        String xpath = "//p[normalize-space()='" + rowName + "']/../../..//i[@class='fa-solid fa-pencil']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement deleteFieldButtonInsideAction(String rowName) {
        String xpath = "//p[normalize-space()='" + rowName + "']/../../..//i[@class='fa-solid fa-trash']";
        return driver.findElement(By.xpath(xpath));
    }


    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement SaveChangesButtonInsideActionEdit;

    @FindBy(xpath = "(//button[normalize-space()='CLOSE'])[1]")
    WebElement CloseActionEditButton;

    //locators for Add custome Fields

    @FindBy(xpath = "(//input[@placeholder='Enter field name (e.g., Priority, Category)'])[1]")
    WebElement FieldNAme;

    @FindBy(xpath = "(//select[@class='assignToDropdown testcase-text-wrapper-15 testcase-select'])[1]")
    WebElement DataType;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    WebElement CreateField;

    @FindBy(xpath = "(//button[normalize-space()='CANCEL'])[1]")
    WebElement Cancelbutton;

    //Locators for add field value
    @FindBy(xpath = "(//button[normalize-space()='ADD FIELD VALUE'])[1]")
    WebElement AddFieldValueButton;

    @FindBy(xpath = "(//input[@placeholder='Enter option value'])[1]")
    WebElement EnterFieldValue;

    @FindBy(xpath ="(//input[@title='Set as default'])[1]")
    WebElement DefaultButton;

    @FindBy(xpath = "(//i[@class='fa-solid fa-trash'])[6]")
    WebElement deleteButton;

    //Actions

    public void clickAddCustomField()
    {
        buttonAddCustomField.click();
    }

    public void clickSaveChanges()
    {
        buttonSaveChanges.click();
    }

    public void clickSelectALlButton()
    {
        buttonSelectAll.click();
    }

    public void clickClearAll()
    {
        buttonClearAll.click();
    }

    public void clickReset()
    {
        buttonReset.click();
    }

    public void clickShowInGridCheckbox(String fieldName) {
        Actions actions = new Actions(driver);
        WebElement checkbox = showInGridCheckbox(fieldName);
        actions.moveToElement(checkbox).perform();
        checkbox.click();
    }

    public void clickEditFieldInAction(String fieldName)
    {
        WebElement editButton = editFieldButtonInsideAction(fieldName);
        editButton.click();
    }

    public void clickDeleteFieldInAction(String fieldName)
    {
        WebElement deleteButton = deleteFieldButtonInsideAction(fieldName);
        deleteButton.click();
    }

    public void saveChangesButtonInsideActionEditButton()
    {
        SaveChangesButtonInsideActionEdit.click();
    }

    public void closeButtonInsideActionEditButton()
    {
        CloseActionEditButton.click();
    }

    //Action for Add cutome Fields

    public void EnterFieldName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FieldNAme));

        FieldNAme.clear();
        FieldNAme.sendKeys(name);
    }

    public void SelectDataType(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(DataType));
        Select dropdown = new Select(DataType);
        dropdown.selectByVisibleText(value);
    }

    public void clickCreateFieldButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CreateField));
        CreateField.click();
    }

    public void clickCloseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Cancelbutton));
        Cancelbutton.click();
    }


    //Action for add field value

    public void clickOnAddfieldValueButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(AddFieldValueButton));
        AddFieldValueButton.click();
    }

    public void EnterField(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(EnterFieldValue));

        EnterFieldValue.clear();
        EnterFieldValue.sendKeys(name);
    }

    public void clickOnDefault()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(DefaultButton));
        DefaultButton.click();
    }

    public void clickOnDelete()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }

}

