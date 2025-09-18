package pageObjects.requirementTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class IndividualModulePage extends BasePage {
    public IndividualModulePage(WebDriver driver) {
        super(driver);
    }

    //Locator
    @FindBy(xpath = "//input[@class='supporting-text']")
    WebElement EpicNameField;

    @FindBy(xpath = "//div[@class='requirement-grid-template']//div[1]//div[2]")
    WebElement DescriptionField;

    @FindBy(xpath = "//button[@id='createRequirementButton']")
    WebElement AddRequirementButton;

    @FindBy(xpath = "//div[contains(text(),'SAVE')]")
    WebElement SaveButton;

    @FindBy(xpath = "//div[@id='gridContainerExistingTestCases']")
    WebElement Requirementgrid;

    @FindBy(xpath = "//img[@alt='Next']")
    WebElement clicknextbutton;

    @FindBy(xpath = "//img[@alt='Last Page']")
    WebElement clicklastpagebutton;

    @FindBy(xpath = "//div[@class='test-case-pagination-item']")
    WebElement CurrentPageIndicator;

    @FindBy(xpath = "//img[@alt='Previous']")
    WebElement clickpreviouspagebutton;

    @FindBy(xpath = "//img[@alt='First Page']")
    WebElement clickfirstpagebutton;


    @FindBy(xpath = "//img[@id='rotatable-image']")
    WebElement clicknametogglebutton;


}
