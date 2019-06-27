package hw3.steps;

import hw3.enums.Header;
import hw3.enums.PageTitles;
import hw3.enums.Url;
import hw3.user.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import hw3.pages.HomePage;

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

    public void checkHeaderItems(List<String> expectedHeaderMenuText) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getElementsFromHeaderSection(),
                expectedHeaderMenuText.size());
        checkItemsHaveTheCorrectText(homePage.getTextFromElementsFromHeaderSection(), expectedHeaderMenuText);
    }

    public void checkImagesAreDisplayed(int imageCount) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getIconsFromHomePage(), imageCount);
    }

    public void checkTextsUnderTheIconsAreDisplayed(List<String> expectedText) {
        checkItemsAreDisplayedAndHaveCorrectLength(homePage.getWebElementsUnderTheIcons(), expectedText.size());
        checkItemsHaveTheCorrectText(homePage.getTextUnderTheIcons(), expectedText);
    }

    public void checkTextOfTheMainHeaders(Header mainHeader, Header mainHeaderText) {
        checkElementIsDisplayedAndHaveCorrectText(homePage.getMainHeader(), mainHeader.toString());
        checkElementIsDisplayedAndHaveCorrectText(homePage.getMainHeaderText(), mainHeaderText.toString());
    }

    public void checkIframeIsDisplayed() {

        checkElementIsDisplayed(homePage.getIframe());
    }

    public void checkEpamLogoOnIframe() {
        homePage.switchToIframe();
        assertTrue(homePage.epamLogoIsDisplayed(), "Epam_logo is not displayed");
        homePage.switchBackToHomeWindow();
    }

    public void checkTextOfTheSubHeader(Header expectedSubHeaderText) {
        checkElementIsDisplayedAndHaveCorrectText(homePage.getSubHeader(),
                expectedSubHeaderText.toString());
    }

    public void checkLink(Url expectedLink) {
        assertEquals(homePage.getLink(), expectedLink.toString(), "The link is wrong");
    }

    public void checkLeftSectionIsDisplayed() {

        checkElementIsDisplayed(homePage.getLeftSection());
    }

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
