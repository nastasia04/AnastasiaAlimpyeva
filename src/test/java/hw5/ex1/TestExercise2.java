package hw5.ex1;

import hw3.enums.*;
import hw5.AllureAttachmentListener;
import hw5.base.BaseClass;
import hw5.steps.DifferentElementsPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
@Listeners(AllureAttachmentListener.class)
public class TestExercise2 extends BaseClass {
    private DifferentElementsPageSteps step;
    private static final List<String> expectedOptionsOnService = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Table with pages",
            "Different elements");

    @Test
    @Story(value = "Check page with different elements")
    @Feature(value = "Exercise1 TestRunner")
   public void TestForExercise2() {
        step = new DifferentElementsPageSteps(driver);
        //5 Click on "Service" subcategory in the header and check that drop down contains options
        step.checkDropDownAfterClickingServiceAtHeader(expectedOptionsOnService);

        //6. Click on Service subcategory in the left section and check that drop down contains options
        step.checkDropDownAfterClickingServiceAtLeftSection(expectedOptionsOnService);

        //7. Open through the header menu Service -> Different Elements Page
        step.openDifferentElementsPage(PageTitles.DIFFERENTELEMNTS);

        //8. Check interface on Different elements page, it contains all needed elements
        step.checkDifferentPageElements(ElementsCount.CHECKBOX.getCount(),
                ElementsCount.RADIO.getCount(),
                ElementsCount.SELECT.getCount(),
                ElementsCount.BUTTON.getCount());
        //9. Assert that there is Right Section
        step.checkRightSection();

        //10. Assert that there is Left Section
        step.checkLeftSection();

        //11 -12. Select checkboxes and assert that for each checkbox
        // there is an individual log row and value is corresponded to the status of checkbox.
        step.checkSelectItemInTheCheckBox(CheckBox.WATER,true );
        step.checkSelectItemInTheCheckBox(CheckBox.WIND, true);

        //13-14. Select radio and check it
        step.checkSelectItemInTheRadio(Radio.SELEN, true);

        //15 -16. Select in dropdown Yellow and check it
        step.checkSelectItemInTheDropDown(DropDown.YELLOW, true);
        //17-18. Unselect and assert checkboxes
        step.checkSelectItemInTheCheckBox(CheckBox.WATER, false);
        step.checkSelectItemInTheCheckBox(CheckBox.WIND, false);


    }
}