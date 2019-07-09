package hw6.pages;

import hw6.enums.CheckBox;
import hw6.enums.DropDown;
import hw6.enums.Radio;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    private static DifferentElementsPage instance;
    private static WebDriver driver;

    @FindBy(xpath = "//div[@name ='navigation-sidebar']")
    private WebElement rightSection;
    @FindBy(xpath = "//div[@name ='log-sidebar']")
    private WebElement leftSection;
    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<WebElement> checkbox;
    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radio;
    @FindBy(xpath = "//select")
    private List<WebElement> selectSection;
    @FindBy(xpath = "//*[contains(@value,'Button')]")
    private List<WebElement> buttons;
    @FindBy(xpath = "//ul[contains(@class,'panel-body-list logs')]/li")
    private WebElement lineOfTheLog;
    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropDownButton;

    private DifferentElementsPage(WebDriver driver) {

        super(driver);
    }

    public DifferentElementsPage clickOnDropDown() {

        dropDownButton.click();
        return this;
    }

    public int checkboxSize() {

        return checkbox.size();
    }

    public int radioSize() {

        return radio.size();
    }

    public int selectSectionSize() {

        return selectSection.size();
    }

    public int buttonsSize() {

        return buttons.size();
    }

    public boolean rightSectionIsDisplayed() {

        return rightSection.isDisplayed();
    }

    public boolean leftSectionIsDisplayed() {

        return leftSection.isDisplayed();
    }

    public String getLineOfTheLog() {

        return lineOfTheLog.getText();
    }

    public void selectItemFromCheckBox(CheckBox option) {

        WebElement element = findItemInCheckBoxOrRadio(option.toString());
        element.click();
    }

    public void selectItemFromRadio(Radio option) {

        WebElement element = findItemInCheckBoxOrRadio(option.toString());
        element.click();
    }

    public void selectItemFromDropDown(DropDown option) {

        WebElement element = driver.findElement(By.xpath("//option[text()='"
                + option + "']"));
        element.click();
    }

    private WebElement findItemInCheckBoxOrRadio(String option) {
        return driver.findElement(By.xpath("//label[contains(.,'"
                + option + "')]/input"));
    }

    public static DifferentElementsPage getInstance(WebDriver driver) {
        if (instance == null || DifferentElementsPage.driver != driver) {
            instance = new DifferentElementsPage(driver);
            DifferentElementsPage.driver = driver;
        }
        return instance;
    }
}
