package hw3.base;

import hw3.enums.PageTitles;
import hw3.enums.Url;
import hw3.steps.HomePageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import hw3.user.User;
import hw3.utils.UtilsFunctions;

public class BaseClass {
    protected WebDriver driver;
    protected HomePageSteps steps;
    // TODO Java Code Convention for the constants -fixed
    private static final String USERDATA = "src/TestRunner/resources/properties/user.properties";
    private User user;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        steps = new HomePageSteps(driver);
        user = UtilsFunctions.readUserFromFile(USERDATA);
        //1-4 steps for both tasks
        steps.loadPage(Url.HOME);
        steps.checkHomePageTitle(PageTitles.HOMEPAGE);
        steps.loginAndCheck(user);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
