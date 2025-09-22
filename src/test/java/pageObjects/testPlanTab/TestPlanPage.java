package pageObjects.testPlanTab;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class TestPlanPage extends BasePage {

    public TestPlanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
}
