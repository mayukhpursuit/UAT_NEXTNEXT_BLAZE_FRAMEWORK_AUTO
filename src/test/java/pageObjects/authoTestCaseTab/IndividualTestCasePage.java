package pageObjects.authoTestCaseTab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class IndividualTestCasePage extends BasePage {
    public IndividualTestCasePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//div[normalize-space()='CLOSE']")
    WebElement buttonClose;

//    Actions
    public void ClickCloseButton()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonClose)).click();
    }
    public boolean isModelDisplayed()
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOf(buttonClose)).isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }
}

