package hw3.pages;

import hw3.utils.UtilsFunctions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected UtilsFunctions utilsFunctions;

    {
        utilsFunctions = new UtilsFunctions();
    }

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private List<WebElement> elementsFromHeaderSection;

    @FindBy(xpath = "//span[@id='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//div[@id='mCSB_1']")
    private WebElement leftSection;

    @FindBy(xpath = "//div[@class='footer-bg']")
    private WebElement footer;

    private WebElement password;

    @FindBy(xpath = "//img[@id = 'user-icon']")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]//span[@class='caret']")
    private WebElement subCategoryServiceHeader;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li/a")
    private List<WebElement> serviceDropDownHeader;

    @FindBy(xpath = "//li[contains(@class, 'menu-title')]//span[text()='Service']")
    private WebElement subCategoryServiceLeftSection;

    @FindBy(xpath = "//li[contains(@class, 'menu-title')]//ul[@class='sub']//a")
    private List<WebElement> serviceDropDownLeft;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]//a[text() ='Different elements']")
    private WebElement differentElements;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }
    @Step("Login user with user name: '{0}'")
    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getUserName() {

        return userName.getText();
    }

    public List<WebElement> getElementsFromHeaderSection() {

        return elementsFromHeaderSection;
    }

    public List<String> getTextFromElementsFromHeaderSection() {
        return utilsFunctions.getTextFromListOfWebElements(elementsFromHeaderSection);
    }

    public WebElement getLeftSection() {

        return leftSection;
    }

    public WebElement getFooter() {

        return footer;
    }

    public void clickDifferentElements() {

        differentElements.click();
    }

    public void clickOnSubCategoryServiceHeader() {

        subCategoryServiceHeader.click();
    }

    public List<WebElement> getServiceDropDownHeader() {

        return serviceDropDownHeader;
    }

    public List<String> getServiceDropDownHeaderText() {
        return utilsFunctions.getTextFromListOfWebElements(serviceDropDownHeader);
    }

    public void clickOnSubCategoryServiceLeft() {

        subCategoryServiceLeftSection.click();
    }

    public List<WebElement> getServiceDropDownLeft() {

        return serviceDropDownLeft;
    }

    public List<String> getServiceDropDownLeftSectionText() {
        return utilsFunctions.getTextFromListOfWebElements(serviceDropDownLeft);
    }
}
