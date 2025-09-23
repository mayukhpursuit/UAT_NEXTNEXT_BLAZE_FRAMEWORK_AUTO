package pageObjects.testPlanTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class IndividualReleasePage extends BasePage
{
    public IndividualReleasePage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//input[@class='test-plan-releases-supporting-text']")
    WebElement releaseName;

    @FindBy(xpath = "//select[@class='testcase-select value']")
    WebElement releaseStatus;

    @FindBy(xpath = "//div[@class='requirement-grid-template']//div[2]//div[2]//input[1]")
    WebElement releaseStartDate;

    @FindBy(xpath = "//div[3]//div[2]//input[1]")
    WebElement releaseEndDate;

    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    WebElement releaseDescription;

    @FindBy(xpath = "//textarea[@id='precondition']")
    WebElement releaseNote;

    @FindBy(xpath = "//button[@id='submitButton']")
    WebElement savebutton;


    //Actions

    public void setReleaseName(String ReleaseName)
    {
        releaseName.sendKeys(ReleaseName);
    }

    public void setStatus(String statusValue)
    {
        Select select = new Select(releaseStatus);
        select.selectByVisibleText(statusValue);
    }

    public void setDescription(String description)
    {
        releaseDescription.sendKeys(description);
    }

    public void setReleaseNote(String releasenote)
    {
        releaseNote.sendKeys(releasenote);
    }

    public void setReleaseStartDate(String releaseSdate) {
        releaseStartDate.clear();
        releaseStartDate.sendKeys(releaseSdate);
    }

    public void setReleaseEndDate(String releaseEdate) {
        releaseEndDate.clear();
        releaseEndDate.sendKeys(releaseEdate);
    }

    public boolean SaveButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(savebutton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
