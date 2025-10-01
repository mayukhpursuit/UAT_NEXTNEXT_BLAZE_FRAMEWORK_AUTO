package pageObjects.testPlanTab;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestPlanLandingPage extends BasePage {
    public TestPlanLandingPage(WebDriver driver) {
        super(driver);
    }

    // --- Locators ---
    @FindBy(id = "testplan")
    private WebElement tabTestPlan;

    @FindBy(xpath = "//i[@title='New Release']")
    private WebElement btnNewRelease;

    @FindBy(xpath = "//i[@title='New TestCycle']")
    private WebElement btnNewTestCycle;

    @FindBy(xpath = "//span[@title='New TestSuite']")
    private WebElement btnNewTestSuite;

    @FindBy(xpath = "//i[@title='Delete']")
    private WebElement btnDelete;

    @FindBy(xpath = "//button[@id='confirmBtn']")
    WebElement buttonConfirmDelete;

    @FindBy(xpath = "//button[@id='cancelBtn']")
    WebElement buttonCancelDelete;

    @FindBy(xpath = "//img[@class='menu-open' and @alt='Close Sidebar']")
    private WebElement btnHamburgerMenu;

    @FindBy(id = "sidebar")
    private WebElement sidebar;

    public WebElement expandArrow(String name){
        return driver.findElement(By.xpath("//div[text()='"+name+"']/span/i"));
    }

    @FindBy(xpath = "//div[@class='dashboard-card']//div[text()='Total Releases']/following-sibling::div[@class='card-value']")
    private WebElement totalReleasesValue;

    @FindBy(xpath = "//div[@class='dashboard-card']//div[text()='Total Test Cycles']/following-sibling::div[@class='card-value']")
    private WebElement totalTestCyclesValue;

    @FindBy(xpath = "//div[@class='dashboard-card']//div[text()='Total Test Suites']/following-sibling::div[@class='card-value']")
    private WebElement totalTestSuitesValue;

    @FindBy(xpath = "//div[contains(@class,'releases')]")
    private List<WebElement> allProjects;

    @FindBy(xpath = "//div[contains(@class,'test-plan-releases-name-parent')]/input")
    private WebElement inputReleaseName;

    @FindBy(xpath = "//select[contains(@class,'testcase-select')]")
    private WebElement dropdownReleaseStatus;

    @FindBy(xpath = "//div[.//div[text()='Start Date']]//input[@type='date']")
    private WebElement inputStartDate;

    @FindBy(xpath = "//div[.//div[text()='End Date']]//input[@type='date']")
    private WebElement inputEndDate;

    @FindBy(xpath = "//div[contains(@class,'rich-editor-scrollable')]//div[contains(@class,'test-plan-releases-prototype')]//div[em]")
    private WebElement inputDescription;

    @FindBy(id = "precondition")
    private WebElement inputReleaseNotes;

    @FindBy(xpath = "//button[.//div[text()='SAVE']]")
    private WebElement btnSaveRelease;

    @FindBy(xpath = "//div[@class='project ']")
    WebElement leftPanelProjectName;

    public WebElement releaseTestCycleTestSuite(String releaseOrTestCycleOrTestSuite){
        return driver.findElement(By.xpath("//div[text()='"+releaseOrTestCycleOrTestSuite+"']"));
    }

    // --- Actions ---

    public void clickOnReleaseOrTestCycleOrTestSuite(String releaseOrTestCycleOrTestSuite){
        releaseTestCycleTestSuite(releaseOrTestCycleOrTestSuite).click();
    }

    public void expandOnReleaseOrTestCycleOrTestSuite(String releaseOrTestCycleOrTestSuite){
        expandArrow(releaseOrTestCycleOrTestSuite).click();
    }
    public void selectTestPlanTab() throws InterruptedException {
        tabTestPlan.click();
        Thread.sleep(1000);
    }

    public void expandSidebarIfCollapsed() {
        if (!sidebar.isDisplayed()) {
            btnHamburgerMenu.click();
        }
    }

    public void expandProjectSTG(String projectName) {
        expandArrow(projectName).click();
    }

    public void expandRelease(String releaseName) {
        expandArrow(releaseName).click();
    }
    public void expandTestCycle(String testcycle)
    {
        expandArrow(testcycle).click();
    }

    public void clickNewRelease() throws InterruptedException {
        Thread.sleep(1500);
        btnNewRelease.click();
        Thread.sleep(1500);
    }

    public void clickNewTestCycle() throws InterruptedException {
        Thread.sleep(1500);
        btnNewTestCycle.click();
        Thread.sleep(1500);
    }

    public void clickNewTestSuite() throws InterruptedException {
        Thread.sleep(1500);
        btnNewTestSuite.click();
        Thread.sleep(1500);
    }

    public void clickDelete() throws InterruptedException {
        Thread.sleep(1500);
        btnDelete.click();
        Thread.sleep(1500);
    }
    public void clickOnConfirmDeleteYes(String releaseCycleSuiteName){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        buttonConfirmDelete.click();
        wait.until(ExpectedConditions.invisibilityOf(releaseTestCycleTestSuite(releaseCycleSuiteName)));
    }

    public void toggleHamburgerMenu() {
        btnHamburgerMenu.click();
    }

    public int getTotalReleases() {
        return Integer.parseInt(totalReleasesValue.getText().trim());
    }

    public int getTotalTestCycles() {
        return Integer.parseInt(totalTestCyclesValue.getText().trim());
    }

    public int getTotalTestSuites() {
        return Integer.parseInt(totalTestSuitesValue.getText().trim());
    }

    
    public void selectProjectByName(String projectName) {
        for (WebElement project : allProjects) {
            if (project.getText().trim().equalsIgnoreCase(projectName)) {
                project.click();
                return;
            }
        }
        throw new RuntimeException("Project '" + projectName + "' not found in the dropdown!");
    }

    public boolean isProjectSelected(String projectName) {
        for (WebElement project : allProjects) {
            if (project.getText().trim().equalsIgnoreCase(projectName)) {
                String classAttr = project.getAttribute("class");
                return classAttr.contains("active");
            }
        }
        return false;
    }

    public List<String> getAllProjectNames() {
        List<String> projectNames = new ArrayList<>();
        for (WebElement project : allProjects) {
            projectNames.add(project.getText().trim());
        }
        return projectNames;
    }

    
    private String releaseChildNodesXpath(String releaseName) {
        return "//div[contains(@class,'releases') and contains(normalize-space(.),'" + releaseName + "')]"
                + "/following-sibling::ul//div[contains(@class,'test-cycle-row')]";
    }

    public List<String> getChildNodesOfRelease(String releaseName) {
        List<WebElement> children = driver.findElements(By.xpath(releaseChildNodesXpath(releaseName)));
        List<String> childNames = new ArrayList<>();
        for (WebElement child : children) {
            childNames.add(child.getText().trim());
        }
        return childNames;
    }

    public void enterReleaseName(String releaseName) {
        inputReleaseName.clear();
        inputReleaseName.sendKeys(releaseName);
    }

    public void selectReleaseStatus(String status) {
        Select select = new Select(dropdownReleaseStatus);
        select.selectByVisibleText(status);
    }

    public String convertToHTML5Date(String dateDDMMYYYY) {
        String[] parts = dateDDMMYYYY.split("-");
        return parts[2] + "-" + parts[1] + "-" + parts[0]; // yyyy-MM-dd
    }

    public void selectStartDate(String dateDDMMYYYY) {
        String html5Date = convertToHTML5Date(dateDDMMYYYY);
        inputStartDate.sendKeys(html5Date);
    }

    public void selectEndDate(String dateDDMMYYYY) {
        String html5Date = convertToHTML5Date(dateDDMMYYYY);
        inputEndDate.sendKeys(html5Date);
    }

    public void enterDescription(String description) {
        WebElement descriptionEditor = driver.findElement(By.cssSelector(".ql-editor"));
        descriptionEditor.click();
        descriptionEditor.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        descriptionEditor.sendKeys(Keys.BACK_SPACE);
        descriptionEditor.sendKeys("This is the new release description.");
    }

    public void enterReleaseNotes(String notes) {
        inputReleaseNotes.clear();
        inputReleaseNotes.sendKeys(notes);
    }

    public void clickSaveRelease() {
        btnSaveRelease.click();
    }

    public void clickOnTheProjectName() {
        leftPanelProjectName.click();
    }



    public boolean isReleasePresentInList(String releaseName) {
        try {
            String releaseXpath = "//div[contains(@class,'releases') and contains(normalize-space(.),'" + releaseName
                    + "')]";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(releaseXpath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
