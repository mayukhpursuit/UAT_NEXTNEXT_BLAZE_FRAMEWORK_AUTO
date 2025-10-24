package pageObjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import javax.swing.*;

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

}

