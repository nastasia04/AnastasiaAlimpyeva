package hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.utils.UtilsFunctions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    protected UtilsFunctions utilsFunctions;

    {
        utilsFunctions = new UtilsFunctions();
    }

    @FindBy(xpath = "//span[@id='user-name']")
    private SelenideElement userName;

    @FindBy(xpath = "//div[@id='mCSB_1']")
    private SelenideElement leftSection;

    private SelenideElement password;

    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement loginNameTextField;

    @FindBy(xpath = "//button[@id='login-button']")
    private SelenideElement loginButton;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]//span[@class='caret']")
    private SelenideElement subCategoryServiceHeader;

    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li/a")
    private ElementsCollection serviceDropDownHeader;

    @FindBy(xpath = "//li[contains(@class, 'menu-title')]//span[text()='Service']")
    private SelenideElement subCategoryServiceLeftSection;

    @FindBy(xpath = "//li[contains(@class, 'menu-title')]//ul[@class='sub']//a")
    private ElementsCollection serviceDropDownLeft;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]//a[text() ='Table with pages']")
    private SelenideElement tableWithPagesButton;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]//a[contains(., 'Metals')]")
    private SelenideElement metalsAndColorsButton;

    public BasePage() {
        page(this);
    }

    public MetalAndColorsPage clickMetalsAndColorsButton() {
        metalsAndColorsButton.click();
        return page(MetalAndColorsPage.class);
    }

    public SelenideElement getPageTitle() {
        return $("title");
    }

    public BasePage login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
        return this;
    }

    public TableWithPages clickOnTableWithPagesButton() {
        tableWithPagesButton.click();
        return page(TableWithPages.class);
    }

    public SelenideElement getUserName() {

        return userName;
    }

    public SelenideElement getLeftSection() {

        return leftSection;
    }

    public BasePage clickOnSubCategoryServiceHeader() {

        subCategoryServiceHeader.click();
        return this;
    }

    public List<String> getServiceDropDownHeaderText() {
        return utilsFunctions.getTextFromListOfWebElements(serviceDropDownHeader);
    }

    public BasePage clickOnSubCategoryServiceLeft() {
        subCategoryServiceLeftSection.click();
        return this;
    }

    public List<String> getServiceDropDownLeftSectionText() {
        return utilsFunctions.getTextFromListOfWebElements(serviceDropDownLeft);
    }
}
