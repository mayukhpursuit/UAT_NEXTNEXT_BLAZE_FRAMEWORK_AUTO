package pageObjects.authoTestCaseTab;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
import java.util.*;

public class AuthorTestCasePage extends BasePage {
    public AuthorTestCasePage(WebDriver driver) {
        super(driver);
    }
    // locators
    @FindBy(xpath = "(//select[@class='text select-dropdown'])[1]")
    WebElement dropdownEpic;

    @FindBy(xpath = "//span[normalize-space()='Epic']")
    WebElement labelEpic;

    @FindBy(xpath = "(//select[@class='text select-dropdown'])[1]/option")
    List<WebElement> optionsEpic;

    @FindBy(xpath = "(//select[@class='text select-dropdown'])[2]/option")
    List<WebElement> optionsFeatures;

    @FindBy(xpath = "(//select[@class='text select-dropdown'])[2]")
    WebElement dropdownFeature;

    public WebElement linkRequirement(String reqId) {
        return driver.findElement(By.xpath("//div[text()='" + reqId + "']"));
    }

    @FindBy(xpath = "//p[@class='supporting-text']")
    WebElement headingRequirement;

    @FindBy(xpath = "//button[@id='createTestCaseButton']/div")
    WebElement buttonAddTestCase;

    @FindBy(xpath = "//span[@id='author']")
    WebElement tabAuthorTestcase;

    @FindBy(xpath = "//div[@class='pagination-item']")
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

    @FindBy(xpath = "//h3[text()='Create Test Cases']")
    WebElement headingCreateTestCases;

    @FindBy(xpath = "//button[normalize-space(text())='SAVE']")
    WebElement buttonSubmitTestCaseModal;

    @FindBy(id = "notification")
    WebElement notificationDiv;


    public WebElement actionIconForTestcase(String testCaseId) {
        return driver.findElement(By.xpath("//a[text()='" + testCaseId + "']/ancestor::div[@class='testlistrow']//div[@class='testlistcell48']//img"));
    }

    @FindBy(id = "confirmBtn")
    WebElement buttonYes;

    @FindBy(id = "cancelBtn")
    WebElement buttonNo;

    @FindBy(xpath = "//img[@alt='Close Sidebar']")
    WebElement buttonCollapseToggle;

    @FindBy(xpath = "//img[@alt='Open Sidebar']")
    WebElement buttonExpandToggle;

    //This will fetch Locator for any linked Test case inside
    public WebElement linkTestCaseIdFromName(String name){
        return driver.findElement(By.xpath("//p[text()='"+name+"']/ancestor::div[@class='testlistrow']//a"));
    }

    public WebElement linkTestCaseIdFromId(String id){
        return driver.findElement(By.xpath("//div[@class='testlistcell']/a[text()='"+id+"']"));
    }

    @FindBy(xpath = "//div[normalize-space()='LINK TESTCASE']")
    WebElement LinkTestcase;


    @FindBy(xpath = "//input[@id='searchInputTCModal']")
    WebElement inputSearchTestCase;

