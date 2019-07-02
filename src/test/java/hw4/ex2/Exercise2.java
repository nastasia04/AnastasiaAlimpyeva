package hw4.ex2;

import hw4.base.BaseClass;
import hw4.enums.PageTitles;
import hw4.steps.MetalAndColorsSteps;
import hw4.utils.MetalAndColorsDataBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Exercise2 extends BaseClass {
    @Test(dataProvider = "DataForEx2")
    public void TestForExercise2(MetalAndColorsDataBuilder builder) {
        MetalAndColorsSteps steps = new MetalAndColorsSteps();
        //2-3 steps
        basicSteps.checkHomePageTitle(PageTitles.HOMEPAGE).loginAndCheck(user);
        //4-6. Click on the link on the Header section, click submit and check result block
        steps.goToMetalsAndColorsPageAndCheckIt(PageTitles.METALSANDCOLORS)
                .fillFormOnPage(builder)
                .submit()
                .checkLog(builder);

    }

    @DataProvider(name = "DataForEx2")
    public static Object[][] getTestData() {
        return new Object[][]{
                {
                        MetalAndColorsDataBuilder
                                .builder()
                                .elements(Arrays.asList("Earth"))
                                .color("Yellow")
                                .metal("Gold")
                                .build()
                },
                {
                        MetalAndColorsDataBuilder
                                .builder()
                                .summary(Arrays.asList("3", "8"))
                                .vegetable(Arrays.asList("Cucumber", "Tomato"))
                                .build()
                },
                {
                        MetalAndColorsDataBuilder
                                .builder()
                                .summary(Arrays.asList("3", "2"))
                                .elements(Arrays.asList("Water", "Wind", "Fire"))
                                .metal("Gold")
                                .vegetable(Arrays.asList("Onion"))
                                .build()
                },
                {
                        MetalAndColorsDataBuilder
                                .builder()
                                .summary(Arrays.asList("6", "5"))
                                .elements(Arrays.asList("Water"))
                                .color("Green")
                                .metal("Selen")
                                .vegetable(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion"))
                                .build()
                },
                {
                        MetalAndColorsDataBuilder
                                .builder()
                                .elements(Arrays.asList("Fire"))
                                .color("Blue")
                                .vegetable(Arrays.asList("Cucumber", "Tomato", "Vegetables"))
                                .build()
                }
        };
    }
}
