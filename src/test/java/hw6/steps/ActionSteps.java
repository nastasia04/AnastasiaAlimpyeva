package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.*;
import hw6.user.User;
import hw6.utils.UtilsFunctions;
import org.testng.Assert;


public class ActionSteps extends BaseSteps {
    private static final String USERDATA = "src/test/resources/properties/user.properties";

    @When("I login as user '([^\"]*)'")
    public void login(String userName) {
        User user = UtilsFunctions.readUserFromFile(USERDATA);
        if (userName.equals(user.getName())) {
            homePage.login(user.getLogin(), user.getPassword());
        } else
            Assert.fail(("Unable to login as " + userName));
    }

    @When("I click on Service button in Header")
    public void clickOnServiceMenuItemInHeader() {
        homePage.clickOnSubCategoryServiceHeader();
    }

    @When("I click on Service button in Left section")
    public void clickOnServiceMenuItemAtLeftSection() {
        differentElementsPage.clickOnSubCategoryServiceLeft();
    }

    @When("in dropdown list I click on Different elements option")
    public void openDifferentElementsPage() {
        differentElementsPage.clickDifferentElements();
    }

    @When("I select checkboxes '(WATER|EARTH|WIND|FIRE)' on Different Elements page")
    public void selectItemInTheCheckBox(CheckBox option) {
        differentElementsPage.selectItemFromCheckBox(option);
    }

    @When("I select radio '(GOLD|SILVER|BRONZE|SELEN)' on Different Elements page")
    public void selectItemInTheRadio(Radio option) {
        differentElementsPage.selectItemFromRadio(option);
    }

    @When("I select in dropdown '(YELLOW|RED|BLUE|GREEN)' on Different Elements page")
    public void selectItemInTheDropDown(DropDown option) {
        differentElementsPage.clickOnDropDown().selectItemFromDropDown(option);
    }

    @When("I click on User Table button in Service dropdown")
    public void openUserTablePage() {
        userTablePage.clickOnUserTableButton();
    }

    @When("I select vip checkbox for '([^\"]*)'")
    public void selectVipCheckBox(UsersToVipCheckBoxes user) {
        userTablePage.vipCheckBoxIvanClick(user.getIdVipCheckBox());
    }

    @When("I click on dropdown in column Type for user '([^\"]*)'")
    public void openDropDownFor(UserNumberOfDropdownOnUserTablePage user) {
        userTablePage.getDropDownSelect().get(user.getNumber()).click();
    }
}
