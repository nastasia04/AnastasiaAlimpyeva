package hw4.steps;

import com.codeborne.selenide.SelenideElement;
import hw4.enums.PageTitles;
import hw4.pages.MetalAndColorsPage;
import hw4.utils.MetalAndColorsDataBuilder;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;

public class MetalAndColorsSteps extends CommonSteps {
    MetalAndColorsPage metalAndColorsPage;

    public MetalAndColorsSteps() {
        metalAndColorsPage = new MetalAndColorsPage();
    }

    public MetalAndColorsSteps goToMetalsAndColorsPageAndCheckIt(PageTitles expectedTitle) {
        SelenideElement title = metalAndColorsPage.clickMetalsAndColorsButton().getPageTitle();
        checkPageTitle(title, expectedTitle.toString());
        return this;
    }

    public MetalAndColorsSteps fillFormOnPage(MetalAndColorsDataBuilder builder) {
        if (builder.getSummary() != null) {
            builder.getSummary().stream().forEach(element -> metalAndColorsPage.getSummarySection().findBy(text(element)).click());
        }
        if (builder.getElements() != null) {
            builder.getElements().stream().forEach(element -> metalAndColorsPage.getElementsSection().findBy(text(element)).click());
        }
        if (builder.getVegetable() != null) {
            metalAndColorsPage.getVegetablesDropdownButton().click();
            emptyForm();
            builder.getVegetable().stream().forEach(element -> metalAndColorsPage.getVegetable().findBy(text(element)).click());
        }
        if (builder.getColor() != null) {
            metalAndColorsPage.getColorsButton().click();
            metalAndColorsPage.getColors().findBy(text(builder.getColor())).click();
        }
        if (builder.getMetal() != null) {
            metalAndColorsPage.getMetalsButton().click();
            metalAndColorsPage.getMetals().findBy(text(builder.getMetal())).click();
        }
        return this;
    }

    public MetalAndColorsSteps submit() {
        metalAndColorsPage.clickSubmitButton();
        return this;
    }

    public MetalAndColorsSteps checkLog(MetalAndColorsDataBuilder builder) {

        String str;
        if (builder.getSummary() != null) {
            int result = builder.getSummary().stream().mapToInt(Integer::valueOf).sum();
            metalAndColorsPage.getItemFromResultBlock("Summary").shouldHave(text(String.valueOf(result)));
        }
        if (builder.getElements() != null) {
            str = builder.getElements().stream().collect(Collectors.joining(", "));
            metalAndColorsPage.getItemFromResultBlock("Elements").shouldHave(text(str));
        }
        if (builder.getVegetable() != null) {
            str = builder.getVegetable().stream().collect(Collectors.joining(", "));
            metalAndColorsPage.getItemFromResultBlock("Vegetables: ").shouldHave(text(str));
        }
        if (builder.getColor() != null) {
            metalAndColorsPage.getItemFromResultBlock("Color").shouldHave(text(builder.getColor()));
        }
        if (builder.getMetal() != null) {
            metalAndColorsPage.getItemFromResultBlock("Metal").shouldHave(text(builder.getMetal()));
        }
        return this;
    }

    private void emptyForm(){
        metalAndColorsPage.getVegetable().findBy(text("Vegetables")).click();
    }
}

