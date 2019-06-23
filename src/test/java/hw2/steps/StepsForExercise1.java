package hw2.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.*;

public class StepsForExercise1 extends BaseTestSteps {

    public StepsForExercise1(WebDriver driver) {
        super(driver);
    }

    public void checkImagesAreDisplayed(int imageCount) {
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='benefit-icon']"));
        checkSizeOfTheListOfElements(images, imageCount);
        checkElementsFromTheListAreDisplayed(images);
    }

    public void checkTextIsDisplayedAndEqualsToExpectedResult(String xpathSearch, String expectedText) {
        WebElement actualText = driver.findElement(By.xpath(xpathSearch));
        assertTrue(actualText.isDisplayed(), "Text is not displayed");
        assertEquals(actualText.getText(), expectedText.toUpperCase(), "Text is unexpected");
    }

    public void checkEpamLogoOnTeIframe() {
        driver.switchTo().frame("iframe");
        WebElement item = driver.findElement(By.id("epam_logo"));
        assertTrue(item.isDisplayed(), "Epam_logo is not displayed");
        driver.switchTo().defaultContent();
    }

    public void checkLink(String xpathSearch, String expectedLink) {
        checkElementIsDisplayed(xpathSearch);
        WebElement item = driver.findElement(By.xpath(xpathSearch));
        assertEquals(item.getAttribute("href"), expectedLink, "The link is wrong");
    }
}


