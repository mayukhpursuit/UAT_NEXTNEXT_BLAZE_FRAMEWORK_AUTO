package pageObjects.requirementTab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class RequirementPage extends BasePage {
    public RequirementPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//span[@id='requirements']")
    WebElement tabRequirements;

    @FindBy(xpath = "//span[@title='<p></p>']")
    WebElement leftPanelProjectName;

    @FindBy(xpath = "//i[@class='fa-solid tree-arrow fa-caret-right']")
    WebElement dropDownRequirements;

    @FindBy(xpath = "//i[@title='New Module']")
    WebElement iconNewModule;

    @FindBy(xpath = "//i[@title='Delete']")
    WebElement iconDelete;

    @FindBy(xpath = "//input[@class='supporting-text']")
    WebElement textModuleName;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    WebElement textDescription;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    WebElement textName;

    @FindBy(xpath = "//div[normalize-space()='SAVE']")
    WebElement buttonSave;

    public WebElement leftModuleNameByName(String name){
        return driver.findElement(By.xpath("//div[@class='tree-node tree-node expanded']//span[normalize-space()='New Module']"));
    }

    //Actions

}
