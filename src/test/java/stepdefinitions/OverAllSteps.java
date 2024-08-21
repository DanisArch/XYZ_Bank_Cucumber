package stepdefinitions;

import pages.LoginPage;
import io.cucumber.java.en.Given;

import static context.TestContext.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OverAllSteps {
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void userIsOnTheLoginPage() {

        if (loginPage.customerLoginButton.isDisplayed()) {
            scenario.log("User on login page");
        }
        //Добавить асерт по проверке assertTrue(loginPage.customerLoginButton.isDisplayed());
    }
}