package pageObjects.requirementTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class AddRequirementPage extends BasePage {
    public AddRequirementPage(WebDriver driver){
        super(driver);
    }
    //locators

    @FindBy(xpath = "//input[@id='testCaseName']")
    WebElement textRequirementId;

    @FindBy(xpath = "//div[@class='testcase-prototype']")
    WebElement textRequirementDescriptionBeforeClick;

    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    WebElement textRequirementDescriptionAfterClick;

    @FindBy(xpath = "//button[@id='saveButton']")
    WebElement buttonSave;

    //actions

    public void setRequirementId(String id){
        textRequirementId.sendKeys(id);
    }

    public void setDescription(String description) throws InterruptedException {
       textRequirementDescriptionBeforeClick.click();
        Thread.sleep(1000);
        textRequirementDescriptionAfterClick.sendKeys(description);
    }
    public void clickSave(){
        buttonSave.click();
    }


}
