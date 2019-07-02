package hw4.ex1;

import hw4.base.BaseClass;
import hw4.enums.PageTitles;
import hw4.steps.TablePageSteps;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class Exercise1 extends BaseClass {
    private static final List<String> EXPECTED_OPTIONS_ON_SERVICE = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Table with pages",
            "Different elements");
    private static final String VALUEOFSEARCHFIELD = "Custom"; // ! _
    private static final String DEFAULT_VALUE_OF_DROP_DOWN_ENTRIES = "5";
    private static final String NEW_VALUE_OF_DROP_DOWN_ENTRIES = "10";

    @Test
    public void TestForExercise1() {

        //2 Assert Browser title
        basicSteps.checkHomePageTitle(PageTitles.HOMEPAGE)
                //3-4. Perform login
                .loginAndCheck(user)
                //5. Click on "Service" subcategory in the header and check that drop down contains options
                .checkDropDownAfterClickingServiceAtHeader(EXPECTED_OPTIONS_ON_SERVICE)
                //6. Click on Service subcategory in the left section and check that drop down contains options
                .checkDropDownAfterClickingServiceAtLeftSection(EXPECTED_OPTIONS_ON_SERVICE);

        // ! .onPage(TableWithPages.class)
        TablePageSteps steps = new TablePageSteps();
        //7. Open through the header menu Service -> Table with pages
        steps.openTableWithPagesAndCheckIt(PageTitles.TABLEWITHPAGES)
                //8.Check that default value for “Show entries” dropdown is 5
                .checkDefaultValueOfDropDownShowEntries(DEFAULT_VALUE_OF_DROP_DOWN_ENTRIES)
                //9. Assert that there is Right Section
                .checkRightSectionIsVisible()
                //10. Assert that there is Left Section
                .checkLeftSectionIsVisible()
                //11-13 select new value, assert log, assert amount of entries
                .selectNewValueAndCheckItInLog(NEW_VALUE_OF_DROP_DOWN_ENTRIES)
                //14-15 Type in “Search” text field "Custom" and
                // assert the table contains only records with Search field value
                .typeInSearchFieldAndCheckIt(VALUEOFSEARCHFIELD);
    }
}
