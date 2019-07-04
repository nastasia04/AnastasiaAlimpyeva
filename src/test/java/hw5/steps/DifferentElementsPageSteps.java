package hw5.steps;

import hw3.enums.CheckBox;
import hw3.enums.DropDown;
import hw3.enums.PageTitles;
import hw3.enums.Radio;
import hw3.pages.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    @Step("Click on \"Service\" subcategory in the header and check that drop down contains options")
    public void checkDropDownAfterClickingServiceAtHeader(List<String> expectedText) {
        page.clickOnSubCategoryServiceHeader();
        checkElementsFromTheListAreDisplayed(page.getServiceDropDownHeader());
        checkItemsHaveTheCorrectText(page.getServiceDropDownHeaderText(), expectedText);
    }

    @Step("Click on Service subcategory in the left section and check that drop down contains options")
    public void checkDropDownAfterClickingServiceAtLeftSection(List<String> expectedText) {
        page.clickOnSubCategoryServiceLeft();
        checkElementsFromTheListAreDisplayed(page.getServiceDropDownLeft());
        checkItemsHaveTheCorrectText(page.getServiceDropDownLeftSectionText(), expectedText);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage(PageTitles expectedTitle) {
        page.clickOnSubCategoryServiceHeader();
        page.clickDifferentElements();
        checkPageTitle(page.getPageTitle(), expectedTitle.toString());
    }

    @Step("Assert that there is Right Section")
    public void checkRightSection() {

        checkElementIsDisplayed(page.rightSectionIsDisplayed());
    }

    @Step("Assert that there is Left Section")
    public void checkLeftSection() {

        checkElementIsDisplayed(page.leftSectionIsDisplayed());
    }

    @Step("Check interface on Different elements page, it contains all needed elements:"+
    "Checkbox - '{0}'\nRadio - '{1}'\nSelectSection - '{2}'\nButton - '{3}")
    public void checkDifferentPageElements(int expectedCheckboxSize,
                                           int expectedRadioSize,
                                           int expectedSelectSection,
                                           int expectedButtons) {
        checkSizeOfTheListOfElements(page.checkboxSize(), expectedCheckboxSize);
        checkSizeOfTheListOfElements(page.radioSize(), expectedRadioSize);
        checkSizeOfTheListOfElements(page.selectSectionSize(), expectedSelectSection);
        checkSizeOfTheListOfElements(page.buttonsSize(), expectedButtons);
    }

    @Step("Select checkbox '{0}'")
    public void checkSelectItemInTheCheckBox(CheckBox option, boolean isSelected) {
        WebElement item = page.selectItemFromCheckBox(option);
        checkSelectItemAndCheckItInTheLog(item, option.toString(), isSelected);
    }

    @Step("Select radio '{0}'")
    public void checkSelectItemInTheRadio(Radio option, boolean isSelected) {
        WebElement item = page.selectItemFromRadio(option);
        checkSelectItemAndCheckItInTheLog(item, option.toString(), isSelected);
    }

    @Step("Select in dropdown '{0}'")
    public void checkSelectItemInTheDropDown(DropDown option, boolean isSelected) {
        page.clickOnDropDown();
        WebElement item = page.selectItemFromDropDown(option);
        checkSelectItemAndCheckItInTheLog(item, option.toString(), isSelected);
    }

    @Step("Assert that for '{1}' there is an individual log row and value is " +
            "corresponded to the status of checkbox.")
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

