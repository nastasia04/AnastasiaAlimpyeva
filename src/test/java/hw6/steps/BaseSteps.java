package hw6.steps;

import hw6.hooks.Context;
import hw6.pages.DifferentElementsPage;
import hw6.pages.HomePage;
import hw6.pages.UserTablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseSteps {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    protected BaseSteps() {
        homePage = HomePage.getInstance(Context.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(Context.getDriver());
        userTablePage = UserTablePage.getInstance(Context.getDriver());
    }

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

    public void checkSizeOfTheListOfElements(List<WebElement> webElements, int expectedSize) {
        assertEquals(webElements.size(), expectedSize, "The size of web elements is unexpected");
    }

    public void checkSizeOfTheListOfElements(int actualSize, int expectedSize) {
        assertEquals(actualSize, expectedSize, "The size of web elements is unexpected");
    }

    public void checkItemsIncludeTheCorrectText(List<String> actualText, List<String> expectedText) {
        assertTrue(listToLowerCase(actualText).containsAll(listToLowerCase(expectedText)),
                "The list of web elements doesn't contain expected items");
    }

    public void checkElementsFromTheListAreDisplayed(List<WebElement> webElements) {
        SoftAssert softAssert = new SoftAssert();
        webElements.forEach(webElement -> softAssert.assertTrue(webElement.isDisplayed()));
        softAssert.assertAll();
    }

    public void checkElementIsDisplayedAndHaveCorrectText(WebElement webElement, String expectedText) {
        checkElementIsDisplayed(webElement);
        checkTheCorrectText(webElement.getText(), expectedText);
    }

    public void checkItemsAreDisplayedAndHaveCorrectLength(List<WebElement> actualItems,
                                                           int expectedLength) {
        checkSizeOfTheListOfElements(actualItems, expectedLength);
        checkElementsFromTheListAreDisplayed(actualItems);
    }

    public List<String> listToLowerCase(List<String> words) {
        return words.stream().map(String::toLowerCase).collect(Collectors.toList());
    }
}
