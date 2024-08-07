package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ManagerPage;

import static context.TestContext.driver;

public class ManagerSteps {

    ManagerPage managerPage = new ManagerPage();

    @Then("the button {string} should be displayed")
    public void the_button_should_be_displayed(String buttonName) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
       Assertions.assertTrue(button.isDisplayed(), "Button '" + buttonName + "' is not displayed");
    }
}
