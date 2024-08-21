package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AccountPage;
import utils.ConfigurationReader;

import static context.TestContext.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountSteps {
    AccountPage accountPage = new AccountPage();

    @When("user clicks on the {string} button")
    public void theUserClicksOnTheButtonOptions(String buttonName) throws InterruptedException {
        WebElement button = null;
        if (buttonName.equals("Transactions")) {
            button = accountPage.transactionsButton;
        } else if (buttonName.equals("Deposit")) {
            button = accountPage.depositButton;
        } else if (buttonName.equals("Withdrawl")) {
            button = accountPage.withdrawlButton;
        }
        if (button != null) {
            button.click();
        }
        Thread.sleep(1000);
    }

    @Then("user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String pageName) {
        String expectedUrl = "";
        if (pageName.equals("Transactions")) {
            expectedUrl = ConfigurationReader.get("transactions_url");
        } else if (pageName.equals("Deposit") || pageName.equals("Withdrawl")) {
            expectedUrl = ConfigurationReader.get("account_url");
        }
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }


    @When("the user enters the {string} to be deposited")
    public void makeDeposit(String amount) {
 //       amount = "4000";
        accountPage.amountToBeDeposited.sendKeys(amount);
    }

    @And("the user clicks on the Deposit button")
    public void theUserEntersTheAmountToBeDeposited() throws InterruptedException {
        accountPage.putMoneyOnDepositButton.click();
    }

    @Then("system deposit confirmation")
    public void systemDepositConfirmation() {
        assertEquals("Deposit Successful", accountPage.systemInformation.getText().toString());
    }

    @When("the user enters the {string} to be withdrawed")
    public void theUserEntersTheAmountToBeWithdrawed(String amount) {
        amount = "100";
        accountPage.amountToBeWithdrawn.sendKeys(amount);
    }

    @And("the user clicks on the Withdraw button")
    public void theUserClicksOnTheWithdrawButton() {
        accountPage.withdrawMoneyButton.click();
    }
    @When("the user enters a large the {string} to be withdrawed")
    public void theUserEntersALargeTheAmountToBeWithdrawed(String amount) {
        amount = "10000";
        accountPage.amountToBeWithdrawn.sendKeys(amount);
    }

    @Then("system negative withdraw confirmation")
    public void systemNegativeWithdrawConfirmation() {
        assertEquals("Transaction Failed. You can not withdraw amount more than the balance.", accountPage.systemInformation.getText().toString());
    }

    @Then("system withdraw confirmation")
    public void systemWithdrawConfirmation() {
        assertEquals("Transaction successful", accountPage.systemInformation.getText().toString());
    }
}


