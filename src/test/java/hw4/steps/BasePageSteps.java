package hw4.steps;

import hw4.enums.PageTitles;
import hw4.pages.BasePage;
import hw4.user.User;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;


public class BasePageSteps extends CommonSteps {
    private BasePage basePage;

    public BasePageSteps() {

        basePage = new BasePage();
    }

    public BasePageSteps loginAndCheck(User user) {
        basePage.login(user.getLogin(), user.getPassword()).
                getUserName().shouldHave(exactText(user.getName()));
        return this;
    }

    public BasePageSteps checkHomePageTitle(PageTitles expectedTitle) {
        checkPageTitle(basePage.getPageTitle(), expectedTitle.toString());
        return this;
    }

    public BasePageSteps checkDropDownAfterClickingServiceAtHeader(List<String> expectedText) {
        List<String> actualText = basePage.clickOnSubCategoryServiceHeader().getServiceDropDownHeaderText();
        checkItemsHaveTheCorrectText(actualText, expectedText);
        return this;
    }

    public BasePageSteps checkDropDownAfterClickingServiceAtLeftSection(List<String> expectedText) {
        List<String> actualText = basePage.clickOnSubCategoryServiceLeft().getServiceDropDownLeftSectionText();
        checkItemsHaveTheCorrectText(actualText, expectedText);
        return this;
    }
}
