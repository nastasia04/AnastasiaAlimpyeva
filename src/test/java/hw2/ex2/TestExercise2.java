package hw2.ex2;

import hw2.base.BaseClass;
import hw2.steps.StepsForExercise2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestExercise2 extends BaseClass {
    // TODO It is better use 'private static final' modifier for constants
    private StepsForExercise2 step;
    private List<String> expectedOptionsOnService = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Table with pages",
            "Different elements");

    @Test
    public void TestForExercise2() {
        step = new StepsForExercise2(driver);
        //5 Click on "Service" subcategory in the header and check that drop down contains options
        step.clickOnTheSubcategory("//ul[contains(@class, 'm-l8')]//span[@class='caret']");
        step.checkItemsAreDisplayedAndHadTheCorrectText(
                "//ul[@class = 'dropdown-menu']/li/a",
                listToUpperCase(expectedOptionsOnService));

        //6. Click on Service subcategory in the left section and check that drop down contains options
        step.clickOnTheSubcategory("//li[contains(@class, 'menu-title')]//span[text()='Service']");
        step.checkItemsAreDisplayedAndHadTheCorrectText(
                "//li[contains(@class, 'menu-title')]//ul[@class='sub']//a",
                expectedOptionsOnService);

        //7. Open through the header menu Service -> Different Elements Page
        step.openDifferentElementsPage();
        baseTestSteps.checkPageTitle("Different Elements");

        //8. Check interface on Different elements page, it contains all needed elements
        step.checkDifferentPageElements();

        //9. Assert that there is Right Section
        step.checkElementIsDisplayed("//div[@name ='navigation-sidebar']");

        //10. Assert that there is Left Section
        step.checkElementIsDisplayed("//div[@name ='log-sidebar']");

        //11 -12. Select checkboxes and assert that for each checkbox
        // there is an individual log row and value is corresponded to the status of checkbox. 
        // TODO Is it possible send as parameter name of checkboxes, options and etc.?
        step.checkSelectItemAndCheckItInTheLog("//label[contains(.,'Water')]/input",
                true);
        // TODO Is it possible send as parameter name of checkboxes, options and etc.?
        step.checkSelectItemAndCheckItInTheLog(
                "//label[contains(.,'Wind')]/input", true);

        //13-14. Select radio and check it
        // TODO Is it possible send as parameter name of checkboxes, options and etc.?
        step.checkSelectItemAndCheckItInTheLog(
                "//label[contains(.,'Selen')]/input", true);

        //15 -16. Select in dropdown Yellow and check it
        String xpath = " //select[@class='uui-form-element']";
        driver.findElement(By.xpath(xpath)).click();
        // TODO Is it possible send as parameter name of checkboxes, options and etc.?
        step.checkSelectItemAndCheckItInTheLog(xpath + "/option[text()='Yellow']",
                true);

        //17-18. Unselect and assert checkboxes
        // TODO Is it possible send as parameter name of checkboxes, options and etc.?
        step.checkSelectItemAndCheckItInTheLog("//label[contains(.,'Water')]/input",
                false);
        // TODO Is it possible send as parameter name of checkboxes, options and etc.?
        step.checkSelectItemAndCheckItInTheLog("//label[contains(.,'Wind')]/input",
                false);

    }

    private List<String> listToUpperCase(List<String> words) {
        // TODO option -> option.toUpperCase() could be replaced String::toUpperCase
        return words.stream().map(option -> option.toUpperCase()).collect(Collectors.toList());
    }
}
