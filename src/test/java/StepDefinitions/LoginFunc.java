package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunc {

    DialogContent dc=new DialogContent();
    @Given("Navigate to Amazon")
    public void navigateToAmazon() {
        GWD.getDriver().get("https://www.amazon.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.findAndClick("loginButton");
        dc.findAndSend("email","");
        dc.findAndClick("submitEmail");
        dc.findAndSend("password","");
        dc.findAndClick("submitLogin");

    }

    @Then("User should be login successfully")
    public void userShouldBeLoginSuccessfully() {
        dc.findAndContainsText("accountAssertion","Hello");
    }

    @When("Enter invalid username and password")
    public void enterInvalidUsernameAndPassword() {


        dc.findAndClick("loginButton");
        dc.findAndSend("email","something@gmail.com");
        dc.findAndClick("submitEmail");
        dc.findAndSend("password","1234abc");
        dc.findAndClick("submitLogin");

    }

    @Then("User should not be able to login")
    public void userShouldNotBeAbleToLogin() {
        dc.findAndContainsText("invalidDataLogin","Important");
    }
}
