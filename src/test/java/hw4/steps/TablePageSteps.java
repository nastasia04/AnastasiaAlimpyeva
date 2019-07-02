package hw4.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.PageTitles;
import hw4.pages.TableWithPages;

import static com.codeborne.selenide.Condition.*;

public class TablePageSteps extends CommonSteps {
    private TableWithPages tableWithPages;
    private static String VALUE = "new value=";

    public TablePageSteps() {
        tableWithPages = new TableWithPages();
    }

    public TablePageSteps openTableWithPagesAndCheckIt(PageTitles expectedTitle) {
        SelenideElement title = tableWithPages.clickOnSubCategoryServiceHeader().
                clickOnTableWithPagesButton().getPageTitle();
        checkPageTitle(title, expectedTitle.toString());
        return this;
    }

    public TablePageSteps checkDefaultValueOfDropDownShowEntries(String defaultValue) {
        tableWithPages.getDropdownEntities().shouldHave(Condition.selectedText(defaultValue));
        return this;
    }

    public TablePageSteps checkRightSectionIsVisible() {
        checkElementIsDisplayed(tableWithPages.getRightSection());
        return this;
    }

    public TablePageSteps checkLeftSectionIsVisible() {
        checkElementIsDisplayed(tableWithPages.getLeftSection());
        return this;
    }

    public TablePageSteps selectNewValueAndCheckItInLog(String optionToSelect) {
        SelenideElement dropdownEntities = tableWithPages.getDropdownEntities();
        dropdownEntities.selectOptionContainingText(optionToSelect);
        dropdownEntities.shouldHave(value(optionToSelect));
        SelenideElement lineInLog = tableWithPages.getFirstLineInLogWithLength();
        lineInLog.should(exist);
        lineInLog.shouldHave(text(VALUE + optionToSelect));
        int expectedSize = Integer.parseInt(optionToSelect);
        tableWithPages.getTableWithPages().shouldHaveSize(expectedSize);
        return this;
    }

    public TablePageSteps typeInSearchFieldAndCheckIt(String searchItem) {
        tableWithPages.getSearchField().setValue(searchItem).pressEnter();
        checkElementsCollectionHaveExactItem(tableWithPages.getTableWithPages(), searchItem);
        return this;
    }

    private void checkElementsCollectionHaveExactItem(ElementsCollection elements, String item) {
        elements.forEach(element -> element.shouldHave(text(item)));
    }
}

