package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.enums.*;
import hw6.hooks.Context;
import hw6.user.UserStructure;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseSteps {

    @Then("'(HOME_PAGE|DIFFERENT_ELEMENTS|USER_TABLE)' page is opened")
    public void assertTitle(PageTitles expectedTitle) {
        checkPageTitle(Context.getDriver().getTitle(), expectedTitle.toString());
    }

    @Then("User name should be '([^\"]*)'")
    public void checkUserIsLogged(String expectedUserName) {
        assertEquals(homePage.getUserName(), expectedUserName, "The user name is unexpected");
    }

    @Then("Home page should have '([^\\d]*)' pictures")
    public void checkImagesOnHomePage(ElementsCount imageCount) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getIconsFromHomePage(), imageCount.getCount());
    }

    @Then("Home page should have (\\d+) texts under pictures")
    public void checkCountOfTextsUnderIcons(int expectedTextCount) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getWebElementsUnderTheIcons(), expectedTextCount);
    }

    @Then("Home page should have headline '([^\"]*)' and description '([^\"]*)'")
    public void checkTextOfTheMainHeaders(Header mainHeader, Header mainHeaderText) {
        checkElementIsDisplayedAndHaveCorrectText(homePage.getMainHeader(), mainHeader.toString());
        checkElementIsDisplayedAndHaveCorrectText(homePage.getMainHeaderText(), mainHeaderText.toString());
    }

    @Then("Service DropDown list contains options")
    public void checkDropDownAfterClickingServiceAtHeader(List<String> expectedText) {
        checkElementsFromTheListAreDisplayed(differentElementsPage.getServiceDropDownHeader());
        checkItemsIncludeTheCorrectText(differentElementsPage.getServiceDropDownHeaderText(), expectedText);
    }

    @Then("Service Left Section list contains options")
    public void checkDropDownAfterClickingServiceAtLeftSection(List<String> expectedText) {
        checkElementsFromTheListAreDisplayed(differentElementsPage.getServiceDropDownLeft());
        checkItemsIncludeTheCorrectText(differentElementsPage.getServiceDropDownLeftSectionText(), expectedText);
    }


    @Then("Check interface: checkBox '([^\\d]*)', Radio '([^\\d]*)', " +
            "SelectSection '([^\\d]*)', Buttons '([^\\d]*)'")
    public void checkDifferentPageElements(ElementsCount expectedCheckboxSize,
                                           ElementsCount expectedRadioSize,
                                           ElementsCount expectedSelectSection,
                                           ElementsCount expectedButtons) {
        checkSizeOfTheListOfElements(differentElementsPage.checkboxSize(), expectedCheckboxSize.getCount());
        checkSizeOfTheListOfElements(differentElementsPage.radioSize(), expectedRadioSize.getCount());
        checkSizeOfTheListOfElements(differentElementsPage.selectSectionSize(), expectedSelectSection.getCount());
        checkSizeOfTheListOfElements(differentElementsPage.buttonsSize(), expectedButtons.getCount());
    }

    @Then("There is Right Section on Different Elements page")
    public void checkRightSection() {

        checkElementIsDisplayed(differentElementsPage.rightSectionIsDisplayed());
    }

    @Then("There is Left Section on Different Elements page")
    public void checkLeftSection() {

        checkElementIsDisplayed(differentElementsPage.leftSectionIsDisplayed());
    }

    @Then("Log row changes status to '([^\"]*)' for checkbox '(WATER|EARTH|WIND|FIRE)' on Different Elements page")
    public void checkLogForCheckBox(String isSelected, CheckBox option) {
        checkLogSection(option.toString(), isSelected);
    }

    @Then("Log row changes status to '([^\"]*)' for select option '(YELLOW|GREEN|RED|BLUE)' on Different Elements page")
    public void checkLogForSelectSection(String isSelected, DropDown option) {
        checkLogSection(option.toString(), isSelected);
    }

    @Then("Log row changes status to '([^\"]*)' for radio '(SELEN|GOLD|SILVER|BRONZE)' on Different Elements page")
    public void checkLogForSelectSection(String isSelected, Radio option) {
        checkLogSection(option.toString(), isSelected);
    }

    @Then("'([^\"]*)' dropdowns are displayed on Users Table on User Table Page")
    public void checkCountOfDropDowns(ElementsCount expectedCount) {
        assertEquals(userTablePage.getDropDownSelectCount(), expectedCount.getCount(),
                "The count of dropdowns is unexpected");
    }

    @Then("'([^\"]*)' names are displayed on Users Table on User Table Page")
    public void checkCountOfNames(ElementsCount expectedCount) {
        assertEquals(userTablePage.getUserNamesCount(), expectedCount.getCount(),
                "The count of dropdowns is unexpected");
    }

    @Then("'([^\"]*)' images are displayed on Users Table on User Table Page")
    public void checkCountOfImages(ElementsCount expectedCount) {
        assertEquals(userTablePage.getDescriptionImagesCount(), expectedCount.getCount(),
                "The count of dropdowns is unexpected");
    }

    @Then("'([^\"]*)' texts are displayed on Users Table on User Table Page")
    public void checkCountOfTexts(ElementsCount expectedCount) {
        assertEquals(userTablePage.getDescriptionTextsCount(), expectedCount.getCount(),
                "The count of dropdowns is unexpected");
    }

    @Then("'([^\"]*)' checkboxes are displayed on Users Table on User Table Page")
    public void checkCountOfCheckboxes(ElementsCount expectedCount) {
        assertEquals(userTablePage.getCheckBoxesCount(), expectedCount.getCount(),
                "The count of dropdowns is unexpected");
    }

    @Then("User table contains following values:")
    public void checkTableContainsCorrectInformation(List<UserStructure> userInfo) {
        List<UserStructure> namesWithText = createListOfUsersInformation(userTablePage.getNames(),
                userTablePage.getTextDescription());
        SoftAssert softAssert = new SoftAssert();
        int length = userInfo.size();
        for (int i = 0; i < length; i++) {
            softAssert.assertEquals(namesWithText.get(i).toString(), userInfo.get(i).toString());
        }
        softAssert.assertAll();
    }

    @Then("log row has '([^\"]*)' text in log section")
    public void checkRowInLogAfterClickOnVipCheckbox(String text) {
        assertTrue(userTablePage.getTextFromLog().stream().anyMatch(row -> row.contains(text)));
    }

    @Then("droplist for '([^\"]*)' contains values")
    public void dropListElementsAssertion(UserNumberOfDropdownOnUserTablePage user, List<String> expectedElements) {
        List<String> temp = new Select(userTablePage.getDropDownSelect().get(user.getNumber()))
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(temp, equalTo(expectedElements));
    }

    private List<UserStructure> createListOfUsersInformation(List<String> names, List<String> texts) {
        List<UserStructure> namesWithText = new ArrayList<>();
        int length = names.size();
        UserStructure temp;
        for (int i = 0; i < length; i++) {
            temp = new UserStructure();
            temp.setNumber(Integer.toString(i + 1));
            temp.setUser(names.get(i));
            temp.setDescription(texts.get(i));
            namesWithText.add(temp);
        }
        return namesWithText;

    }

    private void checkLogSection(String option, String isSelected) {
        String lineOfTheLog;
        lineOfTheLog = differentElementsPage.getLineOfTheLog();
        if (optionInTheCheckBoxEnum(option)) {
            assertTrue(lineOfTheLog.contains(isSelected));
        }
        assertTrue(lineOfTheLog.contains(option));
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

