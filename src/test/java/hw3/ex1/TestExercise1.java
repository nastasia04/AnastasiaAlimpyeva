package hw3.ex1;

import hw3.enums.ElementsCount;
import hw3.enums.Header;
import hw3.enums.PageTitles;
import hw3.enums.Url;
import hw3.base.BaseClass;
import hw3.steps.HomePageSteps;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestExercise1 extends BaseClass {
    private HomePageSteps step;
    private static final List<String> expectedHeaderMenuText = Arrays.asList
            ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    private static final List<String> expectedTextOnTheIndexPage = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    @Test
    public void TestForExercise1() {
        step = new HomePageSteps(driver);
        //5. Assert Browser title
        step.checkHomePageTitle(PageTitles.HOMEPAGE);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        step.checkHeaderItems(expectedHeaderMenuText);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        step.checkImagesAreDisplayed(ElementsCount.IMAGES.getCount());

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        step.checkTextsUnderTheIconsAreDisplayed(expectedTextOnTheIndexPage);

        //9. Assert a text of the main headers
        step.checkTextOfTheMainHeaders(Header.MAINHEADER, Header.MAINHEADERTEXT);

        //10. Assert that there is the iframe in the center of page
        step.checkIFrameIsDisplayed();

        //11-12. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        // and switch back to original window
        step.checkEpamLogoOnIFrame();

        //13. Assert a text of the sub header
        step.checkTextOfTheSubHeader(Header.GITHUB_HEADER);

        //14. Assert that JDI GITHUB is a link and has a proper URL
        step.checkLink(Url.GITHUB);

        //15. Assert that there is Left Section
        step.checkLeftSectionIsDisplayed();

        //16. Assert that there is Footer
        step.checkFooterIsDisplayed();
    }
}