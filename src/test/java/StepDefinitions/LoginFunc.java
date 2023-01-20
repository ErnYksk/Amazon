package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunc {

    DialogContent dc=new DialogContent();
    @Given("Navigate to Trendyol")
    public void navigateToTrendyol() {
        GWD.getDriver().get("https://www.trendyol.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.findAndClick("acceptCookies");
        dc.findAndClick("acceptCookies");
        dc.findAndClick("loginButton");
        dc.findAndSend("email","enterYourEmail");
        dc.findAndSend("password","enterYourPassword");
        dc.findAndClick("submitLogin");

    }

    @Then("User should be login successfully")
    public void userShouldBeLoginSuccessfully() {
        dc.findAndContainsText("hesabim","Hesabım");
    }

    @When("Enter invalid username and password")
    public void enterInvalidUsernameAndPassword() {

        dc.findAndClick("acceptCookies");
        dc.findAndClick("acceptCookies");
        dc.findAndClick("loginButton");
        dc.findAndSend("email","enterWrongEmail");
        dc.findAndSend("password","enterWrongPassword");
        dc.findAndClick("submitLogin");

    }

    @Then("User should not be able to login")
    public void userShouldNotBeAbleToLogin() {
        dc.findAndContainsText("invalidDataLogin","hatalı");
    }
}
