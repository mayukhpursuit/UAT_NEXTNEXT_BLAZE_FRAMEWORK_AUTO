package pageObjects.testPlanTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class IndividualTestCyclePage extends BasePage {
    public IndividualTestCyclePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "(//input[@class='test-plan-test-cycles-supporting-text'])[1]")
    WebElement testCycleNameInput;

    @FindBy(xpath = "(//div[@class='test-plan-test-cycles-text-3'])[1]")
    WebElement testCycleHeader;

    @FindBy(xpath ="(//div[@class='testcase-input-3'])[1]")
    WebElement targetRelease;

    @FindBy(xpath = "(//div[@class='test-plan-test-cycles-prototype'])[1]")
    WebElement descriptionBeforeClick;

    @FindBy(xpath ="(//div[@class='rte-editor ql-container ql-snow'])[1]" )
    WebElement descriptionAfterClick;

    @FindBy(xpath = "(//button[@id='submitButton'])[1]")
    WebElement saveButton;

    //Actions

    public String getTestCycleHeader()
    {
        return testCycleHeader.getText();
    }

    public void setGetTestCycleName(String cycleName)
    {
        testCycleNameInput.clear(); //as input not div
        testCycleNameInput.sendKeys(cycleName);
    }

    public String getTargetRelease()
    {
        return targetRelease.getText();
    }


    public void setDescriptionAfter(String description)
    {
        descriptionBeforeClick.click();
        descriptionAfterClick.clear();
        descriptionAfterClick.sendKeys(description);
    }


    public void clickSave()
    {
        saveButton.click();
    }

}
