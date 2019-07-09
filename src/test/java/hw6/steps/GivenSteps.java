package hw6.steps;

import cucumber.api.java.en.Given;
import hw3.enums.Url;
import hw6.hooks.Context;

public class GivenSteps extends BaseSteps {

    @Given("I am on Home page")
    public void openHomePage() {
        Context.getDriver().get(Url.HOME.toString());
    }
}
