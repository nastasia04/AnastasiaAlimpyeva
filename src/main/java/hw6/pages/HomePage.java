package hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    private static HomePage instance;
    private static WebDriver driver;


    @FindBy(xpath = "//div[@class='benefit-icon']")
    private List<WebElement> icons;
    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> textUnderTheIcons;
    @FindBy(xpath = "//h3[@name='main-title']")
    private WebElement mainHeader;
    @FindBy(xpath = "//p[@name='jdi-text']")
    private WebElement mainHeaderText;
    @FindBy(xpath = "//iframe[@id='iframe']")
    private WebElement iframe;
    @FindBy(id = "epam_logo")
    private WebElement epamLogo;
    @FindBy(xpath = "//a[contains(.,'JDI')]")
    private WebElement subHeader;
    @FindBy(xpath = "//a[contains(.,'JDI')]")
    private WebElement link;

    private HomePage(WebDriver driver) {

        super(driver);
    }

    public List<WebElement> getIconsFromHomePage() {

        return icons;
    }

    public List<WebElement> getWebElementsUnderTheIcons() {

        return textUnderTheIcons;
    }

    public WebElement getMainHeader() {

        return mainHeader;
    }

    public WebElement getMainHeaderText() {

        return mainHeaderText;
    }

    public String getLink() {

        return link.getAttribute("href");
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null || HomePage.driver != driver) {
            instance = new HomePage(driver);
            HomePage.driver = driver;
        }
        return instance;
    }

}
