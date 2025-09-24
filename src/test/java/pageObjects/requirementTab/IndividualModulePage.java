package pageObjects.requirementTab;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
import java.util.List;

public class IndividualModulePage extends BasePage {

    public IndividualModulePage(WebDriver driver){
        super(driver);
    }

    // Locators

    @FindBy(xpath = "//div[@class='text-2']")
    WebElement headingModuleId;

    @FindBy(xpath = "//p[@class='supporting-text']")
    WebElement headingModuleName;

    @FindBy(xpath = "//div[@class='label-3']")
    WebElement buttonAddRequirement;

    @FindBy(xpath = "//input[@class='supporting-text']")
    WebElement inputTitle;

    @FindBy(xpath = "(//input[@class='testcase-select value'])[2]")
    WebElement inputName;

    @FindBy(xpath = "//div[@class='test-execution-label-3' and text()='SAVE']")
    WebElement btnSave;

    @FindBy(xpath = "(//input[@class='testcase-select value'])[1]")
    WebElement inputDescription;

    @FindBy(xpath = "//div[@class='rich-editor-scrollable']")
    WebElement descriptionBeforeClick;

    @FindBy(xpath = "//div[@class='rte-editor ql-container ql-snow']/div[@contenteditable='true']")
    WebElement descriptionAfterClick;

    @FindBy(id = "rotatable-image")
    WebElement toggleSectionIcon;

    @FindBy(xpath = "//div[@class='test-case-pagination-item']")
    WebElement divRequirementPagination;

    @FindBy(xpath = "//img[@alt='Next']")
    WebElement arrowForwardNextPagination;

    @FindBy(xpath = "//img[@alt='Previous']")
    WebElement arrowBackwardPrevious;

    @FindBy(xpath = "//div[@class='wrapper']")
    List<WebElement> rqCountWrapper;

    @FindBy(xpath = "//img[@alt='Last Page']")
    WebElement lastPageArrowBtn;

    @FindBy(xpath = "//img[@alt='First Page']")
    WebElement firstPageArrowBtn;

    public WebElement linkRequirementIdFromId(String id) {
        return driver.findElement(By.xpath("//div[@class='testlistcell']/a[text()='" + id + "']"));
    }

    public WebElement deleteRequirementIcon(String reqID) {
        return driver.findElement(By.xpath(
                "//a[text()='" + reqID + "']/ancestor::div[@class='testlistrow']//button[@class='deleteRowButton' and @title='Delete Requirement']"
        ));
    }




    //Actions

    public void clickAddRequirement(){
        buttonAddRequirement.click();
    }

    public void enterTitle(String title) {
        inputTitle.clear();
        inputTitle.sendKeys(title);
    }

    public String getModuleName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(inputTitle)).getAttribute("value").trim();
    }

    public String getModuleId(){
        return headingModuleId.getText();
    }

    public void enterName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
    }

    public void clickSave() {
        btnSave.click();
    }

    public void enterDescription(String description) {
        inputDescription.clear();
        inputDescription.sendKeys(description);
    }

    public void setActualDescription(String description) throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            descriptionBeforeClick.click();

            descriptionAfterClick.clear();
            descriptionAfterClick.sendKeys(description);

    }

    public String getActualDescription(){
        return descriptionBeforeClick.getText();
    }

    public void clickToggleSection() {
        toggleSectionIcon.click();
    }

    public void clickRequirement(String reqID) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(linkRequirementIdFromId(reqID)));
        element.click();
    }

    public void clickDeleteRequirement(String reqID) throws InterruptedException {
        Thread.sleep(2000);
        deleteRequirementIcon(reqID).click();
        Thread.sleep(2000);
    }

    public String showPaginationOfRequirement() throws InterruptedException {
        Thread.sleep(2000);
        return divRequirementPagination.getText();
    }

    public String checkIfNextButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(arrowForwardNextPagination));
            String cursorStyle = arrowForwardNextPagination.getCssValue("cursor");

            System.out.println("Cursor style of Next button: " + cursorStyle);

            if ("pointer".equals(cursorStyle)) {
                System.out.println("Next button appears clickable (cursor: pointer).");
            } else {
                System.out.println("Next button appears NOT clickable (cursor: " + cursorStyle + ").");
            }

            return cursorStyle;

        } catch (TimeoutException e) {
            System.out.println("Previous button is NOT visible within the timeout.");
            return "not-visible";
        }
    }

    public String checkIfPreviousButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(arrowBackwardPrevious));
            String cursorStyle = arrowBackwardPrevious.getCssValue("cursor");

            System.out.println("Cursor style of Previous button: " + cursorStyle);

            if ("pointer".equals(cursorStyle)) {
                System.out.println("Previous button appears clickable (cursor: pointer).");
            } else {
                System.out.println("Previous button appears NOT clickable (cursor: " + cursorStyle + ").");
            }

            return cursorStyle;

        } catch (TimeoutException e) {
            System.out.println("Previous button is NOT visible within the timeout.");
            return "not-visible";
        }
    }

    public void clickPreviousArrow(){
        arrowBackwardPrevious.click();
    }

    public void clickLastPageArrowBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastPageArrowBtn));
        lastPageArrowBtn.click();
    }




}
