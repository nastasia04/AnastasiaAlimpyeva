package hw2.ex1;

import hw2.base.BaseClass;
import hw2.steps.StepsForExercise1;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestExercise1 extends BaseClass {
    private StepsForExercise1 step;
    // TODO It is better use 'private static final' modifier for constants
    private List<String> expectedHeaderMenuText = Arrays.asList
            ("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    private List<String> expectedTextOnTheIndexPage = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    private String mainHeader = "EPAM framework Wishes…";
    private String mainHeaderText = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
            "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

    @Test
    public void TestForExercise1() {

        step = new StepsForExercise1(driver);
        //5. Assert Browser title
        baseTestSteps.checkPageTitle("Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        step.checkItemsAreDisplayedAndHadTheCorrectText("//ul[contains(@class, 'm-l8')]/li",
                expectedHeaderMenuText);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        step.checkImagesAreDisplayed(4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        step.checkItemsAreDisplayedAndHadTheCorrectText("//span[@class='benefit-txt']",
                expectedTextOnTheIndexPage);

        //9. Assert a text of the main headers
        step.checkTextIsDisplayedAndEqualsToExpectedResult(
                "//h3[@name='main-title']", mainHeader);
        step.checkTextIsDisplayedAndEqualsToExpectedResult("//p[@name='jdi-text']",
                mainHeaderText);

        //10. Assert that there is the iframe in the center of page
        step.checkElementIsDisplayed("//iframe[@id='iframe']");

        //11-12. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        // and switch back to original window
        step.checkEpamLogoOnTeIframe();

        //13. Assert a text of the sub header
        step.checkTextIsDisplayedAndEqualsToExpectedResult("//a[contains(.,'JDI')]",
                "JDI Github");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        step.checkLink("//a[contains(.,'JDI')]", "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        step.checkElementIsDisplayed("//div[@id='mCSB_1']");

        //16. Assert that there is Footer
        step.checkElementIsDisplayed("//div[@class='footer-bg']");
    }
}
