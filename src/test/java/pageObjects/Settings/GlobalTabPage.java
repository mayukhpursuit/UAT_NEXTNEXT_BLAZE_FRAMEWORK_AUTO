package pageObjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

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
        String xpath = "//p[normalize-space()='" + rowName + "']/../../..//input[@type='checkbox']";
        return driver.findElement(By.xpath(xpath));
    }


    public WebElement SettingsButtonForRow(String rowName) {
        String xpath = "//p[normalize-space()='" + rowName + "']/../../..//i[@class='fa-solid fa-cog']";
        return driver.findElement(By.xpath(xpath));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(CheckboxForRow(rowName)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkbox).perform();

        if (!checkbox.isSelected()) {
            actions.moveToElement(checkbox).click().perform();
        }
    }

    public boolean isCheckboxClickable(String rowName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(CheckboxForRow(rowName)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
            Actions actions = new Actions(driver);
            actions.moveToElement(checkbox).perform();
            return checkbox.isDisplayed() && checkbox.isEnabled();
        } catch (Exception e) {
            return false;
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

    @FindBy(xpath = "//form[@id='manageObjectTypesForm']//button[@type='button'][normalize-space()='CLOSE']")
    WebElement closeButton;


    //Action

    public void clickAddButtonForObjectType(String objectType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//table//tr[td[normalize-space()='" + objectType + "']]//button[normalize-space()='Add']";
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

    //**********************************************************************************************************************************************
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

    public boolean verifySuccessNotification(String expectedMessage) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='notification' and contains(@class,'notification')]")));

            String actualText = notification.getText().trim();
            System.out.println("Notification Text Found: " + actualText);
            return actualText.toLowerCase().contains(expectedMessage.toLowerCase());
        } catch (Exception e) {
            System.out.println("Notification not found: " + e.getMessage());
            return false;
        }
    }

    public boolean verifyManageObjectTypesDashboard(String expectedTitle) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            String xpath = "//div[contains(@class, 'global-fields-modal-header')]/h3[contains(normalize-space(), '"
                    + expectedTitle + "')]";
            WebElement dashboardHeader = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickShowInGridCheckbox(String fieldName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            String xpath = "//p[@class='global-fields-name-text' and normalize-space(text())='" + fieldName + "']"
                    + "/ancestor::div[contains(@class,'global-fields-table-row')]"
                    + "//div[@class='global-fields-cell-showingrid']//input[@type='checkbox']";

            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
            wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

            System.out.println("Clicked on 'Show in Grid' checkbox for field: " + fieldName);
        } catch (Exception e) {
            System.out.println(
                    "Unable to click on 'Show in Grid' checkbox for field: " + fieldName + " - " + e.getMessage());
            throw e;
        }
    }

    public boolean isShowInGridCheckboxSelected(String fieldName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String xpath = "//td[contains(text(),'" + fieldName
                    + "')]/following-sibling::td//div[@class='checkbox-wrapper']/input";
            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            boolean isSelected = checkbox.isSelected();
            System.out.println("'Show in Grid' checkbox state for field '" + fieldName + "': "
                    + (isSelected ? "Selected" : "Not Selected"));
            return isSelected;
        } catch (Exception e) {
            System.out.println(
                    "Unable to verify 'Show in Grid' checkbox for field: " + fieldName + " - " + e.getMessage());
            return false;
        }
    }

    public boolean isCustomFieldPresent(String fieldName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            By locator = By.xpath("//p[normalize-space()='" + fieldName + "']");
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return driver.findElements(locator).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areAllFieldsSelected() {
        try {
            Thread.sleep(1000);

            List<WebElement> checkboxes = driver.findElements(
                    By.xpath(
                            "//input[@type='checkbox' and not(@disabled) and not(ancestor::div[contains(@style,'display:none')])]"));

            if (checkboxes.isEmpty()) {
                System.out.println(" No checkboxes found on the page!");
                return false;
            }

            long selectedCount = checkboxes.stream().filter(WebElement::isSelected).count();
            long totalCount = checkboxes.size();

            System.out.println(" Total Checkboxes: " + totalCount + " | Selected: " + selectedCount);

            if (selectedCount == totalCount) {
                return true;
            } else {
                System.out.println(" Unselected checkboxes count: " + (totalCount - selectedCount));
                for (WebElement cb : checkboxes) {
                    if (!cb.isSelected()) {
                        System.out.println("Unselected checkbox element: " + cb);
                    }
                }
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error while checking selected checkboxes: " + e.getMessage());
            return false;
        }
    }

    public boolean areAllFieldsCleared() {
        try {
            Thread.sleep(1000);

            List<WebElement> checkboxes = driver.findElements(
                    By.xpath(
                            "//input[@type='checkbox' and not(@disabled) and not(ancestor::div[contains(@style,'display:none')])]"));

            if (checkboxes.isEmpty()) {
                System.out.println(" No checkboxes found on the page!");
                return true;
            }

            long selectedCount = checkboxes.stream().filter(WebElement::isSelected).count();
            long totalCount = checkboxes.size();

            System.out.println("Total Checkboxes: " + totalCount + " | Selected after Clear All: " + selectedCount);

            if (selectedCount == 0) {
                return true;
            } else {
                System.out.println(" Still-selected checkboxes count: " + selectedCount);
                for (WebElement cb : checkboxes) {
                    if (cb.isSelected()) {
                        System.out.println("Still selected: " + cb);
                    }
                }
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error while checking cleared checkboxes: " + e.getMessage());
            return false;
        }
    }

    public int getTotalCheckboxCount() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and not(@disabled)]"));
        int visibleCount = 0;
        for (WebElement cb : checkboxes) {
            if (cb.isDisplayed()) {
                visibleCount++;
            }
        }
        return visibleCount;
    }

    public int getSelectedCheckboxCount() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and not(@disabled)]"));
        int selectedCount = 0;
        for (WebElement cb : checkboxes) {
            if (cb.isDisplayed() && cb.isSelected()) {
                selectedCount++;
            }
        }
        return selectedCount;
    }
    
}

