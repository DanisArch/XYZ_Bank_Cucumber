package stepdefinitions;

import context.ScenarioContext;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.AccountPage;
import pages.AddNewCustomerPage;
import pages.ManagerPage;
import pages.OpenNewAccountPage;

import java.util.List;

import static context.TestContext.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerSteps {

    AddNewCustomerPage addNewCustomerPage = new AddNewCustomerPage();
    ManagerPage managerPage = new ManagerPage();
    OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage();
    AccountPage accountPage = new AccountPage();

    @Then("the button {string} should be displayed")
    public void theButtonShouldBeDisplayed(String buttonName) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
       assertTrue(button.isDisplayed(), "Button '" + buttonName + "' is not displayed");
    }

    @And("the user clicks on the Add Customer button")
    public void theUserClicksOnTheAddCustomerButton() {
        managerPage.addNewCustomerButton.click();
    }

    @And("the user enters {string} as first name, {string} as last name, {string} as post code")
    public void addNewCustomer(String firstName, String lastName, String postCode) {
        addNewCustomerPage.userFirstName.sendKeys(firstName);
        addNewCustomerPage.userLastName.sendKeys(lastName);
        addNewCustomerPage.postCode.sendKeys(postCode);
    }
    @And("the user clicks on the Add Customer form button")
    public void theUserClicksOnTheAddCustomerFormButton() {
        addNewCustomerPage.addNewCustomerButton.click();
    }

    @Then("the alert message should be {string}")
    public void theAlertMessageShouldBe(String expectedMessage) {
        String alertMessage = driver.switchTo().alert().getText();
        assertTrue(alertMessage.contains(expectedMessage.split(":")[0]), "Alert message does not match expected message.");
        driver.switchTo().alert().accept();
    }

    @When("the user clicks on the Customers button")
    public void theUserClicksOnTheCustomersButton() {
        managerPage.showAllCustomersButton.click();
    }

    @Then("the table should contain a customer with first name {string} and last name {string}")
    public void theTableShouldContainThisCustomer(String fName, String lName) {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr"));
        boolean customerFound = rows.stream().anyMatch(row ->
                row.findElement(By.xpath("td[1]")).getText().equals(fName) &&
                        row.findElement(By.xpath("td[2]")).getText().equals(lName)
        );
        assertTrue(customerFound, "Customer not found in the table.");
    }

    @When("the User clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
        button.click();
    }

    @And("the user selects {string} from the customer dropdown")
    public void theUserSelectsFromTheCustomerDropdown(String customerName) {
        Select customerSelect = new Select(openNewAccountPage.customerName);
        customerSelect.selectByVisibleText(customerName);
    }
    @And("the user selects {string} from the currency dropdown")
    public void the_user_selects_from_the_currency_dropdown(String currency) {
        Select currencySelect = new Select(openNewAccountPage.selectCurrency);
        currencySelect.selectByVisibleText(currency);
    }
    @Then("the alert message should contain {string}")
    public void theAlertMessageShouldContain(String expectedMessage) {
  //      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        TestContext.wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        assertTrue(alertMessage.contains(expectedMessage), "Alert message does not contain expected text.");
        driver.switchTo().alert().accept();
        // Извлекаю номер счета из сообщения
        String accountNumber = alertMessage.replaceAll("[^0-9]", ""); // Убираю все, кроме цифр
        // Сохраняю номер счета для дальнейшего использования
        ScenarioContext.setContext("AccountNumber", accountNumber);
    }

    @When("the user logs out and returns to the login page")
    public void theUserLogsOutAndReturnsToTheLoginPage() {
        managerPage.homeButton.click();
    }

    @Then("the account dropdown should contain an account in Pound")
    public void theAccountDropdownShouldContainAnAccountIn(String currency) {
        Select accountSelect = new Select(accountPage.listAccountNummerCustomer);
        List<WebElement> options = accountSelect.getOptions();
        // Получаю ранее сохраненный номер счета
        String expectedAccountNumber = (String) ScenarioContext.getContext("AccountNumber");
        System.out.println(expectedAccountNumber);
        boolean accountFound = options.stream().anyMatch(option -> option.getText().contains(expectedAccountNumber));
        assertTrue(accountFound, "Account with number " + expectedAccountNumber + " not found in the dropdown.");
    }
}
