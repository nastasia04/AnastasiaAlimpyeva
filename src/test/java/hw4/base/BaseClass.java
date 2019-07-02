package hw4.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import hw4.enums.Url;
import hw4.steps.BasePageSteps;
import hw4.user.User;
import hw4.utils.UtilsFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


public class BaseClass {
    protected WebDriver driver;
    protected BasePageSteps steps;
    private static final String USERDATA = "src/test/resources/properties/user.properties";
    protected User user;
    protected BasePageSteps basicSteps;

    @BeforeMethod
    public void setUpMethod() {

        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        open(Url.HOME.toString());
        basicSteps = new BasePageSteps();
        user = UtilsFunctions.readUserFromFile(USERDATA);
    }

    @AfterMethod
    public void tearDown() {
        close();
    }
}
