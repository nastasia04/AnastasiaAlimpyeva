package hw4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class TableWithPages extends BasePage {

    @FindBy(name = "table-with-pages_length")
    private SelenideElement dropdownEntities;

    @FindBy(name = "log-sidebar")
    private SelenideElement rightSection;

    @FindBy(xpath = "//table[@id='table-with-pages']/tbody/tr")
    private ElementsCollection tableWithPages;

    @FindBy(xpath = "//input[@type='search']")
    private SelenideElement searchField;


    public ElementsCollection getTableWithPages() {
        return tableWithPages;
    }

    public SelenideElement getFirstLineInLogWithLength() {
        return $(By.xpath("//li[contains(.,'length')][1]"));
    }

    public SelenideElement getDropdownEntities() {
        return dropdownEntities;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }
}