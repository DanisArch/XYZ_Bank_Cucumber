package CucumberXYZBank.stepdefinitions;

import CucumberXYZBank.pages.LoginPage;
import io.cucumber.java.en.Given;

import static CucumberXYZBank.context.TestContext.*;

public class OverAllSteps {
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void userIsOnTheLoginPage() {
        if (loginPage.customerLoginButton.isDisplayed()) {
            scenario.log("User on login page");
        }
    }
}