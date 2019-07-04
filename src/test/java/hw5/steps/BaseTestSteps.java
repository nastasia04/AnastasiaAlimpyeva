package hw5.steps;

import hw3.enums.Url;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseTestSteps {
    protected WebDriver driver;

    protected BaseTestSteps(WebDriver driver) {

        this.driver = driver;
    }
    @Step("Load page '{0}'")
    public void loadPage(Url url) {
        driver.get(url.toString());
        Dimension dimension = new Dimension(450,600);
        driver.manage().window().setSize(dimension);
        //driver.manage().window().maximize();
    }
    @Step("Check page title. Title should be '{1}'")
    public void checkPageTitle(String actualTitle, String expectedTitle) {
        assertEquals(actualTitle, expectedTitle, "The page title is unexpected");
    }

    public void checkElementIsDisplayed(WebElement webElement) {
        assertTrue(webElement.isDisplayed(), "Items should be displayed");
    }

    public void checkElementIsDisplayed(boolean condition) {

        assertTrue(condition, "Items should be displayed");
    }

    public void checkTheCorrectText(String actualText, String expectedText) {
        assertEquals(actualText.toLowerCase(), expectedText.toLowerCase(), "The text is unexpected");
    }

    public void checkItemsHaveTheCorrectText(List<String> actualText, List<String> expectedText) {
        assertEquals(actualText, expectedText, "Text in web elements is unexpected");
    }

    protected void checkSizeOfTheListOfElements(List<WebElement> webElements, int expectedSize) {
        assertEquals(webElements.size(), expectedSize, "The size of web elements is unexpected");
    }

    protected void checkSizeOfTheListOfElements(int actualSize, int expectedSize) {
        assertEquals(actualSize, expectedSize, "The size of web elements is unexpected");
    }

    protected void checkElementsFromTheListAreDisplayed(List<WebElement> webElements) {
        SoftAssert softAssert = new SoftAssert();
        webElements.forEach(webElement -> softAssert.assertTrue(webElement.isDisplayed()));
        softAssert.assertAll();
    }

    protected List<String> listToLowerCase(List<String> words) {
        return words.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}