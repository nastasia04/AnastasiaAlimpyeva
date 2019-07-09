package hw2.base;

import hw2.steps.BaseTestSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class BaseClass {
    protected WebDriver driver;
    private static String os;
    protected BaseTestSteps baseTestSteps;

    @BeforeSuite
    public void setUpSuite() {
        os = System.getProperty("os.name").toLowerCase();
        // for Google Chrome version 75
        if (os.contains("win")) {
            setDriver("chromedriver.exe");
        }
        else if (os.contains("osx")) {
            setDriver("chromedriver");
        }
    }

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseTestSteps = new BaseTestSteps(driver);
        //1-4 steps for both tasks
        driver.get("https://epam.github.io/JDI/");
        baseTestSteps.checkPageTitle("Home Page");
        baseTestSteps.login("epam", "1234");
        baseTestSteps.checkUserIsLogged("PITER CHAILOVSKII");
    }

    @AfterMethod
    public void tearDown() {
        // Close Browser
        driver.quit();
    }

    private void setDriver(String driver){
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/TestRunner/resources/driver/"+ driver).toAbsolutePath().toString());
    }
}
