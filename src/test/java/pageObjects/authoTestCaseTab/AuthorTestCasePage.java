package pageObjects.authoTestCaseTab;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;
import java.util.List;

public class AuthorTestCasePage extends BasePage {
    public AuthorTestCasePage(WebDriver driver){
        super(driver);
    }
    // locators
    @FindBy(xpath = "(//select[@class='text select-dropdown'])[1]")
    WebElement dropdownEpic;

    @FindBy(xpath = "//span[normalize-space()='Epic']")
    WebElement labelEpic;

    @FindBy(xpath = "(//select[@class='text select-dropdown'])[1]/option")
    List<WebElement> optionsEpic;

    @FindBy(xpath = "(//select[@class='text select-dropdown'])[2]/option")
    List<WebElement> optionsFeatures;

    @FindBy(xpath = "(//select[@class='text select-dropdown'])[2]")
    WebElement dropdownFeature;

    public WebElement linkRequirement(String reqId) {
        return driver.findElement(By.xpath("//div[text()='"+ reqId +"']"));
    }

    @FindBy(xpath = "//p[@class='supporting-text']")
    WebElement headingRequirement;

    @FindBy(xpath = "//button[@id='createTestCaseButton']/div")
    WebElement buttonAddTestCase;

    @FindBy(xpath = "//span[@id='author']")
    WebElement tabAuthorTestcase;

    @FindBy(xpath = "//div[@class='wrapper']")
    List<WebElement> rqCountWrapper;

    @FindBy(xpath = "//img[@alt='Previous']")
    WebElement previousArrowBtn;

    @FindBy(xpath = "//img[@alt='Next']")
    WebElement nextArrowBtn;

    @FindBy(xpath = "//img[@alt='Last Page']")
    WebElement lastPageArrowBtn;

    @FindBy(xpath = "//img[@alt='First Page']")
    WebElement firstPageArrowBtn;


    //actions

    public void selectEpic(String epicName){
        Select s= new Select(dropdownEpic);
        s.selectByVisibleText(epicName);
    }

    public void selectFeature(String featureName){
        Select s= new Select(dropdownFeature);
        s.selectByVisibleText(featureName);
    }

    public void clickRequirement(String requirementId) throws InterruptedException {
        Thread.sleep(2000);
        linkRequirement(requirementId).click();
        Thread.sleep(2000);
    }

    public String showRequirementHeader(){
        return headingRequirement.getText();
    }

    public void clickAddTestcase(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonAddTestCase);
    }
    public void clickAuthorTestcase(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabAuthorTestcase);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabAuthorTestcase);
    }
    public String getEpicLabelName(){
        return labelEpic.getText();
    }
    public boolean getVisibilityOfEpic(){
        return dropdownEpic.isDisplayed();
    }
    public int getCountInEpic() throws InterruptedException {
        Thread.sleep(2000);
        return optionsEpic.size();
    }
    public List<WebElement> getAllEpics() throws InterruptedException {
        Thread.sleep(2000);
        return optionsEpic;
    }
    public void getAllFeatures() throws InterruptedException {
        for (WebElement feature : optionsFeatures) {
            System.out.println("Feature: " + feature.getText());
        }
    }
    public void clickEpic(){
        dropdownEpic.click();
    }
    public void clickFeature(){
        dropdownFeature.click();
    }
    public String getSelectedEpic(){
        Select s = new Select(dropdownEpic);
        return s.getFirstSelectedOption().getText();
    }
    public String getSelectedFeature(){
        Select s = new Select(dropdownFeature);
        return s.getFirstSelectedOption().getText();
    }
    public int getCountRQInFeature() throws InterruptedException {
        Thread.sleep(2000);
        return rqCountWrapper.size();
    }

    public void clickLastPageArrowBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastPageArrowBtn));
        lastPageArrowBtn.click();
    }


    public String checkIfPreviousButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(previousArrowBtn));
            String cursorStyle = previousArrowBtn.getCssValue("cursor");

            System.out.println("Cursor style of Previous button: " + cursorStyle);

            if ("pointer".equals(cursorStyle)) {
                System.out.println("Previous button appears clickable (cursor: pointer).");
            } else {
                System.out.println("Previous button appears NOT clickable (cursor: " + cursorStyle + ").");
            }

            return cursorStyle;

        } catch (TimeoutException e) {
            System.out.println("Previous button is NOT visible within the timeout.");
            return "not-visible";
        }
    }


    public String checkIfNextButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(nextArrowBtn));
            String cursorStyle = nextArrowBtn.getCssValue("cursor");

            System.out.println("Cursor style of Next button: " + cursorStyle);

            if ("pointer".equals(cursorStyle)) {
                System.out.println("Next button appears clickable (cursor: pointer).");
            } else {
                System.out.println("Next button appears NOT clickable (cursor: " + cursorStyle + ").");
            }

            return cursorStyle;

        } catch (TimeoutException e) {
            System.out.println("Previous button is NOT visible within the timeout.");
            return "not-visible";
        }
    }
}
