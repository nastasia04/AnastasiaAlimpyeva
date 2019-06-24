package hw2.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTestSteps {
    protected WebDriver driver;

    public BaseTestSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void checkPageTitle(String title) {
        assertEquals(driver.getTitle(), title, "A page title is unexpected");
    }

    public void login(String userName, String password) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    public void checkUserIsLogged(String correctUserName) {
        // TODO This variable is redundant - fixed
        assertEquals(driver.findElement(By.xpath("//span[@id='user-name']")).getText(),
                correctUserName, "The user name is unexpected");
    }

    public void checkElementIsDisplayed(String xpathSearch) {
        WebElement item = driver.findElement(By.xpath(xpathSearch));
        assertTrue(item.isDisplayed(), "Items should be displayed");
    }

    // TODO checkItemsAreDisplayedAndHaveTheCorrectText use have instead of had - fixed
    public void checkItemsAreDisplayedAndHaveTheCorrectText(String xpathSearch,
                                                            List<String> expectedText) {
        List<WebElement> webElements = driver.findElements(By.xpath(xpathSearch));
        checkSizeOfTheListOfElements(webElements, expectedText.size());
        checkElementsFromTheListAreDisplayed(webElements);

        List<String> headElementsText = getTextFromListOfWebElements(webElements);
        assertEquals(headElementsText, expectedText, "Text in web elements is unexpected");
    }

    protected void checkSizeOfTheListOfElements(List<WebElement> webElements, int expectedSize) {
        assertEquals(webElements.size(), expectedSize, "The size of web elements is unexpected");
    }

    // TODO getTextFrom... - fixed
    protected List<String> getTextFromListOfWebElements(List<WebElement> webElements) {
        // TODO webElement -> webElement.getText() Could be replaced WebElement::getText - fixed
        return webElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    protected void checkElementsFromTheListAreDisplayed(List<WebElement> webElements) {
        SoftAssert softAssert = new SoftAssert();
        // TODO stream() is not required here. Could be used only webElements.forEach( ... ) - fixed
        // TODO Please pay attention IDEA comments
        webElements.forEach(webElement -> softAssert.assertTrue(webElement.isDisplayed()));
        softAssert.assertAll();
    }
}