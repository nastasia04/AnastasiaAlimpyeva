package hw2.ex2;

import hw2.base.BaseClass;
import hw2.steps.StepsForExercise2.NamesForSelectSections;
import hw2.steps.StepsForExercise2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestExercise2 extends BaseClass {
    private StepsForExercise2 step;
    private static final List<String> expectedOptionsOnService = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Table with pages",
            "Different elements");

    @Test
    public void TestForExercise2() {
        step = new StepsForExercise2(driver);
        //5 Click on "Service" subcategory in the header and check that drop down contains options
        step.clickOnTheSubcategory("//ul[contains(@class, 'm-l8')]//span[@class='caret']");
        step.checkItemsAreDisplayedAndHaveTheCorrectText(
                "//ul[@class = 'dropdown-menu']/li/a",
                listToUpperCase(expectedOptionsOnService));

        //6. Click on Service subcategory in the left section and check that drop down contains options
        step.clickOnTheSubcategory("//li[contains(@class, 'menu-title')]//span[text()='Service']");
        step.checkItemsAreDisplayedAndHaveTheCorrectText(
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
        // there is an individual log row and value is corresponded to the status of checkbox.
        step.checkSelectItemAndCheckItInTheLog(NamesForSelectSections.CHECKBOX,
                "Water",
                true);
        step.checkSelectItemAndCheckItInTheLog(NamesForSelectSections.CHECKBOX,
                "Wind",
                true);

        //13-14. Select radio and check it
        step.checkSelectItemAndCheckItInTheLog(NamesForSelectSections.RADIO,
                "Selen",
                true);

        //15 -16. Select in dropdown Yellow and check it
        String xpath = " //select[@class='uui-form-element']";
        driver.findElement(By.xpath(xpath)).click();
        step.checkSelectItemAndCheckItInTheLog(NamesForSelectSections.DROPDOWN,
                "Yellow",
                true);

        //17-18. Unselect and assert checkboxes
        step.checkSelectItemAndCheckItInTheLog(NamesForSelectSections.CHECKBOX,
                "Water",
                false);
        step.checkSelectItemAndCheckItInTheLog(NamesForSelectSections.CHECKBOX,
                "Wind",
                false);

    }

    private List<String> listToUpperCase(List<String> words) {
        return words.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}