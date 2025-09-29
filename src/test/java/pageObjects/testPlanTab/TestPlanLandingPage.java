package pageObjects.testPlanTab;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(xpath = "//img[@class='menu-open' and @alt='Close Sidebar']")
    private WebElement btnHamburgerMenu;

    @FindBy(id = "sidebar")
    private WebElement sidebar;

    @FindBy(xpath = "//div[contains(@class,'project') and contains(.,'STG- PulseCodeOnAzureCloud')]//i[contains(@class,'toggle-icon')]")
    private WebElement projectCaret;

    @FindBy(xpath = "//div[@class='dashboard-card']//div[text()='Total Releases']/following-sibling::div[@class='card-value']")
    private WebElement totalReleasesValue;

    @FindBy(xpath = "//div[@class='dashboard-card']//div[text()='Total Test Cycles']/following-sibling::div[@class='card-value']")
    private WebElement totalTestCyclesValue;

    @FindBy(xpath = "//div[@class='dashboard-card']//div[text()='Total Test Suites']/following-sibling::div[@class='card-value']")
    private WebElement totalTestSuitesValue;

    @FindBy(xpath = "//div[contains(@class,'releases')]")
    private java.util.List<WebElement> allProjects;

    // --- Actions ---
    public void selectTestPlanTab() {
        tabTestPlan.click();
    }

    public void expandSidebarIfCollapsed() {
        if (!sidebar.isDisplayed()) {
            btnHamburgerMenu.click();
        }
    }

    public void expandProjectSTG() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(projectCaret));

        String transform = projectCaret.getAttribute("style");
        if (transform.contains("0deg")) {
            projectCaret.click();
            // wait until it rotates to 90deg
            wait.until(driver -> projectCaret.getAttribute("style").contains("90deg"));
        }
    }

    public void expandRelease(String releaseName) {
        String releaseXpath = "//div[contains(@class,'releases') and contains(normalize-space(.),'" + releaseName
                + "')]"
                + "/span/i[contains(@class,'toggle-icon')]";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement releaseCaret = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(releaseXpath)));

        // Only click if not already expanded (rotate(90deg))
        String style = releaseCaret.getAttribute("style");
        if (style.contains("rotate(0deg)")) {
            releaseCaret.click();
        }
    }

    public void clickNewRelease() {
        btnNewRelease.click();
    }

    public void clickNewTestCycle() {
        btnNewTestCycle.click();
    }

    public void clickNewTestSuite() {
        btnNewTestSuite.click();
    }

    public void clickDelete() {
        btnDelete.click();
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

}
