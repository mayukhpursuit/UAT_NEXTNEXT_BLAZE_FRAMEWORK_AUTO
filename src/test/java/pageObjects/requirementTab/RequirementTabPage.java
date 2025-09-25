package pageObjects.requirementTab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.BasePage;
import java.util.List;

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


    @FindBy(xpath = "//button[normalize-space()='Help?']")
    WebElement clickHelp;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]")
    WebElement helpDropdown;


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
    @FindBy(xpath = "(//a[@class='text-wrapper-14'])[last()]")
    WebElement getNewRqIdText;

    public WebElement leftModuleNameByName(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='tree-node tree-node expanded']//span[normalize-space()='" + name + "']")
        ));
    }

    //Actions

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void clickRequirementTab(){
        tabRequirements.click();
    }
    public void clickOnTheProjectName() throws InterruptedException {

        leftPanelProjectName.click();
        wait.until(ExpectedConditions.visibilityOf(buttonSave));

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
        buttonSave.click();
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='notification' and normalize-space(text())='Module created successfully.']")
        ));
    }

    public void clickDeleteModule(){
        wait.until(d -> iconDelete.getCssValue("cursor").equalsIgnoreCase("pointer"));
        iconDelete.click();
    }

    public void clickArrowRightPointingForExpandModule(String moduleName){
        arrowBeforeExpandRightPointing(moduleName).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='tree-children']") // children of the project
        ));
    }

    public void clickArrowDownPointingForCollapseModule(String moduleName){
        arrowAfterExpandDownPointing(moduleName).click();
    }

    public void clickOnModule(String moduleName) throws InterruptedException {
        try {
            Actions a= new Actions(driver);
            a.moveToElement(leftModuleNameByName(moduleName)).perform();
            leftModuleNameByName(moduleName).click();
        } catch (Exception e) {
            driver.findElement(By.xpath(" //div[@class='tree-node tree-node collapsed']//span[normalize-space()='"+moduleName+"']")).click();
        }
    }

    public String getNewCreatedRqIdText(){
        return getNewRqIdText.getText();
    }

    public void clickProjectName() throws InterruptedException {
        clickOnTheProjectName();
    }

    public String getProjectNameText() {
        return leftPanelProjectName.getText().trim();
    }

    public List<String> getRequirementIDs() {
        List<WebElement> rows = getRequirementsFromModuleTable();
        return rows.stream().map(row -> row.findElement(By.cssSelector("div.testlistcell a.text-wrapper-14")).getText()).toList();
    }

    public List<WebElement> getRequirementsFromModuleTable() {
        WebElement tableContainer = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("existingTestCasesInnerTable"))));
        return tableContainer.findElements(By.cssSelector("div.testlistrow"));
    }

    public boolean isRequirementVisible(String requirementId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String xpath = "(//p[normalize-space()='" + requirementId + "'])[1]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void verifyHelpDropdown(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickHelp)).click();
        wait.until(ExpectedConditions.visibilityOf(helpDropdown));
        Assert.assertTrue(helpDropdown.isDisplayed(), "Help dropdown is not visible");
    }

    public void clicktoggleSidebar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(closeSideBar)
        )).click();
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(openSideBar)
        ));
        Assert.assertTrue(openSideBar.isDisplayed(), "Sidebar did not collapse");
        System.out.println("Sidebar closed successfully");
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(openSideBar)
        )).click();
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(closeSideBar)
        ));
        Assert.assertTrue(closeSideBar.isDisplayed(), "Sidebar did not expand");
        System.out.println("Sidebar opened successfully");
    }
}
