package pageObjects.authoTestCaseTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import org.openqa.selenium.*;




public class LinkTestCasewindow extends BasePage {

    public LinkTestCasewindow(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//input[@id='searchInputTCModal']")
    WebElement searchTC;

    @FindBy(xpath = "//*[@id='searchTCButton']")
    WebElement searchButton;

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
}
