package pageObjects.executeTestCaseTab;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LinkDefectPage extends BasePage {

    //Constructor

    private WebDriver driver;
    private WebDriverWait wait;

    public LinkDefectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30-second timeout
    }

    // locators
    @FindBy(xpath = "//input[@placeholder='Enter Defect ID/Summary']")
    WebElement inputSearchDefect;

    @FindBy(xpath = "//div[contains(@class, 'search')]")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@name='defectOption']")
    WebElement checkBoxOnlyForSearchedDefect;

    @FindBy(xpath = "//div[normalize-space(text()) = 'CANCEL']")
    WebElement cancelBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'LINK']")
    WebElement linkBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'NEW']")
    WebElement newBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'CLOSE']")
    WebElement closeBtn;

    @FindBy(xpath = "//div[@class='test-execution-label-3']")
    WebElement confirmationYes;

    @FindBy(xpath = "//div[@id='notification']")
    WebElement notificationPopUp;

    public WebElement radioButtonForDefectId(String defectId){
        return driver.findElement(By.xpath("//div[contains(text(),'"+defectId+"')]/../..//input"));
    }

    public WebElement imageUnlink(String defectId){
        return driver.findElement(By.xpath("//div[normalize-space()='"+defectId+"']/..//img"));
    }

    @FindBy(xpath = "//div[@class='modal-div']//div[contains(text(),'DF-')]")
    List<WebElement> allDefectId;
