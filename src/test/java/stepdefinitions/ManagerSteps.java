package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddNewCustomerPage;
import pages.ManagerPage;

import java.util.List;

import static context.TestContext.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerSteps {

    AddNewCustomerPage addNewCustomerPage = new AddNewCustomerPage();
     ManagerPage managerPage = new ManagerPage();

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
}
