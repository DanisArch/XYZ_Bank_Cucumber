package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CustomerPage;

import static context.TestContext.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerSteps {

    CustomerPage customerPage = new CustomerPage();

    @And("the user selects {string} from the user dropdown")
    public void theUserSelectsFromTheUserDropdown(String userName) {
        customerPage.userSelect.click();
        Select userSelect = new Select(driver.findElement(By.id("userSelect")));
        userSelect.selectByVisibleText(userName);
    }

    @And("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        customerPage.loginButton.click();
    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToTheAccountPage(String pageName) {
        String expectedUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

    }
}
