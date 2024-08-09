package stepdefinitions;

import pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import utils.ConfigurationReader;

import static context.TestContext.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) throws InterruptedException {
        WebElement button = null;
        if (buttonName.equals("Customer Login")) {
            button =loginPage.customerLoginButton;
        } else if (buttonName.equals("Bank Manager Login")) {
            button = loginPage.BankManagerLoginButton;
        }
        if (button != null) {
            button.click();
        }
        Thread.sleep(1000);
    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String pageName) {
        String expectedUrl = "";
        if (pageName.equals("Customer Login")) {
            expectedUrl = ConfigurationReader.get("customer_url");
        } else if (pageName.equals("Bank Manager Login")) {
            expectedUrl = ConfigurationReader.get("manager_url");
        }
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }
}
