package hw3.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    @FindBy(xpath = "//div[@class='benefit-icon']")
    private  List<WebElement> icons;
    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> textUnderTheIcons;
    @FindBy(xpath = "//h3[@name='main-title']")
    private  WebElement mainHeader;
    @FindBy(xpath = "//p[@name='jdi-text']")
    private WebElement mainHeaderText;
    @FindBy(xpath = "//iframe[@id='iframe']")
    private  WebElement iframe;
    @FindBy(id = "epam_logo")
    private  WebElement epamLogo;
    @FindBy(xpath = "//a[contains(.,'JDI')]")
    private  WebElement subHeader;
    @FindBy(xpath = "//a[contains(.,'JDI')]")
    private WebElement link;

    public HomePage(WebDriver driver){

        super(driver);
    }

    public List<WebElement> getIconsFromHomePage(){

        return icons;
    }

    public List<WebElement> getWebElementsUnderTheIcons(){

        return textUnderTheIcons;
    }

    public List<String> getTextUnderTheIcons(){

        return utilsFunctions.getTextFromListOfWebElements(textUnderTheIcons);
    }

    public WebElement getMainHeader(){

        return mainHeader;
    }
    public WebElement getMainHeaderText(){

        return mainHeaderText;
    }

    // TODO getIFrame - fixed
    public WebElement getIFrame(){

        return iframe;
    }

    // TODO switchToIFrame - fixed
    public void switchToIFrame(){

        driver.switchTo().frame(iframe);
    }
    public boolean epamLogoIsDisplayed(){

        return epamLogo.isDisplayed();
    }
    public void switchBackToHomeWindow(){

        driver.switchTo().defaultContent();
    }
    public WebElement getSubHeader(){

        return subHeader;
    }
    public String getLink(){

        return link.getAttribute("href");
    }

}
