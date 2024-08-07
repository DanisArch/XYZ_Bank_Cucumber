package stepdefinitions;

import pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

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
//        Thread.sleep(3000);
    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String pageName) {
        String expectedUrl = "";
        if (pageName.equals("Customer Login")) {
            expectedUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
        } else if (pageName.equals("Bank Manager Login")) {
            expectedUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
        }
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }
}
