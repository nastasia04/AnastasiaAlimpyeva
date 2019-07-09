package hw6.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends BasePage {
    private static UserTablePage instance;
    private static WebDriver driver;

    private UserTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select")
    @Getter
    private List<WebElement> dropDownSelect;
    @FindBy(xpath = "//td/a")
    private List<WebElement> userNames;
    @FindBy(xpath = "//td//img")
    private List<WebElement> descriptionsImages;
    @FindBy(xpath = "//div[@class='user-descr']//span")
    private List<WebElement> descriptionsTexts;
    @FindBy(xpath = "//td//input")
    private List<WebElement> checkboxes;
    @FindBy(xpath = "//label[contains(@for,'ivan')]")
    private WebElement vipCheckBoxIvan;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> log;


    public int getDropDownSelectCount() {

        return dropDownSelect.size();
    }

    public int getUserNamesCount() {

        return userNames.size();
    }

    public int getDescriptionImagesCount() {

        return descriptionsImages.size();
    }

    public int getDescriptionTextsCount() {

        return descriptionsTexts.size();
    }

    public int getCheckBoxesCount() {

        return checkboxes.size();
    }

    public List<String> getNames() {

        return utilsFunctions.getTextFromListOfWebElements(userNames);
    }

    public void vipCheckBoxIvanClick(String name) {
        driver.findElement(By.xpath("//input[@id='" + name + "']")).click();
    }

    public List<String> getTextDescription() {

        return utilsFunctions.getTextFromListOfWebElements(descriptionsTexts);
    }

    public List<String> getTextFromLog() {
        return utilsFunctions.getTextFromListOfWebElements(log);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null || UserTablePage.driver != driver) {
            instance = new UserTablePage(driver);
            UserTablePage.driver = driver;
        }
        return instance;
    }

}