    @FindBy(xpath = "//button[@id='searchTCButton']")
    WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='defect-modal-text-wrapper-3']")
    WebElement Pid;

    @FindBy(xpath = "//div[@class='testlistcell']/a")
    List<WebElement> linkAllTestCaseId;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement searchInput;

    @FindBy(xpath="//i[@class='fas fa-search search-icon']")
    WebElement searchBtn;

    @FindBy(xpath="//span[@class='entry-info']")
    WebElement totalEntryConutOfTestcases;

    @FindBy(xpath="//div[@class='text-wrapper-8']")
    WebElement rqIdText;
    @FindBy(xpath="//div[@class='text-wrapper-7']")
    WebElement rqTitleText;

    @FindBy(id = "existingTestCasesTable")
    WebElement linkedTestCaseTable;

    @FindBy(xpath = "//table[@id='newTestCasesTable']//tr[1]/td[1]/input")
    WebElement inputName;

    @FindBy(xpath = "//table[@id='newTestCasesTable']//tr[1]/td[2]/input")
    WebElement inputDescription;

    //actions

    public void selectEpic(String epicName) {
        Select s = new Select(dropdownEpic);
        s.selectByVisibleText(epicName);
    }

    public void selectFeature(String featureName) {
        Select s = new Select(dropdownFeature);
        s.selectByVisibleText(featureName);
    }

    public void clickRequirement(String requirementId) throws InterruptedException {
        Thread.sleep(2000);
        linkRequirement(requirementId).click();
        Thread.sleep(2000);
    }

    public String showRequirementHeader() {
        return headingRequirement.getText();
    }

    public void clickAddTestcase() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonAddTestCase);
    }

    public void clickAuthorTestcase() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabAuthorTestcase);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabAuthorTestcase);
    }
    public void clickActionIcon(String testCaseId) throws InterruptedException {
        Thread.sleep(2000);
        actionIconForTestcase(testCaseId).click();
        Thread.sleep(2000);
    }


    public String getEpicLabelName(){
        return labelEpic.getText();
    }

    public boolean getVisibilityOfEpic() {
        return dropdownEpic.isDisplayed();
    }

    public int getCountInEpic() throws InterruptedException {
        Thread.sleep(2000);
        return optionsEpic.size();
    }

    public List<WebElement> getAllEpics() throws InterruptedException {
        Thread.sleep(2000);
        return optionsEpic;
    }

    public void getAllFeatures() throws InterruptedException {
        for (WebElement feature : optionsFeatures) {
            System.out.println("Feature: " + feature.getText());
        }
    }

    public void clickEpic() {
        dropdownEpic.click();
    }

    public void clickFeature() {
        dropdownFeature.click();
    }

    public String getSelectedEpic() {
        Select s = new Select(dropdownEpic);
        return s.getFirstSelectedOption().getText();
    }

    public String getSelectedFeature() {
        Select s = new Select(dropdownFeature);
        return s.getFirstSelectedOption().getText();
    }

    public int getCountRQInFeature() throws InterruptedException {
        Thread.sleep(2000);
        return rqCountWrapper.size();
    }

    public void clickLastPageArrowBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastPageArrowBtn));
        lastPageArrowBtn.click();
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

    public boolean getFeatureVisibility() {
        return dropdownFeature.isDisplayed();
    }

    public String showPaginationOfRequirement() throws InterruptedException {
        Thread.sleep(2000);
        return divRequirementPagination.getText();
    }

    public void clickNextArrow() throws InterruptedException {

        divRequirementPagination.click();
        new Actions(driver).moveToElement(arrowForwardNextPagination);
        arrowForwardNextPagination.click();
        Thread.sleep(3000);
    }


    public void clickPreviousArrow(){
        arrowBackwardPrevious.click();
    }

    public boolean isAddTestCaseButtonVisible1() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOf(buttonAddTestCase));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isCreateTextHeadingVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOf(headingCreateTestCases));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false; // element not visible within wait time
        }
    }


    public void clickCollapseToggle() throws InterruptedException {
        Thread.sleep(1000);
        buttonCollapseToggle.click();
        Thread.sleep(2000);
    }

    public void clickExpandToggle() throws InterruptedException {
        Thread.sleep(1000);
        buttonExpandToggle.click();
        Thread.sleep(2000);
    }


    public void clicklinktestcase() throws InterruptedException {
        Thread.sleep(3000);
        LinkTestcase.click();
    }

    public void confirmUnlink() throws InterruptedException {
        Thread.sleep(1000);
        buttonYes.click();
        Thread.sleep(2000);
    }

    public void cancelUnlink() throws InterruptedException {
        Thread.sleep(1000);
        buttonNo.click();
        Thread.sleep(2000);
    }


    public boolean isRowDeleted(String testcaseId)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean isInvisible = wait.until((ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='testlistcell']/a[text()='"+testcaseId+"']"))));
            return isInvisible;
        }
        catch (Exception e)
        {
            return false ;
        }
    }
    public void clickTestCase(String tcID) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        while (true) {
            // Re-fetch the test case elements each time (to avoid stale elements)
            List<WebElement> allCases = driver.findElements(By.xpath("//div[@class='testlistcell']/a"));

            boolean found = false;
            for (WebElement ele : allCases) {
                String id = ele.getText().trim();
                if (id.equalsIgnoreCase(tcID)) {
                    WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(ele));
                    clickable.click();
                    System.out.println("Clicked on Test Case: " + tcID);
                    found = true;
                    break;
                }
            }

            if (found) break;

            // Locate the next button fresh each time
            WebElement nextButton = driver.findElement(By.xpath("//div[@id='rd_paginationContainer']//img[@alt='Next']"));

            // Stop if pagination ends
            if (nextButton.getCssValue("cursor").equalsIgnoreCase("default")) {
                System.out.println("Reached last page. Test case not found: " + tcID);
                break;
            }
            Thread.sleep(1000);
            nextButton.click();

            // Wait for page reload before rechecking
            Thread.sleep(1500);
        }
    }


    public boolean isAllTestIdSorted() throws InterruptedException {
        Thread.sleep(3000);
        List<String> name1 = new ArrayList<>();
        for (WebElement ele : linkAllTestCaseId) {
            name1.add(ele.getText().trim()); // trim in case of extra spaces
        }

        // Make a copy and sort it
        List<String> sortedList = new ArrayList<>(name1);
        Collections.sort(sortedList);

        // Check if original == sorted
        if (name1.equals(sortedList)) {
            return true;
        }
        return false;
    }

    public void searchRq(String Rq){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();

        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.clear();

        searchInput.sendKeys(Rq);

        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
    public String totalNoOfTestcasesInsideRq(){
        return totalEntryConutOfTestcases.getText();
    }
    public int extractNumber(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }
    public String getRQId(){
        return rqIdText.getText();
    }
    public String getRQTitle(){
        return rqTitleText.getText();
    }

    public void clickTestCasesId(String testCaseID) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String xpath = "//a[contains(text(), '" + testCaseID + "')]";
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isLinkedTestCaseTableVisible() {
        return linkedTestCaseTable.isDisplayed();
    }

    public void enterName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
    }

    public void enterDescription(String description) {
        inputDescription.clear();
        inputDescription.sendKeys(description);
    }

    public String getTestCaseNameById(String testCaseId) {
        try {
            String xpath = "//div[@id='existingTestCasesTable']//div[contains(@class,'testlistrow')]" +
                    "[.//div[@class='testlistcell']/a[normalize-space(text())='" + testCaseId + "']]" +
                    "//div[contains(@class,'testlistcell2') and contains(@class,'table-name')]//p";
            WebElement nameP = driver.findElement(By.xpath(xpath));
            return nameP.getText().trim();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }

    public String getFirstLinkedTestCaseName() {
        WebElement nameCell = driver.findElement(By.xpath("//table[@id='existingTestCasesTable']//tr[2]/td[2]"));
        return nameCell.getText().trim();
    }

    public String getFirstLinkedTestCaseId() {
        WebElement idCell = driver.findElement(By.xpath("//table[@id='existingTestCasesTable']//tr[2]/td[1]/a"));
        return idCell.getText().trim();
    }

    public void enterTestCaseNameInEditModal(String name) {
        WebElement nameInput = driver.findElement(By.id("testCaseName"));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void clickCloseButtonOnEditModal() {
        WebElement closeBtn = driver.findElement(By.xpath("//button[@id='closeButton' or contains(@class,'close-button')]"));
        closeBtn.click();
    }

    public void confirmCloseDiscardChanges() {
        WebElement yesBtn = driver.findElement(By.xpath("//button[contains(@id,'confirmBtn') or normalize-space(text())='Yes']"));
        yesBtn.click();
    }
    public void clickSubmitButtonOnAddTestCaseModal() throws InterruptedException {
        Actions a= new Actions(driver);
        Thread.sleep(1500);
        a.moveToElement(buttonSubmitTestCaseModal).perform();
        buttonSubmitTestCaseModal.click();
    }


    public boolean isErrorDisplayedForField(String fieldName) {
        try {
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                    .until(d -> notificationDiv.getAttribute("class").contains("show"));
            String errorMsg = notificationDiv.getText().trim();
            System.out.println("Error message for required field '" + fieldName + "': " + errorMsg);
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void toggleRequirementPanel(String requirementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        String xpath = "//div[@class='frame-5'][.//div[@class='text-3' and normalize-space()='" +
                requirementId + "']]//img[@id='rotatable-image']";

        WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toggle);
        Actions a= new Actions(driver);
        a.moveToElement(toggle).perform();
        toggle.click();
    }

    public boolean isRequirementPanelExpanded(String requirementId) {
        String xpath = "//div[@class='frame-5'][.//div[@class='text-3' and normalize-space()='" +
                requirementId + "']]//img[@id='rotatable-image']";

        WebElement toggle = driver.findElement(By.xpath(xpath));
        String style = toggle.getAttribute("style");

        // Expanded if rotate(0deg), Collapsed if rotate(180deg)
        return style != null && style.contains("rotate(0deg)");
    }
    public void clickRequirementPagination(){
        divRequirementPagination.click();
    }

    public boolean verifyPaginationAlignment() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(divRequirementPagination));
            Thread.sleep(3000);
            List<WebElement> paginationElements = divRequirementPagination.findElements(By.xpath(".//*"));
            if (paginationElements.isEmpty()) {
                return false;
            }
            int yCoordinate = paginationElements.getFirst().getRect().y;
            for (WebElement element : paginationElements) {
                if (Math.abs(element.getRect().y - yCoordinate) > 8) {
                    return false;
                }
            }
            return divRequirementPagination.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}



