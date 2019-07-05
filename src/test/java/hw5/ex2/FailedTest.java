package hw5.ex2;

import hw3.enums.ElementsCount;
import hw3.enums.Header;
import hw3.enums.PageTitles;
import hw3.enums.Url;
import hw5.base.BaseClass;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FailedTest extends BaseClass {
    private HomePageSteps step;
    private static final List<String> expectedHeaderMenuText = Arrays.asList
            ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS", "WRONG TEXT");
    private static final List<String> expectedTextOnTheIndexPage = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable", "Wrong text");

    @Test
    @Story(value = "Test fails")
    @Feature(value = "Exercise2")
    @Description("Some tests are fail")
    public void TestForExercise1() {
        step = new HomePageSteps(driver);
        //5. Assert Browser title
        step.checkHomePageTitle(PageTitles.WRONGHOMEPAGE);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        step.checkHeaderItems(expectedHeaderMenuText);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        step.checkImagesAreDisplayed(ElementsCount.IMAGES.getCount());

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        step.checkTextsUnderTheIconsAreDisplayed(expectedTextOnTheIndexPage);

        //9. Assert a text of the main headers
        step.checkTextOfTheMainHeaders(Header.WRONGHEADER, Header.WRONGHEADER);

        //10. Assert that there is the iframe in the center of page
        step.checkIFrameIsDisplayed();

        //11-12. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        // and switch back to original window
        step.checkEpamLogoOnIFrame();

        //13. Assert a text of the sub header
        step.checkTextOfTheSubHeader(Header.WRONGHEADER);

        //14. Assert that JDI GITHUB is a link and has a proper URL
        step.checkLink(Url.GITHUB);

        //15. Assert that there is Left Section
        step.checkLeftSectionIsDisplayed();

        //16. Assert that there is Footer
        step.checkFooterIsDisplayed();
    }
}
