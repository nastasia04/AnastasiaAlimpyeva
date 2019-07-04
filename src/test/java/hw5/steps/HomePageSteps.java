package hw5.steps;

import hw3.enums.Header;
import hw3.enums.PageTitles;
import hw3.enums.Url;
import hw3.pages.HomePage;
import hw3.user.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HomePageSteps extends BaseTestSteps {
    HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public void loginAndCheck(User user) {
        homePage.login(user.getLogin(), user.getPassword());
        assertEquals(homePage.getUserName(),
                user.getName(), "The user name is unexpected");
    }

    public void checkHomePageTitle(PageTitles expectedTitle) {
        checkPageTitle(homePage.getPageTitle(), expectedTitle.toString());
    }
    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void checkHeaderItems(List<String> expectedHeaderMenuText) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getElementsFromHeaderSection(),
                expectedHeaderMenuText.size());
        checkItemsHaveTheCorrectText(homePage.getTextFromElementsFromHeaderSection(), expectedHeaderMenuText);
    }
    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void checkImagesAreDisplayed(int imageCount) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getIconsFromHomePage(), imageCount);
    }
    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text\n")
    public void checkTextsUnderTheIconsAreDisplayed(List<String> expectedText) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getWebElementsUnderTheIcons(), expectedText.size());
        checkItemsHaveTheCorrectText(homePage.getTextUnderTheIcons(), expectedText);
    }

    @Step("Assert a text of the main headers")
    public void checkTextOfTheMainHeaders(Header mainHeader, Header mainHeaderText) {
        checkElementIsDisplayedAndHaveCorrectText(homePage.getMainHeader(), mainHeader.toString());
        checkElementIsDisplayedAndHaveCorrectText(homePage.getMainHeaderText(), mainHeaderText.toString());
    }
    @Step("Assert that there is the iframe in the center of page")
    public void checkIFrameIsDisplayed() {

        checkElementIsDisplayed(homePage.getIFrame());
    }

    @Step("Switch to the iframe and check that there is Epam logo in the left top conner of iframe" +
            " and switch back to original window")
    public void checkEpamLogoOnIFrame() {
        homePage.switchToIFrame();
        assertTrue(homePage.epamLogoIsDisplayed(), "Epam_logo is not displayed");
        homePage.switchBackToHomeWindow();
    }
    @Step("Assert a text of the sub header")
    public void checkTextOfTheSubHeader(Header expectedSubHeaderText) {
        checkElementIsDisplayedAndHaveCorrectText(homePage.getSubHeader(),
                expectedSubHeaderText.toString());
    }
    @Step("Assert that JDI GITHUB is a link and has a proper URL '{0}")
    public void checkLink(Url expectedLink) {
        assertEquals(homePage.getLink(), expectedLink.toString(), "The link is wrong");
    }
    @Step("Assert that there is Left Section")
    public void checkLeftSectionIsDisplayed() {

        checkElementIsDisplayed(homePage.getLeftSection());
    }
    @Step("Assert that there is Footer")
    public void checkFooterIsDisplayed() {

        checkElementIsDisplayed(homePage.getFooter());
    }
    private void checkElementIsDisplayedAndHaveCorrectText(WebElement webElement, String expectedText) {
        checkElementIsDisplayed(webElement);
        checkTheCorrectText(webElement.getText(), expectedText);
    }
    private void checkItemsAreDisplayedAndHaveCorrectLength(List<WebElement> actualText,
                                                            int expectedLength) {
        checkSizeOfTheListOfElements(actualText, expectedLength);
        checkElementsFromTheListAreDisplayed(actualText);
    }
}
