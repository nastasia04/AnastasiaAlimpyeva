package hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class MetalAndColorsPage extends BasePage {

    @Getter
    @FindBy(xpath = "//section[@class='horizontal-group']/p")
    private ElementsCollection summarySection;
    @Getter
    @FindBy(xpath = "//section[@class='vertical-group']/p")
    private ElementsCollection elementsSection;

    @Getter
    @FindBy(xpath = "//button[@title='Colors']")
    private SelenideElement colorsButton;
    @Getter
    @FindBy(xpath = "//div[@id='colors']//li")
    private ElementsCollection colors;

    @Getter
    @FindBy(xpath = "//button[@title='Metals']//span[@class='caret']")
    private SelenideElement metalsButton;
    @Getter
    @FindBy(xpath = "//div[@id='metals']//li")
    private ElementsCollection metals;

    @Getter
    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
    private SelenideElement vegetablesDropdownButton;
    @Getter
    @FindBy(xpath = "//div[@id='salad-dropdown']//li//a")
    private ElementsCollection vegetable;

    @FindBy(xpath = "//button[text()='Submit']")
    private SelenideElement submitButton;

    public MetalAndColorsPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public SelenideElement getItemFromResultBlock(String item) {
        return $(By.xpath("//ul[contains(@class,'panel-body-list results')]/li[contains(.,'" +
                item + "')]"));
    }
}
