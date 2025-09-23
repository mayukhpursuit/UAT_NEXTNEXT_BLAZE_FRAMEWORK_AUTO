package pageObjects.requirementTab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class RequirementTabPage extends BasePage {
    public RequirementTabPage(WebDriver driver){
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//span[@id='requirements']")
    WebElement tabRequirements;

    @FindBy(xpath = "//img[@alt='Close Sidebar']")
    WebElement closeSideBar;

    @FindBy(xpath = "//img[@alt='Open Sidebar']")
    WebElement openSideBar;

    @FindBy(xpath = "//span[@title='<p></p>']")
    WebElement leftPanelProjectName;

    public WebElement arrowBeforeExpandRightPointing(String moduleName){
        return driver.findElement(By.xpath("//span[text()='"+moduleName+"']/..//i[@class='fa-solid tree-arrow fa-caret-right']"));
    }

    public WebElement arrowAfterExpandDownPointing(String moduleName){
        return driver.findElement(By.xpath("//span[text()='"+moduleName+"']/..//i[@class='fa-solid tree-arrow fa-caret-down']"));
    }

    @FindBy(xpath = "//i[@title='New Module']")
    WebElement iconNewModule;

    @FindBy(xpath = "//i[@title='Delete']")
    WebElement iconDelete;

    @FindBy(xpath = "//input[@class='supporting-text']")
    WebElement textModuleName;

    @FindBy(xpath = "//div[normalize-space()='SAVE']")
    WebElement buttonSave;

    @FindBy(xpath = "//div[@id='notification' and text()='Module created successfully.']")
    WebElement notificationAfterModuleCreation;

    @FindBy(xpath = "//div[@id='notification' and text()='Module updated successfully.']")
    WebElement notificationAfterModuleUpdation;

    public WebElement leftModuleNameByName(String name){
        return driver.findElement(By.xpath("//div[@class='tree-node tree-node expanded']//span[normalize-space()='"+name+"']"));
    }

    //Actions

    public void clickRequirementTab(){
        tabRequirements.click();
    }
    public void clickOnTheProjectName() throws InterruptedException {
        leftPanelProjectName.click();
    }
    public void clickNewModule() throws InterruptedException {
        Thread.sleep(1000);
        iconNewModule.click();
       Thread.sleep(1000);

    }
    public void setModuleName(String moduleName){
        textModuleName.clear();
        textModuleName.sendKeys(moduleName);
    }

    public void saveModule(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        buttonSave.click();
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='notification' and normalize-space(text())='Module created successfully.']")
        ));
    }


}
