package hw4.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.attribute;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public abstract class CommonSteps {

    protected void checkPageTitle(SelenideElement actualTitle, String expectedTitle) {
        actualTitle.shouldHave(attribute("text", expectedTitle));
    }

    protected void checkElementIsDisplayed(SelenideElement selenideElement) {
        selenideElement.shouldBe(Condition.visible);
    }

    protected void checkItemsHaveTheCorrectText(List<String> actualText, List<String> expectedText) {
        assertThat(listToLowerCase(actualText), hasItems(isIn(listToLowerCase(expectedText))));
    }

    protected List<String> listToLowerCase(List<String> words) {
        return words.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}