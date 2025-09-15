package pageObjects.authoTestCaseTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import org.openqa.selenium.*;


public class LinkTestCasePage extends BasePage {

    public LinkTestCasePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@id='searchInputTCModal']")
    WebElement searchTC;

    @FindBy(xpath = "//*[@id='searchTCButton']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='defect-modal-text-wrapper-3']")
    WebElement Pid;

    // Actions
    public void enterSearchText(String tcName) {
        searchTC.clear();
        searchTC.sendKeys(tcName);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void searchTestCase(String tcName) {
        enterSearchText(tcName);
        clickSearch();
    }

    public void clickPid(String pidFromExcel) {
        WebElement pidElement = driver.findElement(
                By.xpath("//div[@class='defect-modal-text-wrapper-3' and text()='" + pidFromExcel + "']")
        );
        pidElement.click();
    }
}

