package hw3.steps;

import hw3.enums.CheckBox;
import hw3.enums.DropDown;
import hw3.enums.PageTitles;
import hw3.enums.Radio;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import hw3.pages.DifferentElementsPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps extends BaseTestSteps {
    DifferentElementsPage page;

    public DifferentElementsPageSteps(WebDriver driver) {
        super(driver);
        page = new DifferentElementsPage(driver);
    }

    @Override
    public void checkItemsHaveTheCorrectText(List<String> actualText, List<String> expectedText) {
        assertTrue(listToLowerCase(actualText).containsAll(listToLowerCase(expectedText)),
                "The list of web elements doesn't contain expected items");
    }

    public void checkDropDownAfterClickingServiceAtHeader(List<String> expectedText) {
        page.clickOnSubCategoryServiceHeader();
        checkElementsFromTheListAreDisplayed(page.getServiceDropDownHeader());
        checkItemsHaveTheCorrectText(page.getServiceDropDownHeaderText(), expectedText);
    }

    public void checkDropDownAfterClickingServiceAtLeftSection(List<String> expectedText) {
        page.clickOnSubCategoryServiceLeft();
        checkElementsFromTheListAreDisplayed(page.getServiceDropDownLeft());
        checkItemsHaveTheCorrectText(page.getServiceDropDownLeftSectionText(), expectedText);
    }

    public void openDifferentElementsPage(PageTitles expectedTitle) {
        page.clickOnSubCategoryServiceHeader();
        page.clickDifferentElements();
        checkPageTitle(page.getPageTitle(), expectedTitle.toString());
    }

    public void checkRightSection() {

        checkElementIsDisplayed(page.rightSectionIsDisplayed());
    }

    public void checkLeftSection() {

        checkElementIsDisplayed(page.leftSectionIsDisplayed());
    }

    public void checkDifferentPageElements(int expectedCheckboxSize,
                                           int expectedRadioSize,
                                           int expectedSelectSection,
                                           int expectedButtons) {
        checkSizeOfTheListOfElements(page.checkboxSize(), expectedCheckboxSize);
        checkSizeOfTheListOfElements(page.radioSize(), expectedRadioSize);
        checkSizeOfTheListOfElements(page.selectSectionSize(), expectedSelectSection);
        checkSizeOfTheListOfElements(page.buttonsSize(), expectedButtons);
    }

    public void checkSelectItemInTheCheckBox(CheckBox option, boolean isSelected) {
        WebElement item = page.selectItemFromCheckBox(option);
        checkSelectItemAndCheckItInTheLog(item, option.toString(), isSelected);
    }

    public void checkSelectItemInTheRadio(Radio option, boolean isSelected) {
        WebElement item = page.selectItemFromRadio(option);
        checkSelectItemAndCheckItInTheLog(item, option.toString(), isSelected);
    }

    public void checkSelectItemInTheDropDown(DropDown option, boolean isSelected) {
        page.clickOnDropDown();
        WebElement item = page.selectItemFromDropDown(option);
        checkSelectItemAndCheckItInTheLog(item, option.toString(), isSelected);
    }

    public void checkSelectItemAndCheckItInTheLog(WebElement item,
                                                  String option,
                                                  boolean isSelected) {
        assertEquals(item.isSelected(), isSelected, "Item value is unexpected");
        checkLogSection(option, item);
    }

    private void checkLogSection(String option, WebElement item) {
        String lineOfTheLog, itemName, isSelected;
        lineOfTheLog = page.getLineOfTheLog();
        if (optionInTheCheckBoxEnum(option)) {
            itemName = item.getText().trim();
            isSelected = String.valueOf(item.isSelected());
            assertTrue(lineOfTheLog.contains(isSelected));
        } else {
            itemName = item.getText().trim();
        }
        assertTrue(lineOfTheLog.contains(itemName));
    }

    private boolean optionInTheCheckBoxEnum(String option) {
        for (Object enumObject : CheckBox.values()) {
            if (option.equals(enumObject.toString())) {
                return true;
            }
        }
        return false;
    }
}