// locators for creating a new bug

    @FindBy(xpath = "//textarea[@id='DefSummary']")
    WebElement summaryInput;

    @FindBy(xpath = "//select[@id='SeverityDropdown']")
    WebElement dropdownSeverity;

    @FindBy(xpath = "//select[@id='FixedReleaseBuildDropdown']")
    WebElement dropdownFixedReleaseBuild;

    @FindBy(xpath = "//select[@id='ReasonDropdown']")
    WebElement dropdownReason;

    @FindBy(xpath = "//select[@id='CategoryDropdown']")
    WebElement dropdownCategory;

    @FindBy(xpath = "//select[@id='TypeDropdown']")
    WebElement dropdownType;

    @FindBy(xpath = "//select[@id='TargetReleaseBuildDropdown']")
    WebElement dropdownTargetReleaseBuild;

    @FindBy(xpath = "//select[@id='StatusDropdown']")
    WebElement dropdownStatus;

    @FindBy(xpath = "//select[@id='PriorityDropdown']")
    WebElement dropdownPriority;

    @FindBy(xpath = "//button[@id='browse-button']")
    WebElement browseFileBtn;

    @FindBy(xpath = "//div[normalize-space(text()) = 'SAVE']")
    WebElement saveBtn;

    @FindBy(xpath = "//span[@id='affected_release_display']")
    WebElement getAffectedReleaseName;

    @FindBy(xpath = "//span[contains(text(), 'Default Module')]")
    WebElement getModuleName;

    @FindBy(xpath = "//textarea[@class='defect-text-wrapper-5']")
    WebElement descriptionInputArea;

    @FindBy(xpath = "//i[@class='fa fa-download defect-download-symbol']")
    List<WebElement> allDownloadIcons;


    // Actions

    public void clickDownloadIcon(int index) {
        if (index < allDownloadIcons.size()) {
            WebElement downloadIcon = allDownloadIcons.get(index);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downloadIcon);
            downloadIcon.click();
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
    public void enterDefectSearch(String defectIdOrSummary) {
        wait.until(ExpectedConditions.visibilityOf(inputSearchDefect)).sendKeys(defectIdOrSummary.replaceAll("[^0-9]", ""));
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    public void checkDefectCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxOnlyForSearchedDefect)).click();
    }

    public void clickRadioButtonBesideDefectId(String defectId){
        new Actions(driver).moveToElement(radioButtonForDefectId(defectId)).perform();
        radioButtonForDefectId(defectId).click();
    }

    public void clickUnlinkButtonByDefectId(String defectId){
        new Actions(driver).moveToElement(imageUnlink(defectId)).perform();
        imageUnlink(defectId).click();
        wait.until(ExpectedConditions.visibilityOf(confirmationYes));
        confirmationYes.click();
        wait.until(ExpectedConditions.visibilityOf(notificationPopUp));
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
    }

    public void clickLink() {
        wait.until(ExpectedConditions.elementToBeClickable(linkBtn)).click();
    }

    public void clickNew() {
        wait.until(ExpectedConditions.elementToBeClickable(newBtn)).click();
    }

    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }

    public void enterSummary(String summary) {
        wait.until(ExpectedConditions.visibilityOf(summaryInput)).sendKeys(summary);
    }
    public String getNotificationPopUpText() {
       return wait.until(ExpectedConditions.elementToBeClickable(notificationPopUp)).getText();
    }

    public void selectSeverity(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownSeverity));
        new Select(dropdownSeverity).selectByVisibleText(value);
    }

    public void selectFixedReleaseBuild(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownFixedReleaseBuild));
        new Select(dropdownFixedReleaseBuild).selectByVisibleText(value);
    }

    public void selectReason(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownReason));
        new Select(dropdownReason).selectByVisibleText(value);
    }

    public void selectCategory(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownCategory));
        new Select(dropdownCategory).selectByVisibleText(value);
    }

    public void selectType(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownType));
        new Select(dropdownType).selectByVisibleText(value);
    }

    public void selectTargetReleaseBuild(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownTargetReleaseBuild));
        new Select(dropdownTargetReleaseBuild).selectByVisibleText(value);
    }

    public void selectStatus(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownStatus));
        new Select(dropdownStatus).selectByVisibleText(value);
    }

    public void selectPriority(String value) {
        wait.until(ExpectedConditions.visibilityOf(dropdownPriority));
        new Select(dropdownPriority).selectByVisibleText(value);
    }

    public boolean isErrorMessageVisibleForSizeExceed() {
        try {
            WebElement popup = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='notification']"))
            );
            return true;

        } catch (Exception e) {
            System.out.println("No error  is found ");
            return false;
        }
    }

    public void uploadFileWithRobot(String relativeFilePath) throws Exception {
        String absoluteFilePath = Paths.get(relativeFilePath).toAbsolutePath().toString();

        StringSelection selection = new StringSelection(absoluteFilePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        wait.until(ExpectedConditions.elementToBeClickable(browseFileBtn)).click();

        // Use Robot to interact with file dialog
        Robot robot = new Robot();
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public List<String> getAllDefectIds() {
        List<String> defectIds = new ArrayList<>();
        for (WebElement element : allDefectId) {
            String id = element.getText().trim();
            if (!id.isEmpty()) {
                defectIds.add(id);
            }
        }
        return defectIds;
    }



    public void uploadFile(String fileName) {
        String filePath = System.getProperty("user.dir")
                + File.separator + "media"
                + File.separator + fileName;

        try {
            // Scroll and click browse button safely
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", browseFileBtn);
            wait.until(ExpectedConditions.elementToBeClickable(browseFileBtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", browseFileBtn);


            Thread.sleep(2000);


            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);


            Robot robot = new Robot();


            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);


            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("File uploaded successfully: " + filePath);

        } catch (Exception e) {
            System.out.println("File upload failed: " + e.getMessage());
        }
    }


    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    public String getAffectedReleaseName() {
        return wait.until(ExpectedConditions.visibilityOf(getAffectedReleaseName)).getText();
    }

    public String getModuleName() {
        return wait.until(ExpectedConditions.visibilityOf(getModuleName)).getText();
    }

    public void enterDescription(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionInputArea)).sendKeys(description);
    }
    public boolean isSearchButtonVisible(){
        try {
            WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(15));
            wait1.until(ExpectedConditions.visibilityOf(searchBtn));
            return true;  // element became visible
        } catch (TimeoutException e) {
            return false; // element not visible within wait time
            }
    }

    public void clickDefectId(String defectId) {
        for (WebElement defect : allDefectId) {
            String id = defect.getText().trim();
            if (id.equals(defectId)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", defect);

                // Click the defect
                defect.click();
                break;
            }
        }
    }


    public void clickDefectById(String defectId) {
        for (WebElement defect : allDefectId) {
            String id = defect.getText().trim();
            if (id.equals(defectId)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", defect);


                defect.click();
                break;
            }
        }
    }

    public boolean isNotificationPopupDisplayed(String expectedMessage) {
        try {
            By notificationLocator = By.xpath("//div[@id='notification']");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator));

            String notificationText = notification.getText().trim();
            System.out.println("Notification text: " + notificationText);

            return notificationText.equals(expectedMessage);

        } catch (Exception e) {
            System.out.println("Notification not displayed: " + e.getMessage());
            return false;
        }
    }

}
