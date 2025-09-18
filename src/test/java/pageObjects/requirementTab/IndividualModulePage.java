package pageObjects.requirementTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class IndividualModulePage extends BasePage {

    public IndividualModulePage(WebDriver driver){
        super(driver);
    }

    // Locators

    @FindBy(xpath = "//div[@class='label-3']")
    WebElement buttonAddRequirement;

    //Actions

    public void clickAddRequirement(){
        buttonAddRequirement.click();
    }


}
