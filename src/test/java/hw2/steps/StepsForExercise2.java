package hw2.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsForExercise2 extends BaseTestSteps {

    public StepsForExercise2(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkItemsAreDisplayedAndHadTheCorrectText(String xpathSearch,
                                                           List<String> expectedText) {
        List<WebElement> webElements = driver.findElements(By.xpath(xpathSearch));
        List<String> webElementsText = takeTextFromListOfWebElements(webElements);
        checkElementsFromTheListAreDisplayed(webElements);
        assertTrue(webElementsText.containsAll(expectedText),
                "The list of web elements doesn't contain expected items");
    }

    public void clickOnTheSubcategory(String xpathSearch) {
        WebElement item = driver.findElement(By.xpath(xpathSearch));
        item.click();
    }

    public void openDifferentElementsPage() {
        driver.findElement(By.xpath("//ul[contains(@class, 'm-l8')]//span[@class='caret']")).click();
        driver.findElement(By.xpath("//ul[contains(@class, 'm-l8')]//a[text() ='Different elements']")).click();
    }

    public void checkDifferentPageElements() {
        checkSizeOfTheListOfElements(
                driver.findElements(By.xpath("//label[@class='label-checkbox']")),
                4);
        checkSizeOfTheListOfElements(
                driver.findElements(By.xpath("//label[@class='label-radio']")),
                4);
        checkSizeOfTheListOfElements(
                driver.findElements(By.xpath("//select")),
                1);
        checkSizeOfTheListOfElements(
                driver.findElements(By.xpath("//*[contains(@value,'Button')]")),
                2);
    }

    public void checkSelectItemAndCheckItInTheLog(String xpathOption, boolean isSelected) {
        WebElement item = selectItemAndCheckIt(xpathOption, isSelected);
        checkLogSection(xpathOption, item);
    }

    private WebElement selectItemAndCheckIt(String xpathSearch, boolean isSelected) {
        WebElement item = driver.findElement(By.xpath(xpathSearch));
        item.click();
        assertEquals(item.isSelected(), isSelected, "Item value is unexpected");
        return item;
    }

    private void checkLogSection(String xpathSearch, WebElement item) {
        String lineOfTheLog,itemName, isSelected;
        lineOfTheLog = driver.findElement(
                By.xpath("//ul[contains(@class,'panel-body-list logs')]/li")).getText();
        if (xpathSearch.contains("label-checkbox")) {
            itemName = item.getText().trim();
            isSelected = "" + item.isSelected();
            assertTrue(lineOfTheLog.contains(isSelected));
        } else {
            itemName = item.getText().trim();
        }
        assertTrue(lineOfTheLog.contains(itemName));
    }
}
