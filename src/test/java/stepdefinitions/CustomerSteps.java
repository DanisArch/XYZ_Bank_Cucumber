package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CustomerPage;

import java.util.List;

import static context.TestContext.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerSteps {

    CustomerPage customerPage = new CustomerPage();

    @And("the user selects {string} from the user dropdown")
    public void theUserSelectsFromTheUserDropdown(String userName) {
        customerPage.userSelect.click();
        Select userSelect = new Select(customerPage.userSelect);
        userSelect.selectByVisibleText(userName);
    }

    @And("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() throws InterruptedException {
        customerPage.loginButton.click();
        Thread.sleep(1000);
    }

    @Then("the user should be redirected to the Account page")
    public void theUserShouldBeRedirectedToTheAccountPage() {
        String expectedUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Then("the user dropdown should contain {string}")
    public void theUserDropdownShouldContainString(String userName) {
        Select userSelect = new Select(customerPage.userSelect);
        List<WebElement> options = userSelect.getOptions();
        boolean userFound = options.stream().anyMatch(option -> option.getText().equals(userName));
        Assertions.assertTrue(userFound, "User not found in dropdown");
    }
}
